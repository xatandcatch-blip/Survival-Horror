#version 300 es
precision highp float;

uniform int u_AttackType; // 0=None, 1=Gun, 2=Bite, 3=Chainsaw
out vec4 fragColor;

void main() {
    // Basic screen-space blood splatter logic
    vec3 bloodColor = vec3(0.6, 0.0, 0.0);
    
    if (u_AttackType == 3) { // Chainsaw
        // Add "noise" to simulate limbs/gore across the screen
        fragColor = vec4(bloodColor, 0.9); 
    } else {
        fragColor = vec4(0.0); // Clear screen if not dead
    }
}

