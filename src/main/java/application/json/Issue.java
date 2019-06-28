package application.json;


import com.fasterxml.jackson.databind.JsonSerializable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    private String timestamp;
    private String host;
    private String id;
    private String key;
    private String projectId;
    private String projectKey;
    private String projectName;
    private String timeSpent;
    private String aggregateTimeSpent;
    private String resolution;
    private String resolutionDate;
    private String createdDateTime;
    private String priorityId;
    private String issueType;
    private String priorityName;
    private List<String> labels;
    private String aggregateTimeOriginalEstimate;
    private String timeEstimate;
    private String assigneeId;
    private String assigneeEmail;
    private String assigneeDisplayName;
    private String updatedDateTime;
    private String statusId;
    private String statusName;
    private String statusCategory;
    private String timeOriginalEstimate;
    private String description;
    private String aggregateTimeEstimate;
    private String summary;
    private String dueDate;



    @SuppressWarnings("unchecked")
    @JsonProperty("issue")
    private void unpackNested(Map<String, Object> issue) {
        this.host = (String) issue.get("self");
        this.host = this.host.substring(0, this.host.indexOf("/rest"));
        this.id = (String) issue.get("id");
        this.key = (String) issue.get("key");
        Map<String,Object> fields = (Map<String,Object>)issue.get("fields");
        Map<String,Object> project = (Map<String,Object>)fields.get("project");
        if (project != null){
            this.projectId = (String)project.get("id");
            this.projectKey = (String)project.get("key");
            this.projectName = (String)project.get("name");
        }

        this.timeSpent = (String)fields.get("timespent");
        this.aggregateTimeSpent = (String)fields.get("aggregateTimeSpent");
        this.resolution = (String)fields.get("resolution");
        this.resolutionDate = (String)fields.get("resolutiondate");
        this.createdDateTime = (String)fields.get("created");
        Map<String,Object> priority = (Map<String,Object>)fields.get("priority");
        if (priority != null) {
            this.priorityId = (String) priority.get("id");
            this.priorityName = (String) priority.get("name");
        }
        this.issueType = (String)fields.get("issueType");
        this.labels = (List<String>) fields.get("labels");
        this.aggregateTimeOriginalEstimate = (String)fields.get("aggregateTimeOriginalEstimate");
        this.timeEstimate = (String)fields.get("timeestimate");
        Map<String, Object> assignee = (Map<String, Object>)fields.get("assignee");
        this.assigneeId = (String)assignee.get("accountId");
        this.assigneeEmail = (String)assignee.get("emailAddress");
        this.assigneeDisplayName = (String)assignee.get("displayName");
        this.updatedDateTime = (String)fields.get("updated");
        Map<String, Object> status = (Map<String, Object>)fields.get("status");
        this.statusId = (String)status.get("id");
        this.statusName = (String)status.get("name");
        this.statusCategory = status.get("statusCategory").toString();
        this.timeOriginalEstimate = (String)fields.get("timeoriginalestimate");
        this.description = (String) fields.get("description");
        this.aggregateTimeEstimate = (String) fields.get("aggregatetimeestimate");
        this.summary = (String) fields.get("summary");
        this.dueDate = (String) fields.get("duedate");
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(String updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public String getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getAggregateTimeOriginalEstimate() {
        return aggregateTimeOriginalEstimate;
    }

    public void setAggregateTimeOriginalEstimate(String agregateOriginalEstimate) {
        this.aggregateTimeOriginalEstimate = agregateOriginalEstimate;
    }

    public String getTimeOriginalEstimate() {
        return timeOriginalEstimate;
    }

    public void setTimeOriginalEstimate(String timeOriginalEstimate) {
        this.timeOriginalEstimate = timeOriginalEstimate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getAggregateTimeEstimate() {
        return aggregateTimeEstimate;
    }

    public void setAggregateTimeEstimate(String aggregateTimeEstimate) {
        this.aggregateTimeEstimate = aggregateTimeEstimate;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(String timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(String statusCategory) {
        this.statusCategory = statusCategory;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public void setAssigneeEmail(String assigneeEmail) {
        this.assigneeEmail = assigneeEmail;
    }

    public String getAssigneeDisplayName() {
        return assigneeDisplayName;
    }

    public void setAssigneeDisplayName(String assigneeDisplayName) {
        this.assigneeDisplayName = assigneeDisplayName;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getAggregateTimeSpent() {
        return aggregateTimeSpent;
    }

    public void setAggregateTimeSpent(String aggregateTimeSpent) {
        this.aggregateTimeSpent = aggregateTimeSpent;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(String resolutionDate) {
        this.resolutionDate = resolutionDate;
    }
}
