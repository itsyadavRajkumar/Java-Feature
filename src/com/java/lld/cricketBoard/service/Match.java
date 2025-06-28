package com.java.lld.cricketBoard.service;

import com.java.lld.cricketBoard.entity.Ball;
import com.java.lld.cricketBoard.entity.Team;

import java.util.Random;

public class Match {
    private Team team1;
    private Team team2;

    public Match(String team1Name, String team2Name) {
        this.team1 = new Team(team1Name);
        this.team2 = new Team(team2Name);
    }

    public void start() {
        System.out.println("Match between " + team1.getName() + " and " + team2.getName());

        playInning(team1);
        playInning(team2);

        displayResult();
    }

    public void playInning(Team team) {
        Inning inning = new Inning(team);
        Scoreboard scoreboard = new Scoreboard(team);
        Random random = new Random();

        while (!inning.isOver()) {
            String[] outcome = {"0", "1", "2", "3", "4", "5", "6", "W", "WD"};
            String result = outcome[random.nextInt(outcome.length)];

            Ball ball;
            if (result.equals("W")) {
                ball = new Ball(0, true, false);
            } else if(result.equals("WD")) {
                ball = new Ball(1, false, true);
            } else {
                ball = new Ball(Integer.parseInt(result), false, false);
            }
            inning.playBall(ball);
            scoreboard.display(inning.getCurrentOver(), inning.getCurrentBall());
        }
    }

    public void displayResult() {
        System.out.println("Match Ended!!");
        System.out.println(team1.getName() + " score: " + team1.getTotalRuns());
        System.out.println(team2.getName() + " score: " + team2.getTotalRuns());

        if (team1.getTotalRuns() > team2.getTotalRuns()) {
            System.out.println(team1.getName() + " Won the match!!");
        }
        else if (team1.getTotalRuns() < team2.getTotalRuns()) {
            System.out.println(team2.getName() + " Won the match!!");
        } else {
            System.out.println("Match Tied!!");
        }
    }
}
