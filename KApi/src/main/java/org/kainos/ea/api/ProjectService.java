package org.kainos.ea.api;

import org.kainos.ea.client.*;

import java.sql.SQLException;

public class ProjectService {

    public List<Project> getAllProjects() throws FailedToGetProjectsException {
        try {
            List<Project> projectList = projectDao.getAllProjects();

            return projectList;
    } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsException();
        }
    }

    public Project getProjectById(int id) throws FailedToGetProjectsException, ProjectDoesNotExistException {
        try {
            Project project = projectDao.getProjectById(id);

            if (project == null) {
                throw new ProjectDoesNotExistException();
            }

        return project;
    } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsException();
        }
    }

    public void assignDeliveryEmployee(int employeeId, int projectId) throws FailedToGetDeliveryEmployeeException, FailedToAssignDeliveryEmployeeException {
        try {
            DeliveryEmployee deliveryEmployeeToAssign = employeeDao.getEmployeeById(id);

            if (deliveryEmployeeToAssign == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            projectDao.updateProject(projectId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }

    }

    public void removeDeliveryEmployee(int employeeId, int projectId) throws FailedToRemoveDeliveryEmployeeException {
        try {
            DeliveryEmployee deliveryEmployeeToRemove = employeeDao.getEmployeeById(id);

            if (deliveryEmployeeToRemove == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            projectDao.updateProject(projectId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }

    }

    public void assignClientToProject(int clientId, int projectId) throws FailedToGetClientException, FailedToAssignClientToProjectException {
        try {
            Client clientToAssign = ClientDao.getClientById(id);

            if (clientToAssign == null) {
                throw new ClientDoesNotExistException();
            }

            projectDao.updateProject(projectId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }

    }

    public List<Project> getAllProjectsAssignedToClient(int clientId) throws FailedToGetAllProjectsAssignedToClientException {
        try {
            List<Project> projectsAssignedToClientList = projectDao.getAllProjectsAssignedToClient();

            return projectsAssignedToClientList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsAssignedToClientException();
        }
    }

    public double sumClientProjectValue() throws FailedToGetClientProjectValueException {
        try {
            double totalValue = calculateTotalValue();
            return totalValue;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetTotalValueOfProjectsException();
        }
    }

    public boolean setProjectAsCompleted() throws FailedToSetProjectAsCompletedException {
        try {
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToSetProjectAsCompletedException();
        }
    }

    public void assignTechLeadToProject(int techLeadId) throws FailedToAssignTechLeadToProjectException {
        try {
            Employee TechLeadToAssign = clientDao.getTechLeadById;

            if (techLeadToAssign == null) {
                throw new NoTechLeadAvailableException();
            }
            projectDao.updateProject(projectId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }

    }

    public List<DeliveryEmployee> getAllDeliveryEmployeesAssignedToProject() throws FailedToGetDeliveryEmployeesAssignedToProjectsException {
        try {
            List<DeliveryEmployee> deliveryEmployeeListAssignedToProject = employeeDao.getAllDeliveryEmployeesAssignedToProject();

        return deliveryEmployeeListAssignedToProject;
    } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeesAssignedToProject();
        }
    }
}
