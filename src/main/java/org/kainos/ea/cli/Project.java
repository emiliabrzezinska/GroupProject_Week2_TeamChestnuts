package org.kainos.ea.cli;

public class Project {
    private int projectId;
    private String name;
    private float value;
    private boolean isCompleted;
    private int clientId;
    private int techLeadId;

    public Project(int projectId, String name, float value, boolean isCompleted, int clientId, int techLeadId) {
        setProjectId(projectId);
        setName(name);
        setValue(value);
        setProjectId(projectId);
        setClientId(clientId);
        setTechLeadId(techLeadId);

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }
}
