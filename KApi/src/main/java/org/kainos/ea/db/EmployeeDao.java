package org.kainos.ea.db;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createDeliveryEmployee(EmployeeRequest employee) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String insertStatement = "INSERT INTO Employee (Id, Name, Salary, BankAccountNumber, NationalInsuranceNumber) VALUES (?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, employee.getId());
        st.setString(2, employee.getName());
        st.setFloat(3, employee.getSalary());
        st.setString(4, employee.getBankAccountNumer());
        st.setString(5, employee.getNationalInsuranceNumber());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        String insertStatement2 = "INSERT INTO DeliveryEmployee (EmployeeId) VALUES ( ? )";

        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement st2 = c.prepareStatement(insertStatement2, Statement.RETURN_GENERATED_KEYS);
            st2.setInt(1, id);
            st2.executeUpdate();
        }
        return -1;

    }

    public int createSalesEmployee(SalesEmployeeRequest employee) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String insertStatement = "INSERT INTO Employee (Id, Name, Salary, BankAccountNumber, NationalInsuranceNumber) VALUES (?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, employee.getId());
        st.setString(2, employee.getName());
        st.setFloat(3, employee.getSalary());
        st.setString(4, employee.getBankAccountNumer());
        st.setString(5, employee.getNationalInsuranceNumber());
        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();

        String insertStatement2 = "INSERT INTO SalesEmployee (EmployeeId, CommissionRate) VALUES (?, ?)";


        if (rs.next()) {
            int id = rs.getInt(1);
            PreparedStatement st2 = c.prepareStatement(insertStatement2, Statement.RETURN_GENERATED_KEYS);
            st2.setInt(1, id);
            st2.setFloat(2, employee.getCommissionRate());
            st2.executeUpdate();
        }
        return -1;
    }





    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT EmployeeId, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM Employee INNER JOIN DeliveryEmployee ON Employee.Id = DeliveryEmployee.EmployeeId ;");
        List<DeliveryEmployee> DeliveryEmployeeList = new ArrayList<>();

        while (rs.next()){
            DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber")
            );
            DeliveryEmployeeList.add(deliveryEmployee);
        }
        return DeliveryEmployeeList;
    }

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT EmployeeId, Name, Salary, BankAccountNumber, NationalInsuranceNumber, CommissionRate  FROM Employee INNER JOIN SalesEmployee ON Employee.Id = SalesEmployee.EmployeeId ;");
        List<SalesEmployee> SalesEmployeeList = new ArrayList<>();

        while (rs.next()){
            SalesEmployee salesEmployee = new SalesEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber"),
                    rs.getDouble("CommissionRate")

            );
            SalesEmployeeList.add(salesEmployee);
        }
        return SalesEmployeeList;
    }

    public DeliveryEmployee getDeliveryEmployeeById(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT EmployeeId, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM Employee INNER JOIN DeliveryEmployee ON Employee.Id = DeliveryEmployee.EmployeeId WHERE Employee.ID="+id);


        while (rs.next()){
            return new DeliveryEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber")
            );
        }
        return null;
    }

    public SalesEmployee getSalesEmployeeById(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT EmployeeId, Name, Salary, BankAccountNumber, NationalInsuranceNumber, CommissionRate FROM Employee INNER JOIN SalesEmployee ON Employee.Id = SalesEmployee.EmployeeId WHERE Employee.ID=" +id);

        while (rs.next()){
            return new SalesEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name"),
                    rs.getFloat("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber"),
                    rs.getDouble("CommissionRate")
            );
        }
        return null;
    }

    public void updateSalesEmployee(int id, SalesEmployee employee) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE SalesEmployee SET Name = ?, Salary = ?, BankAccountNumber = ?, CommissionRate = ? WHERE EmployeeId = ?";
        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getName());
        st.setFloat(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNumber());
        st.setString(2, employee.getCommissionRate());
        st.setInt(4, id);

        st.executeUpdate();

    }

    public void updateDeliveryEmployee(int id, DeliveryEmployee employee) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String updateStatement = "UPDATE DeliveryEmployee SET Name = ?, Salary = ?, BankAccountNumber = ? WHERE EmployeeId = ?";
        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getName());
        st.setFloat(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNumber());
        st.setInt(4, id);

        st.executeUpdate();

    }

    public void deleteEmployee(int id, Employee employee) throws SQLException{
        Connection c = databaseConnector.getConnection();
        String deleteStatement = "DELETE FROM Employee WHERE Id = ?";
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(1, id);
        st.executeUpdate();
    }
}
