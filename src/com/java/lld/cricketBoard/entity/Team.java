package com.java.lld.cricketBoard.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private int totalRuns;
    private int wickets;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            players.add(new Player(name + "_Player" + i));
        }
        this.totalRuns = 0;
        this.wickets = 0;
    }

    public void addRuns(int run) {
        this.totalRuns += run;
    }

    public void incrementWickets() {
        this.wickets++;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getWickets() {
        return wickets;
    }
}
