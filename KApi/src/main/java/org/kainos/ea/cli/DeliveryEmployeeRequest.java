package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest extends Employee {


    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("employeeId") int employeeId,
            @JsonProperty("name") String name,
            @JsonProperty("salary") float salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber) {
        super(employeeId, name, salary, bankAccountNumber, nationalInsuranceNumber);
        this.setEmployeeId(employeeId);
        this.setName(name);
        this.setSalary(salary);
        this.setBankAccountNumber(bankAccountNumber);
        this.setNationalInsuranceNumber(nationalInsuranceNumber);
    }
}
