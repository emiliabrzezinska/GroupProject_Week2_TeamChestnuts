package org.kainos.ea.db;

import org.kainos.ea.cli.ClientValue;
import org.kainos.ea.cli.Report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    public List<Report> getClientReport() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Client.Id, Employee.Name, GROUP_CONCAT( Project.Id SEPARATOR ' , ') as `Projects` FROM Client INNER JOIN Employee ON Client.SalesRepresentativeId = Employee.Id INNER JOIN Project ON Client.Id = Project.ClientId WHERE Project.IsCompleted != 1 GROUP BY Client.Id;");
        List<Report> reportList = new ArrayList<>();

        while (rs.next()){
            Report report = new Report(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getString("Projects")
            );
            reportList.add(report);
        }
        return reportList;
    }

    public ClientValue getClientWithHighestValue() throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT Client.Name, SUM(Project.Value) as 'Value' FROM Client LEFT JOIN Project ON Client.Id = Project.ClientId ) GROUP BY Client.Name ORDER BY SUM(VALUE) DESC LIMIT 1;" );

        while(rs.next()){
            return new ClientValue(
                    rs.getString("Name"),
                    rs.getFloat("Value")
            );
        }
        return null;
    }
}
