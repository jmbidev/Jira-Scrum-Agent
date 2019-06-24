package application.controllers.dataClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Spring {
    private String id;
    private String id_atlassian;
    private Date fechaIni;
    private Date fechaFin;
    private List<Issue> issues= new ArrayList<>();
    public Spring() {
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_atlassian() {
        return id_atlassian;
    }

    public void setId_atlassian(String id_atlassian) {
        this.id_atlassian = id_atlassian;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}

