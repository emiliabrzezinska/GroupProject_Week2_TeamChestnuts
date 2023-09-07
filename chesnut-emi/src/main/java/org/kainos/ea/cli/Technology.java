package org.kainos.ea.cli;

public class Technology {
    private int technologyId;
    private String name;

    public Technology(int technologyId, String name) {
        this.technologyId = technologyId;
        this.name = name;
    }

    public int getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(int technologyId) {
        this.technologyId = technologyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


