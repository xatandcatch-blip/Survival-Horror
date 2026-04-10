package com.xatandcatch.survivalhorror.logic;

public class GrannyAI {
    // ... previous position and speed code ...

    public enum AttackType {
        GUN_HEADSHOT(100),
        BITE_EXECUTION(110),
        CHAINSAW_DISMEMBER(150); // Extra overkill for the gore effect

        public final int damage;
        AttackType(int damage) { this.damage = damage; }
    }

    public void performAttack(AttackType type, NodeHP playerHP) {
        // Trigger the specific damage to the NodeHP
        playerHP.takeDamage(type.damage);
        
        // Log the specific death for the Global Metadata Storer
        System.out.println("CRITICAL: Player killed by " + type.name());
        
        // Here is where you would trigger the Blood & Gore overlay
        triggerGoreSystem(type);
    }

    private void triggerGoreSystem(AttackType type) {
        // This will call the shader in localMetadataRender to show the blood
    }
}
