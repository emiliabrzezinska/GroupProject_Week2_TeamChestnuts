package org.kainos.ea.cli;

public class Employee {
    private int employeeId;
    private String name;
    private float salary;
    private String bankAccountNumber;
    private String nationalInsuranceNumber;

    public Employee(int employeeId, String name, float salary, String bankAccountNumber, String nationalInsuranceNumber) {
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
        setBankAccountNumber(bankAccountNumber);
        setNationalInsuranceNumber(nationalInsuranceNumber);

    }

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
}
