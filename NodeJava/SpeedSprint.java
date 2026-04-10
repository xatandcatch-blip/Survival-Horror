package com.xatandcatch.survivalhorror.logic;

public class SprintSpeed {
    // Base movement speed
    public static final float BASE_WALK_SPEED = 4.0f;
    
    // 50% increase: 1.0 (Base) + 0.5 (Increase) = 1.5 multiplier
    public static final float SPRINT_MULTIPLIER = 1.5f;

    public static float getSprintSpeed() {
        return BASE_WALK_SPEED * SPRINT_MULTIPLIER;
    }
}

