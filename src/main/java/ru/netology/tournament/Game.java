package ru.netology.tournament;

import java.util.ArrayList;
import java.util.List;


public class Game {
    List<Player> players = new ArrayList<>();

    public void registration(Player player) {
        players.add(player);
    }


    public Player findByName(String name) {
        for (Player player : players) {

            if (player.getName().equals(name)) {
                return player;
            }
        }

        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("this" + playerName1 + "is not registered in the game");
        }
        if (player2 == null) {
            throw new NotRegisteredException("this" + playerName2 + "is not registered in the game");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}




