#version 300 es
precision highp float;

uniform float u_HealthPercent; // Sent from NodeHP.java
out vec4 fragColor;

void main() {
    // Logic: If health is high, show green. If low, show red.
    // This creates a 3D "Glow" effect in the mansion
    vec3 healthyColor = vec3(0.0, 1.0, 0.0);
    vec3 dangerColor = vec3(1.0, 0.0, 0.0);
    
    vec3 finalColor = mix(dangerColor, healthyColor, u_HealthPercent);
    fragColor = vec4(finalColor, 1.0);
}
