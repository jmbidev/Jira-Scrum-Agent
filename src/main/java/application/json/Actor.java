package application.json;

import application.services.CurrentUserService;
import application.services.RestService;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {
    @Autowired
    RestService restService;
    @Autowired
    CurrentUserService currentUserService;

    private String id;
    private String name;
    private String displayName;
    private String type;
    private User actorUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public User getActorUser() {
        return actorUser;
    }

    public void setActorUser(User user) {
        this.actorUser = user;
    }

}
