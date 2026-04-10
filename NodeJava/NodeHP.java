package com.xatandcatch.survivalhorror.logic;

/**
 * NodeHP: The native health node for Survival-Horror.
 * Connects directly to the Global Metadata Storer.
 */
public class NodeHP {
    
    private int currentHP;
    private final int MAX_HP = 100;
    private boolean isDead = false;

    public NodeHP() {
        this.currentHP = MAX_HP;
    }

    // Reduces HP when attacked by Granny
    public void takeDamage(int amount) {
        if (!isDead) {
            currentHP -= amount;
            if (currentHP <= 0) {
                currentHP = 0;
                isDead = true;
                handlePlayerDeath();
            }
            // Syncs the new HP to the Global Metadata Storer
            syncHPToGlobal();
        }
    }

    private void syncHPToGlobal() {
        // Logic to write currentHP into localMetadataRender/DataBridge.bin
    }

    private void handlePlayerDeath() {
        // Trigger the 3D "Game Over" screen in the renderer
    }

    public int getCurrentHP() {
        return currentHP;
    }
}
