package org.kainos.ea.cli;

public class SalesEmployee extends Employee {
    int employeeId;
    String name;
    float salary;
    String bankAccountNumber;
    String nationalInsuranceNumber;
    float comissionRate;

    public SalesEmployee(int employeeId, String name, float salary, String bankAccountNumber, String nationalInsuranceNumber, float comissionRate) {
        super(employeeId, name, salary, bankAccountNumber, nationalInsuranceNumber);
        setComissionRate(comissionRate);
    }

    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }
}