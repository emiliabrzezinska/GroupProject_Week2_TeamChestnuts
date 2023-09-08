package org.kainos.ea.cli;

public class SalesEmployee {
    private float comissionRate;

    public SalesEmployee(float comissionRate) {
        setComissionRate(comissionRate);
    }

    public float getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(float comissionRate) {
        this.comissionRate = comissionRate;
    }
}