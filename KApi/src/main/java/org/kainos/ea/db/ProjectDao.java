package org.kainos.ea.db;

import java.sql.*;
import java.util.ArrayList;

public class ProjectDao {

    public Project getProjectById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Name FROM Project WHERE Id=" +id);

        while (rs.next()){
            return new Project(
                    rs.getString("Name")
            );
        }
        return null;
    }

    public void assignDeliveryEmployee(int ProjectId, int EmployeeId) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String updateStatement = "INSERT INTO Project_DeliveryEmployee (ProjectId, EmployeeId, IsActive) VALUES (?,?,?) ";
        PreparedStatement st =c.prepareStatement(updateStatement);
        st.setInt(1, ProjectId);
        st.setInt(2, EmployeeId);
        st.setInt(3, 1);

        st.executeUpdate();
    }

    public void removeDeliveryEmployee(int ProjectId, int EmployeeId) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE Project_DeliveryEmployee SET IsActive = ? WHERE ProjectId = ? AND EmployeeID = ?";
        PreparedStatement st =c.prepareStatement(updateStatement);
        st.setInt(1, 0);
        st.setInt(2, ProjectId);
        st.setInt(3, EmployeeId);

        st.executeUpdate();
    }

    public void assignClientToProject(int ProjectId, int ClientId) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE Project SET ClientID = ? WHERE Id = ?";
        PreparedStatement st =c.prepareStatement(updateStatement);
        st.setInt(1, ClientId);
        st.setInt(2, ProjectId);
        st.executeUpdate();
    }




    public List<ProjectReport> getprojectreports(int ProjectId) throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Project.Name, group_concat( DeliveryEmployee.EmployeeId separator " , ") FROM Project INNER JOIN Project_DeliveryEmployee ON Project.Id = Project_DeliveryEmployee.ProjectId INNER JOIN DeliveryEmployee ON Project_DeliveryEmployee.EmployeeId = DeliveryEmployee.EmployeeId GROUP BY Project.Name");
                List<ProjectReport> projectReport = new ArrayList<>();

        while (rs.next()){
            Project ProjectReport = new projectReport(
                    rs.getString("Project.Name"),



            );
            SalesEmployeeList.add(salesEmployee);
        }
        return SalesEmployeeList;
    }




}
