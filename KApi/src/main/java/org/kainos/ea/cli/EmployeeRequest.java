package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private int employeeId;
    private String name;
    private float salary;
    private String bankAccountNumber;
    private String nationalInsuranceNumber;
    @JsonCreator
    public EmployeeRequest(
            @JsonProperty("employeeId") int employeeId,
            @JsonProperty("name") String name,
            @JsonProperty("salary") float salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
