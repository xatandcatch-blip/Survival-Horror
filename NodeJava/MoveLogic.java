package com.xatandcatch.survivalhorror.logic;

public class MoveLogic {
    private float currentSpeed;
    private boolean isSprinting = false;

    public MoveLogic() {
        this.currentSpeed = SprintSpeed.BASE_WALK_SPEED;
    }

    // Call this when the sprint button is pressed/held
    public void setSprinting(boolean sprinting) {
        this.isSprinting = sprinting;
        if (isSprinting) {
            this.currentSpeed = SprintSpeed.getSprintSpeed();
        } else {
            this.currentSpeed = SprintSpeed.BASE_WALK_SPEED;
        }
    }

    public void updatePosition(float deltaX, float deltaZ) {
        // Here you would apply currentSpeed to the 3D coordinates
        // This moves the player through the mansion natively
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }
}

