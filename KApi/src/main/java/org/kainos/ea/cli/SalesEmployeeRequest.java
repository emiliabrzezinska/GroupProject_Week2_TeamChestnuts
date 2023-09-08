package org.kainos.ea.cli;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {
private String name;
private int salary;
private String bankAccountNumber;
private String nationalInsuranceNumber;
private int employeeId;
private float commissionRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    @JsonCreator

    public SalesEmployeeRequest (

        @JsonProperty("name") String name,
        @JsonProperty("salary") int salary,
        @JsonProperty("bankAccountNumber") String bankAccountNumber,
        @JsonProperty ("nationalInsuranceNumber") String nationalInsuranceNumber,
        @JsonProperty ("employeeId") int employeeId,
        @JsonProperty ("commissionRate") float commissionRate) {

            this.name = name;
            this.salary = salary;
            this.bankAccountNumber = bankAccountNumber;
            this.nationalInsuranceNumber = nationalInsuranceNumber;
            this.employeeId = employeeId;
            this.commissionRate = commissionRate;
        }


    }




