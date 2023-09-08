package org.kainos.ea.cli;

public class Report {
    public Report(int projectId, String employeeName, String deliveryEmployees) {
        ProjectId = projectId;
        EmployeeName = employeeName;
        DeliveryEmployees = deliveryEmployees;
    }

    private int ProjectId;
    private String EmployeeName;
    private String DeliveryEmployees;
}
