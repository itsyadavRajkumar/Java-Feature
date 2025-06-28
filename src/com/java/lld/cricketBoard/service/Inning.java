package com.java.lld.cricketBoard.service;

import com.java.lld.cricketBoard.constants.MatchConstants;
import com.java.lld.cricketBoard.entity.Ball;
import com.java.lld.cricketBoard.entity.Player;
import com.java.lld.cricketBoard.entity.Team;

public class Inning {
    private Team team;
    private int currentOver;
    private int currentBall;
    private int strikerIndex;
    private int nonStrikerIndex;
    private int nextBatsManIndex;

    public Inning(Team team) {
        this.team = team;
        this.currentOver = 0;
        this.currentBall = 0;
        this.strikerIndex = 0;
        this.nonStrikerIndex = 1;
        this.nextBatsManIndex = 2;
    }

    public void playBall(Ball ball) {
        Player striker = team.getPlayers().get(strikerIndex);
        if (ball.isWickets()) {
            striker.setOut();
            team.incrementWickets();
            if (team.getWickets() < MatchConstants.TEAM_SIZE - 1) {
                strikerIndex = nextBatsManIndex;
                nextBatsManIndex++;
            }
        } else {
            if (!ball.isExtra()) {
                striker.addRuns(ball.getRuns());
                team.addRuns(ball.getRuns());
                currentBall++;
                if (ball.getRuns() % 2 != 0) {
                    swapStrike();
                }
            } else {
                team.addRuns(ball.getRuns());
            }

            if (currentBall == MatchConstants.BALL_PER_OVER) {
                currentBall = 0;
                currentOver++;
                swapStrike();
            }
        }
    }

    public void swapStrike() {
        int temp = strikerIndex;
        strikerIndex = nonStrikerIndex;
        nonStrikerIndex = temp;
    }

    public boolean isOver() {
        return currentOver >= MatchConstants.MAX_OVER || team.getWickets() == MatchConstants.TEAM_SIZE - 1;
    }

    public int getCurrentOver() {
        return currentOver;
    }

    public int getCurrentBall() {
        return currentBall;
    }
}
