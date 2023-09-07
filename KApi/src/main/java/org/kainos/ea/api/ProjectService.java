package org.kainos.ea.api;

import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Project;

import java.util.List;

public class ProjectService {

    public Project getProjectById(int id) {
        Project project = projectDao.getProjectById(id);

        return project;
    }

    public void assignDeliveryEmployee(int id) {
        DeliveryEmployee deliveryEmployeeToAssign = projectDao.getProjectById(id);

    }

    public void removeDeliveryEmployee(int id) {
        DeliveryEmployee deliveryEmployeeToRemove = projectDao.getProjectById(id);

    }

    public void assignClientToProject(int id) {
        Client clientToAssign = projectDao.getProjectById(id);

    }

    public List<Project> getAllProjectsAssignedToClient() {
        List<Project> projectList = projectDao.getAllProjectsAssignedToClient();

        return projectList;
    }

    public
}
