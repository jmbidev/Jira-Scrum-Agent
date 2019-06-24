package application.logica_del_agente;

import application.controllers.dataClasses.Issue;
import application.controllers.dataClasses.Tag;
import application.controllers.dataClasses.Usuario;
import application.controllers.database.DataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Agent {
    private DataBase dataBase;

    public Map<Usuario, HashMap<Issue, Double>> getSuggestedAssign(List<Issue> newIssues, List<Usuario> newUsers, int maxPointsPerUser) {
        //obtener los votos de los usuarios para las issues pasadas
        Map<Usuario, HashMap<Issue, Double>> votesPerPastIssue = dataBase.getVotesForIssuesPerUser().entrySet().stream().
                filter(e -> newUsers.contains(e.getKey())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        HashMap<Usuario, HashMap<Tag, Double>> votesPerTag = new HashMap<>();
        HashMap<Usuario, HashMap<Tag, Double>> countOfVotesPerTag = new HashMap<>();
        //traducir los votos de issues pasadas a votos para cada tag, para luego puntuar las issues nuevas
        votesPerPastIssue.forEach((currectUser, value) -> {
            if (!votesPerTag.containsKey(currectUser)) {
                votesPerTag.put(currectUser, new HashMap<>());
                countOfVotesPerTag.put(currectUser, new HashMap<>());
            }
            HashMap<Tag, Double> votesForCurrentUser = votesPerTag.get(currectUser);
            HashMap<Tag, Double> countOfVotesForCurrentUser = countOfVotesPerTag.get(currectUser);
            votesPerPastIssue.get(currectUser).forEach((currentIssue, score) -> {
                for (Tag tag : currentIssue.getTags()) {
                    if (!countOfVotesForCurrentUser.containsKey(tag)) {
                        countOfVotesForCurrentUser.put(tag, 0d);
                    }
                    Double countOfVotesForCurrentUserPerCurrentTag = countOfVotesForCurrentUser.get(tag);
                    votesForCurrentUser.put(tag, ((votesForCurrentUser.get(tag) * countOfVotesForCurrentUserPerCurrentTag) + score) / ++countOfVotesForCurrentUserPerCurrentTag);
                }
            });
        });
        //ponderar los valores de cada usuario en cada nueva issue en base a los tags de las nuevas issues
        Map<Usuario, HashMap<Issue, Double>> scorePerUserPerIssue = new HashMap<>();
        newUsers.forEach(usuario -> scorePerUserPerIssue.put(usuario, new HashMap<>()));
        newUsers.forEach(currentUser -> newIssues.forEach(currentIssue -> {
            HashMap<Issue, Double> scoresForCurrentUser = scorePerUserPerIssue.get(currentUser);
            if (!scoresForCurrentUser.containsKey(currentIssue)) scoresForCurrentUser.put(currentIssue, 0d);
            double tagsCount = 0d;
            for (Tag tag : currentIssue.getTags())
                scoresForCurrentUser.put(currentIssue, ((scoresForCurrentUser.get(currentIssue) * tagsCount++ + votesPerTag.get(currentUser).get(tag)) / tagsCount));
        }));
        //devolvemos los puntajes de las issues nuevas para los usuarios estimados en base a valoraciones de issues anteriores
        return scorePerUserPerIssue;
    }
}
