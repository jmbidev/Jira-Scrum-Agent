package application.response;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDevResponse {

    private Integer id;
    private Integer idAtlassian;
    private String name;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAtlassian() {
        return idAtlassian;
    }

    public void setIdAtlassian(Integer idAtlassian) {
        this.idAtlassian = idAtlassian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
