package application.agentlogic;

import java.util.List;
import java.util.*;
public class Issue {

    private int id ;
    private List<String> labels ;
    private int timeEstimate ;
    private int historyPoints;
    private int priority ; // 1 lowest, 2 low 3 medium 4high 5highest
    private Date creationDate;
    private int userId;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Issue(int id, List<String> label, int time, int storypoints, int priority ) {
        this.id = id;
        this.labels = label;
        this.timeEstimate = time;
        this.historyPoints = storypoints;
        this.priority = priority;
    }

    public Issue(int id, List<String> label, int time, int storypoints, int priority , int userId) {
        this.id = id;
        this.labels = label;
        this.timeEstimate = time;
        this.historyPoints = storypoints;
        this.priority = priority;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void addLabel(String newLabel) {
        this.labels.add(newLabel);
    }

    public void deleteLabel(String label)
    {
        this.labels.remove(label);

    }

    public int getTime() {
        return timeEstimate;
    }

    public void setTime(int time) {
        this.timeEstimate = time;
    }

    public int getStorypoints() {
        return historyPoints;
    }

    public void setStorypoints(int storypoints) {
        this.historyPoints = storypoints;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}