package com.xatandcatch.survivalhorror.logic;

/**
 * NodeHP: The Master Health & Execution Controller.
 * Handles: 110 DMG Overkill, Global Progress Locking, and Sound Triggers.
 */
public class NodeHP {
    
    private int currentHP;
    private final int MAX_HP = 100;
    private boolean isDead = false;
    private String lastDeathReason = "None";

    // 18+ Security Gate
    public static final String GORE_WARNING = "CRITICAL: 18+ EXTREME GORE ENABLED. WARNING FOR FIRST-TIME USERS.";

    public NodeHP() {
        this.currentHP = MAX_HP;
        System.out.println(GORE_WARNING);
    }

    /**
     * The primary damage receiver.
     * Use 100 for Gun/Headshot and 110 for Heart Extraction.
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
            
            // Sync current vitals to the 3D bridge
            updateBridgeData();
        }
    }

    private void executeDeathSequence() {
        // 1. Permanent Worldwide Lock (GlobalMetadataStorer)
        // This ensures the death is 'Unhackable' in DataBridge.bin
        GlobalMetadataStorer.lockDeathState(lastDeathReason, currentHP);

        // 2. Audio Execution (SoundLogic)
        // Triggers the chainsaw or heart-bite scream natively
        SoundLogic audioEngine = new SoundLogic();
        audioEngine.triggerDeathSound(lastDeathReason);

        // 3. UI/Gore Notification
        // Sends signal to localMetadataRender/GoreUI.glsl
        System.out.println("EXECUTION_TRIGGERED: " + lastDeathReason);
    }

    private void updateBridgeData() {
        // Keeps the 3D renderer informed of health levels
        // Logic to write currentHP to localMetadataRender/DataBridge.bin
    }

    // Engine Getters
    public int getCurrentHP() { return currentHP; }
    public boolean isDead() { return isDead; }
}
