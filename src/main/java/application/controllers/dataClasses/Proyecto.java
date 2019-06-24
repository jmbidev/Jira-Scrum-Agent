package application.controllers.dataClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
    private String id;
    private String id_atlassian;
    private Date fecha;
    private List<Spring> springs = new ArrayList<>();

    public Proyecto() {
    }

    public void addSpring(Spring spring) {
        this.springs.add(spring);
    }

    public List<Spring> getSprings() {
        return springs;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
