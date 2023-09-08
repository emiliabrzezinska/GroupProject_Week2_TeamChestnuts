package org.kainos.ea.db;

import org.kainos.ea.cli.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int assignDeliveryEmployees(int ProjectId, List<Integer> EmployeeIds) throws SQLException {
        Connection c = databaseConnector.getConnection();
        for (int EmployeeId : EmployeeIds) {
            String insertStatement = "INSERT INTO Project_DeliveryEmployee (ProjectId, EmployeeId, IsActive) VALUES (?,?,?)";
            PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, ProjectId);
            st.setInt(2, EmployeeId);
            st.setInt(3, 1);
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public void removeEmployee(int ProjectId, int EmployeeId) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE Product SET IsActive = ? WHERE ProjectId= ? AND EmployeeId = ?";
        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, 0);
        st.setInt(2, ProjectId);
        st.setInt(3, EmployeeId);
        st.executeUpdate();
    }


    public void assignClientToProject(int ProjectId, int ClientId) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET ClientId = ? WHERE ProjectId = ? ";
        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, ClientId);
        st.setInt(2, ProjectId);
        st.executeUpdate();
    }

    public boolean setProjectAsCompleted(int ProjectId) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET IsCompleted = ? WHERE ProjectId = ? ";
        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, 1);
        st.setInt(2, ProjectId);
        st.executeUpdate();

        return false;
    }

    public List<Report> getProjectReport() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Project.Id, Employee.Name, GROUP_CONCAT( DeliveryEmployee.EmployeeId SEPARATOR ' , ') as 'DeliveryEmployees' FROM Project INNER JOIN Project_DeliveryEmployee ON Project.Id = Project_DeliveryEmployee.ProjectId INNER JOIN Employee ON Project.TechLeadId = Employee.Id GROUP BY Project.Id;");
        List<Report> reportList = new ArrayList<>();

        while (rs.next()) {
            Report report = new Report(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getString("DeliveryEmployees")
            );
            reportList.add(report);
        }
        return reportList;
    }


}
