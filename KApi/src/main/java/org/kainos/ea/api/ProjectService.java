package org.kainos.ea.api;


import org.kainos.ea.client.*;

import java.sql.SQLException;


import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Project;
import org.kainos.ea.db.ClientDao;
import org.kainos.ea.db.EmployeeDao;
import org.kainos.ea.db.ProjectDao;

import java.util.Collections;
import java.util.List;


public class ProjectService {

    private ProjectDao projectDao = new ProjectDao();
    private ClientDao clientDao = new ClientDao();
    private EmployeeDao employeeDao = new EmployeeDao();

    public List<Project> getAllProjects() throws FailedToGetProjectsException {
        try {
            List<Project> projectList = projectDao.getAllProjects();
            return projectList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetProjectsException();
        }
    }

    public Project getProjectById(int id) throws FailedToGetProjectByIdException, ProjectDoesNotExistException {
        try {
            Project project = projectDao.getProjectById(id);
            if (project == null) {
                throw new ProjectDoesNotExistException();
            }
            return project;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetProjectByIdException();
        }
    }

    public void assignDeliveryEmployees(List<Integer> employeeIds, int projectId) throws FailedToGetDeliveryEmployeeException, FailedToAssignDeliveryEmployeeException {
        try {
            for (int employeeId : employeeIds) {
                DeliveryEmployee deliveryEmployeeToAssign = employeeDao.getEmployeeById(employeeId);
                if (deliveryEmployeeToAssign == null) {
                    throw new DeliveryEmployeeDoesNotExistException();
                }
                projectDao.assignDeliveryEmployees(employeeId, Collections.singletonList(projectId));
            }
        } catch (SQLException | DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToAssignDeliveryEmployeeException();
        }

    }

    public void removeEmployee(int employeeId, int projectId) throws FailedToRemoveEmployeeException, FailedToUpdateProjectException {
        try {
            Employee EmployeeToRemove = employeeDao.getEmployeeById(employeeId);
            if (EmployeeToRemove == null) {
                throw new EmployeeDoesNotExistException();
            }

            projectDao.removeEmployee(employeeId, projectId);
        } catch (SQLException | DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        } catch (EmployeeDoesNotExistException e) {
            throw new RuntimeException(e);
        }

    }

    public void assignClientToProject(int clientId, int projectId) throws FailedToGetClientException, FailedToAssignClientToProjectException, FailedToUpdateProjectException {
        try {
            Client clientToAssign = clientDao.getClientById(clientId);
            if (clientToAssign == null) {
                throw new ClientDoesNotExistException();
            }

            projectDao.assignClientToProject(clientId, projectId);
        } catch (SQLException | ClientDoesNotExistException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        }

    }

    public List<Project> getAllProjectsAssignedToClient(int clientId) throws FailedToGetAllProjectsAssignedToClientException, FailedToGetProjectsAssignedToClientException {
        try {
            List<Project> projectsAssignedToClientList = projectDao.getAllProjectsAssignedToClient(clientId);

            return projectsAssignedToClientList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsAssignedToClientException();
        }
    }

    public ClientValue getClientWithHighestValue() throws FailedToGetClientProjectValueException, FailedToGetTotalValueOfProjectsException {
        try {
            ClientValue getClientWithHighestValue = clientDao.getClientWithHighestValue();
            return getClientWithHighestValue;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetTotalValueOfProjectsException();
        }
    }

    public boolean setProjectAsCompleted(int projectId) throws FailedToSetProjectAsCompletedException {
        try {
            return projectDao.setProjectAsCompleted(projectId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToSetProjectAsCompletedException();
        }
    }

    public void assignTechLeadToProject(int techLeadId, int projectId) throws FailedToAssignTechLeadToProjectException, FailedToUpdateProjectException {
        try {
            Employee techLeadToAssign = clientDao.getTechLeadById(techLeadId);
            if (techLeadToAssign == null) {
                throw new NoTechLeadAvailableException();
            }
            projectDao.assignTechLeadToProject(techLeadId, projectId);
        } catch (SQLException | NoTechLeadAvailableException e) {
            System.err.println(e.getMessage());
            throw new FailedToUpdateProjectException();
        }

    }

    public List<DeliveryEmployee> getAllDeliveryEmployeesAssignedToProject(int projectId) throws FailedToGetDeliveryEmployeesAssignedToProjectsException, FailedToGetDeliveryEmployeesAssignedToProject {
        try {
            List<DeliveryEmployee> deliveryEmployeeListAssignedToProject = employeeDao.getAllDeliveryEmployeesAssignedToProject(projectId);
            return deliveryEmployeeListAssignedToProject;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetDeliveryEmployeesAssignedToProject();
        }
    }

    public List<Report> getClientReport() throws FailedToGetClientReportException {
        try {
            List<Report> clientReport = clientDao.getClientReport();
            return clientReport;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetClientReportException();
        }
    }

    public List<Report> getProjectReport() throws FailedToGetProjectReport {
        try {
            List<Report> projectReport = projectDao.getProjectReport();
            return projectReport;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetProjectReport();
        }
    }
}
