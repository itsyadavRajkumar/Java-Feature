package com.java.lld.cricketBoard.entity;

public class Ball {
    private int runs;
    private boolean isWickets;
    private boolean isExtra;

    public Ball(int runs, boolean isWickets, boolean isExtra) {
        this.runs = runs;
        this.isWickets = isWickets;
        this.isExtra = isExtra;
    }

    public int getRuns() {
        return runs;
    }

    public boolean isWickets() {
        return isWickets;
    }

    public boolean isExtra() {
        return isExtra;
    }
}
