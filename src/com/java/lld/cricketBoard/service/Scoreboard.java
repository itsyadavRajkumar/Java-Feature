package com.java.lld.cricketBoard.service;

import com.java.lld.cricketBoard.entity.Player;
import com.java.lld.cricketBoard.entity.Team;

public class Scoreboard {
    private Team team;

    public Scoreboard(Team team) {
        this.team = team;
    }

    public void display(int overs, int balls) {
        System.out.println("Team: " + team.getName());
        System.out.println("Score: " + team.getTotalRuns() + "/" + team.getWickets());
        System.out.println("Overs: " + overs + "." + balls);
        for (Player player : team.getPlayers()) {
            if (!player.isOut()) {
                System.out.println("Name: " + player.getName() + ", " + "Run: "
                        + player.getRun() + ", Ball Faced: " + player.getBallsFaced());
            } else if (player.getBallsFaced() > 0) {
                System.out.println("Name: " + player.getName() + ", " + "Run: "
                        + player.getRun() + ", Ball Faced: " + player.getBallsFaced());
            }
        }
        System.out.println("-----------------------");
    }
}
