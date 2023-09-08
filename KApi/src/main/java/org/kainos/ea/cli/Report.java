package org.kainos.ea.cli;

public class Report {
    private int ProjectId;
    private String EmployeeName;
    private String DeliveryEmployees;

    public Report(int projectId, String employeeName, String deliveryEmployees) {
        ProjectId = projectId;
        EmployeeName = employeeName;
        DeliveryEmployees = deliveryEmployees;
    }

}
