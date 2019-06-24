package application.controllers.dataClasses;

public class Usuario {
    private String id;
    private String id_atlassian;

    public Usuario() {
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
}
