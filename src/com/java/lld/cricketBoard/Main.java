package com.java.lld.cricketBoard;

import com.java.lld.cricketBoard.service.Match;

public class Main {
    public static void main(String[] args) {
        Match match = new Match("India", "Nepal");
        match.start();
    }
}
