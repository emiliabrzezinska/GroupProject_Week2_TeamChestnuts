package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest extends EmployeeRequest {
    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("employeeId") int employeeId,
            @JsonProperty("name") String name,
            @JsonProperty("salary") float salary,
            @JsonProperty("bankAccountNumber") String bankAccountNumber,
            @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber) {
        super(employeeId, name, salary, bankAccountNumber, nationalInsuranceNumber);

    }
}
