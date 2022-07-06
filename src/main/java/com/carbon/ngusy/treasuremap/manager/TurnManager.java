package com.carbon.ngusy.treasuremap.manager;

import com.carbon.ngusy.treasuremap.model.Adventurer;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {
    private static List<Adventurer> adventurers = new ArrayList<>();

    /**
     * Return the list of adventurers
     * @return list of adventurers
     */
    public static List<Adventurer> getAdventurers() {
        return adventurers;
    }

    /**
     * Add one adventurer to the list of adventurers
     * @param adventurer
     */
    public static void addAdventurer(Adventurer adventurer) {
        TurnManager.adventurers.add(adventurer);
    }

    /**
     * Handles every adventurers' turn
     */
    public static void playAllAdventurers() {
        System.out.println("Executing adventurers' movements\n");

        boolean isStillPlaying = true;

        while(isStillPlaying) {
            isStillPlaying = false;

            for (Adventurer adventurer : TurnManager.adventurers) {
                if(AdventurerTurnManager.hasMovesLeft(adventurer))
                    AdventurerTurnManager.play(adventurer);

                if(AdventurerTurnManager.hasMovesLeft(adventurer))
                    isStillPlaying = true;

            }
        }

        System.out.println("End of every adventurers' turn\n");
    }
}
