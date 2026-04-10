package com.xatandcatch.survivalhorror.logic;

/**
 * NodeHP: The core Vitals and Execution engine.
 * Handles Extreme Gore, Instant Death (100+ DMG), and Security Warnings.
 */
public class NodeHP {
    
    private int currentHP;
    private final int MAX_HP = 100;
    private boolean isDead = false;
    private String lastDeathReason = "None";

    // 18+ Warning displayed at the start of the logic loop
    public static final String GORE_WARNING = "WARNING: 18+ EXTREME GORE. Includes Dismemberment & Organ Removal.";

    public NodeHP() {
        this.currentHP = MAX_HP;
        System.out.println(GORE_WARNING);
    }

    /**
     * Damage handler for Granny's attacks.
     * @param amount Damage value (100 for Headshot, 110 for Heart Extraction)
     * @param reason Description of the execution (e.g., "Chainsaw Limb Cut")
     */
    public void takeDamage(int amount, String reason) {
        if (!isDead) {
            this.currentHP -= amount;
            this.lastDeathReason = reason;

            if (this.currentHP <= 0) {
                this.currentHP = 0;
                this.isDead = true;
                handleExtremeDeath();
            }
            
            // Syncs HP and Death State to the Global Metadata Storer
            syncToGlobalMetadata();
        }
    }

    private void handleExtremeDeath() {
        // Trigger the specific Gore Shader based on the reason
        if (lastDeathReason.contains("Chainsaw")) {
            // Logic to trigger 'GoreUI.glsl' type 3 (Dismemberment)
        } else if (lastDeathReason.contains("Bite")) {
            // Logic to trigger 'GoreUI.glsl' type 2 (Heart/Organ Removal)
        }
        
        System.out.println("GAME OVER: " + lastDeathReason);
    }

    private void syncToGlobalMetadata() {
        // Writes binary data to localMetadataRender/DataBridge.bin
        // This makes the death "Unhackable" and permanent across sessions
    }

    // Getters for the Engine
    public int getCurrentHP() { return currentHP; }
    public boolean checkIsDead() { return isDead; }
    public String getDeathReason() { return lastDeathReason; }
}
