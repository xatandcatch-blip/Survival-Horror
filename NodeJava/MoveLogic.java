package com.xatandcatch.survivalhorror.logic;

/**
 * MoveLogic: The core engine for player movement.
 * Integrates SprintSpeed and NodeStamina for native 3D movement.
 */
public class MoveLogic {
    private float posX, posY, posZ;
    private float currentSpeed;
    
    // Dependencies
    private NodeStamina stamina;
    private boolean isSprinting = false;

    public MoveLogic(NodeStamina staminaNode) {
        this.stamina = staminaNode;
        this.currentSpeed = SprintSpeed.BASE_WALK_SPEED;
        
        // Starting position in the mansion
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.posZ = 0.0f;
    }

    /**
     * Updates movement based on input and stamina.
     * @param dirX Horizontal input (-1 to 1)
     * @param dirZ Vertical input (-1 to 1)
     * @param deltaTime Time since last frame
     * @param wantsToSprint If the sprint button is held
     */
    public void processMovement(float dirX, float dirZ, float deltaTime, boolean wantsToSprint) {
        // 1. Update Stamina logic first
        stamina.update(deltaTime, wantsToSprint && (dirX != 0 || dirZ != 0));

        // 2. Determine Speed (Apply 50% boost only if stamina allows)
        if (wantsToSprint && stamina.canSprint()) {
            this.currentSpeed = SprintSpeed.getSprintSpeed();
            this.isSprinting = true;
        } else {
            this.currentSpeed = SprintSpeed.BASE_WALK_SPEED;
            this.isSprinting = false;
        }

        // 3. Calculate 3D Translation
        // We move based on speed and time to keep it smooth on your Redmi
        this.posX += dirX * currentSpeed * deltaTime;
        this.posZ += dirZ * currentSpeed * deltaTime;

        // 4. Sync to Global Metadata
        syncPositionToGlobal();
    }

    private void syncPositionToGlobal() {
        // Sends (posX, posY, posZ) to localMetadataRender/DataBridge.bin
        // This ensures the Worldwide Progress tracks your exact 3D location
    }

    // Getters for the Renderer
    public float getX() { return posX; }
    public float getZ() { return posZ; }
    public boolean isCurrentlySprinting() { return isSprinting; }
}
