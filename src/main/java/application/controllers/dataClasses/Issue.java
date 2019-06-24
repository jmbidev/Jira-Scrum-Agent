package application.controllers.dataClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue {
    private String id;
    private String id_atlassian;
    private Proyecto proyecto;
    private Date fechaIni;
    private Date fechaFin;
    private Usuario usuario;
    private int puntaje_dificultad;
    private List<Tag> tags= new ArrayList<>();
    public Issue() {
    }

    public String getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPuntaje_dificultad() {
        return puntaje_dificultad;
    }

    public void setPuntaje_dificultad(int puntaje_dificultad) {
        this.puntaje_dificultad = puntaje_dificultad;
    }


}
