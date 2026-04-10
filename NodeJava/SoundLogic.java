package com.xatandcatch.survivalhorror.logic;

public class SoundLogic {
    // Sound ID Constants
    public static final int SND_CHAINSAW_IDLE = 101;
    public static final int SND_CHAINSAW_ATTACK = 102;
    public static final int SND_PLAYER_SCREAM = 201;
    public static final int SND_HEART_BITE = 301;

    public void triggerDeathSound(String reason) {
        if (reason.contains("Chainsaw")) {
            playSound(SND_CHAINSAW_ATTACK);
            playSound(SND_PLAYER_SCREAM);
        } else if (reason.contains("Bite")) {
            playSound(SND_HEART_BITE);
            playSound(SND_PLAYER_SCREAM);
        }
    }

    private void playSound(int soundID) {
        // Native Android SoundPool logic to play the .ogg from assets
        // This runs on a separate thread to prevent lag on your Redmi
    }
}
