package com.xatandcatch.survivalhorror.logic;

public class NodeStamina {
    private float stamina = 100.0f;
    private final float MAX_STAMINA = 100.0f;
    private final float BURN_RATE = 20.0f;  // How fast it drops per second
    private final float REGEN_RATE = 10.0f; // How fast it recovers
    private boolean isExhausted = false;

    public void update(float deltaTime, boolean isSprinting) {
        if (isSprinting && stamina > 0 && !isExhausted) {
            stamina -= BURN_RATE * deltaTime;
            if (stamina <= 0) {
                stamina = 0;
                isExhausted = true; // Forced walk
            }
        } else {
            stamina += REGEN_RATE * deltaTime;
            if (stamina >= MAX_STAMINA) {
                stamina = MAX_STAMINA;
                isExhausted = false; // Recovered
            }
        }
    }

    public boolean canSprint() {
        return stamina > 0 && !isExhausted;
    }

    public float getStaminaPercent() {
        return stamina / MAX_STAMINA;
    }
}

