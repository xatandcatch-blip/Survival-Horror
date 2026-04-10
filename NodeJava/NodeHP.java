package com.xatandcatch.survivalhorror.logic;

/**
 * NodeHP: The Ultimate Execution & Rebirth Engine.
 * Handles: 110 DMG, 18+ Gore Triggers, and Item-Safe Respawning.
 */
public class NodeHP {
    
    private int currentHP;
    private final int MAX_HP = 100;
    private boolean isDead = false;
    private String lastDeathReason = "None";

    // Security Gate for Extreme Content
    public static final String GORE_WARNING = "SYSTEM: 18+ EXTREME GORE ACTIVE. AGE VERIFICATION REQUIRED.";

    public NodeHP() {
        this.currentHP = MAX_HP;
        System.out.println(GORE_WARNING);
    }

    /**
     * Damage handler for Granny's lethal attacks.
     * @param amount 100 (Gun) or 110 (Heart Bite/Chainsaw)
     * @param reason The specific execution style for the metadata
     */
    public void takeDamage(int amount, String reason) {
        if (!isDead) {
            this.currentHP -= amount;
            this.lastDeathReason = reason;

            if (this.currentHP <= 0) {
                this.currentHP = 0;
                this.isDead = true;
                executeDeathSequence();
            }
            
            syncToBridge();
        }
    }

    /**
     * executeDeathSequence: Locks progress and triggers audio/visuals.
     */
    private void executeDeathSequence() {
        // 1. Lock the 'Dead' state in the Worldwide Metadata
        GlobalMetadataStorer.lockDeathState(lastDeathReason, currentHP);

        // 2. Trigger the extreme sounds (Screams/Chainsaw)
        SoundLogic sound = new SoundLogic();
        sound.triggerDeathSound(lastDeathReason);

        // 3. Log for the 3D Gore Shader (GoreUI.glsl)
        System.out.println("TRIGGER_GORE_OVERLAY: " + lastDeathReason);
    }

    /**
     * resetHP: Called by RespawnLogic.
     * Brings user back to life while keeping Global Inventory safe.
     */
    public void resetHP() {
        this.currentHP = MAX_HP;
        this.isDead = false;
        this.lastDeathReason = "None";
        syncToBridge(); // Clears the blood from the 3D view
        System.out.println("USER_REBORN: Items Retained.");
    }

    private void syncToBridge() {
        // Writes binary status to localMetadataRender/DataBridge.bin
    }

    // Engine Getters
    public int getCurrentHP() { return currentHP; }
    public boolean isDead() { return isDead; }
    public String getLastDeath() { return lastDeathReason; }
}
