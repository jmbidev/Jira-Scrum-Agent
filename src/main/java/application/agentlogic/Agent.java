package application.agentlogic;

import application.response.IssueResponse;
import application.response.TagResponse;
import application.response.UsuarioResponse;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.services.RequestService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Agent {

    @Autowired
    RequestService requestService;

    //no tendr�a que ser void sino un diccionario userId, IssueId
    public HashMap<IssueResponse, UsuarioResponse> AssignIssues(List<IssueResponse> issuesList, List<UsuarioResponse> users) // estos issues son los que queres asignar a las personas
    {
        int[][] matrix = new int[users.size()][issuesList.size()];

        int userIndex = 0;

        //For Usuario obtener todas sus Issues de la base
        for (UsuarioResponse user : users) {
            int issueIndex = 0;

            List<IssueResponse> userIssues = obtenerIssuesDeUsuario(user.getId());

            for (IssueResponse issue : issuesList) {
                int puntaje = (int) CalcularPuntaje(userIssues, issue);
                if (puntaje == 0)
                    puntaje++;
                matrix[userIndex][issueIndex] = puntaje;
                issueIndex++;
            }

            userIndex++;
        }



        JobAssigner<IssueResponse, UsuarioResponse> assigner = new JobAssigner<>();
        HashMap<IssueResponse, UsuarioResponse> assignedIssues = assigner.computeAssignment(matrix, issuesList, users);

        return assignedIssues;

    }


    public double CalcularPuntaje(List<IssueResponse> TotalIssues, IssueResponse issueAPuntuar) {
        // filtrar TotalIssues con todas las historias que se parezcan, y despues generar 2 listas, la del mes pasado y todas,
        //en algun momento x aca o en CalcularIssue deberiamos traernos el tiempo de finalizacion del sprint creo.

        List<IssueResponse> actualIssues = TotalIssues;//new ArrayList<Issue>();
        List<IssueResponse> historicoIssues = new ArrayList<IssueResponse>();//TotalIssues;
        double puntajeActual = 0;
        double puntajeHistorico = 0;
        for (IssueResponse issue : actualIssues) {
            puntajeActual = puntajeActual + CalcularIssue(issue, issueAPuntuar);
        }

        for (IssueResponse issue : historicoIssues) {
            puntajeHistorico = puntajeHistorico + CalcularIssue(issue, issueAPuntuar);
        }


        double ponderacionHistorico = 0;
        if (historicoIssues.size() > 0)
            ponderacionHistorico = 30 * (puntajeHistorico / historicoIssues.size());


        double ponderacionActual = 0;
        if (actualIssues.size() > 0)
            ponderacionActual = 70 * (puntajeActual / actualIssues.size());

        return (100 - ponderacionHistorico - ponderacionActual);
    }


    public double CalcularIssue(IssueResponse issueHistorica, IssueResponse issue) {
        double puntajeLabel = 0;
        double puntajePriority = 0;
        double puntajeStoryPoints = 0;
        double puntajeTimeEstimate = 0; // a definir ma�ana bien

        for (TagResponse label : issueHistorica.getTags()) {
            if (issue.getTags().contains(label))
                puntajeLabel++;
        }


        /** Labels **/
        if (issue.getTags().size() > 0)
            puntajeLabel = puntajeLabel / issue.getTags().size();


        /** Priority **/
        if (issue.getPrioridad().equals(issueHistorica.getPrioridad()))
            puntajePriority = 1;


        /** Story Points **/
        double storyDifference = Math.abs(issue.getStoryPoints() - issueHistorica.getStoryPoints());
        if (storyDifference > 5)
            puntajeStoryPoints = 0;
        else if (storyDifference > 2)
            puntajeStoryPoints = 0.5;
        else
            puntajeStoryPoints = 1;


        /** Time Estimate **/
        if (Math.abs(issue.getDiasEstimados() - issueHistorica.getDiasEstimados()) < 2) //si el timeEstimate es menor a 2 dias, se suma el puntaje
            puntajeTimeEstimate = 1;


        /** Se calcula el resultado final **/
        double result = 0.5 * puntajeLabel + 0.2 * puntajePriority + 0.2 * puntajeStoryPoints + 0.1 * puntajeTimeEstimate;

        /** TODO Falta multiplicar result por (0,5 * siLoTerminoATiempo) + (0,5 * valoracionDelUsuario) **/

        //result = result *  (1) * (0.1 * (issueHistorica.getDificultad())); // (0.5) * siLoTerminoATiempo
        return result;
    }



    private List<IssueResponse> obtenerIssuesDeUsuario(String userId){

        String responseRol = requestService.sendGetRequest("http://localhost:8080/data/my-issues/" + userId);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<IssueResponse> issueList = new ArrayList<>();
        try {
            issueList = mapper.readValue(responseRol, mapper.getTypeFactory().constructCollectionType(List.class, IssueResponse.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issueList;
    }


}
