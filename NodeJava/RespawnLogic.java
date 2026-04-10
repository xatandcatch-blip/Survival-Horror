package com.xatandcatch.survivalhorror.logic;

/**
 * RespawnLogic: Handles the "Rebirth" after an extreme execution.
 * Ensures items are kept to prevent player rage.
 */
public class RespawnLogic {

    public static void respawnPlayer(NodeHP health, NodeStamina stamina, MoveLogic movement) {
        // 1. Reset Vitals
        health.resetHP(); // We'll add this method to NodeHP
        stamina.refill();  // We'll add this to NodeStamina
        
        // 2. Reset Position to Mansion Entrance
        movement.resetPosition(0.0f, 0.0f, 0.0f);

        // 3. Keep Inventory
        // We do NOT call inventory.clear(). 
        // The GlobalMetadataStorer keeps the Master Key locked.
        
        System.out.println("RESPAWN_COMPLETE: Vitals reset, Items retained.");
    }
}

