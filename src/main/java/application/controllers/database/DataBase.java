package application.controllers.database;

import application.controllers.dataClasses.Issue;
import application.controllers.dataClasses.Usuario;

import java.util.HashMap;

public interface DataBase {
    HashMap<Usuario, HashMap<Issue, Double>> getVotesForIssuesPerUser();
}
