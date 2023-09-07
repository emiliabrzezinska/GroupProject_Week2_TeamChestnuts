package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private int employeeId;
    private String name;
    private float salary;
    private String bankAccountNumber;
    private String nationalInsuranceNumber;
    private int deliveryEmployeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public int getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(int deliveryEmployeeId) {
        this.deliveryEmployeeId = deliveryEmployeeId;
    }

    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("employeeId") int employeeId,
            @JsonProperty("name") String name,
            @JsonProperty("salary") float address,
            @JsonProperty("bankAccountNumber") String phoneNumber,
            @JsonProperty("nationalInsuranceNumber") String salesRepresentativeId,
            @JsonProperty("deliveryEmployeeId") int deliveryEmployeeId) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.bankAccountNumber = bankAccountNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
        this.deliveryEmployeeId = deliveryEmployeeId;
    }
}
