package org.kainos.ea.cli;

public class ProjectTechnology {
    private int projectId;
    private int technologyId;

    public ProjectTechnology(int projectId, int technologyId) {
        setProjectId(projectId);
        setTechnologyId(technologyId);
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }
}