package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {

    private float comissionRate;

    @JsonCreator
    public SalesEmployeeRequest(

            @JsonProperty("comissionRate") float comissionRate){
        this.comissionRate = comissionRate;
    }
}
