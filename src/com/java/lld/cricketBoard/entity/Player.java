package com.java.lld.cricketBoard.entity;

public class Player {
    private String name;
    private int run;
    private int ballsFaced;
    private boolean isOut;

    public Player(String name) {
        this.name = name;
        this.run = 0;
        this.ballsFaced = 0;
        this.isOut = false;
    }

    public void addRuns(int run) {
        this.run += run;
        this.ballsFaced++;
    }

    public void setOut() {
        this.isOut = true;
    }

    public String getName() {
        return name;
    }

    public int getRun() {
        return run;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public boolean isOut() {
        return isOut;
    }
}
