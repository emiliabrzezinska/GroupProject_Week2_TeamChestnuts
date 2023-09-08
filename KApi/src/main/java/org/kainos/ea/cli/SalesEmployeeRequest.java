package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest extends EmployeeRequest {

    private float comissionRate;


public SalesEmployeeRequest(

    @JsonProperty("employeeId") int employeeId,
    @JsonProperty("name") String name,
    @JsonProperty("salary") float salary,
    @JsonProperty("bankAccountNumber") String bankAccountNumber,
    @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber,
    @JsonProperty ("comissionRate")float comissionRate)

    {
        super(employeeId, name, salary, bankAccountNumber, nationalInsuranceNumber);
        this.comissionRate = comissionRate;
    }

}
