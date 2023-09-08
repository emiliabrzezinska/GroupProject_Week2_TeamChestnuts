package org.kainos.ea.cli;

public class SalesEmployee {
    private int salesEmployeeId;
    private float comissionRate;

    public SalesEmployee(int salesEmployeeId, float comissionRate) {
        setSalesEmployeeId(salesEmployeeId);
        setComissionRate(comissionRate);
    }

    public int getSalesEmployeeId() {
        return salesEmployeeId;
    }

    public void setSalesEmployeeId(int salesEmployeeId) {
        this.salesEmployeeId = salesEmployeeId;
    }

    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }
}