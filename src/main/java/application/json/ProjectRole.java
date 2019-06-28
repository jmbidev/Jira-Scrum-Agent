package application.json;

import application.services.CurrentUserService;
import application.services.RestService;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectRole {
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    RestService restService;

    private String self;
    private String id;
    private String name;
    private String description;
    private List<Actor> roleActors;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return roleActors;
    }

    public void setActors(List<Actor> actors) {
        this.roleActors = actors;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("actors")
    private void unpackNested(List<Object> actors) {
        this.roleActors = new LinkedList<>();
        for (Object o: actors) {
            Map<String,Object> actorMap = (Map<String,Object>) o;
            Actor actor = new Actor();
            actor.setId((String)actorMap.get("id"));
            actor.setDisplayName((String)actorMap.get("displayName"));
            actor.setName((String)actorMap.get("name"));
            actor.setType((String)actorMap.get("type"));
            Map<String, String> actorUser = (Map<String, String>) actorMap.get("actorUser");
            actor.setActorUser(restService.getUserByAccountId(actorUser.get("accountId"), currentUserService.getUser().getHost().getBaseUrl()));

            this.roleActors.add(actor);
        }
    }
}
