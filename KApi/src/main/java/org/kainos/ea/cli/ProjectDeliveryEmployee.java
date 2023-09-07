package org.kainos.ea.cli;

public class ProjectDeliveryEmployee {
    private boolean isActive;
    private int employeeId;
    private int projectId;

    public ProjectDeliveryEmployee(boolean isActive, int employeeId, int projectId) {
        setActive(isActive);
        setEmployeeId(employeeId);
        setProjectId(projectId);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}