#version 300 es
precision highp float;

// Data fed directly from NodeHP.java via the bridge
uniform float u_PlayerHP; 
uniform float u_Time;

out vec4 fragColor;

void main() {
    // Logic: As HP drops, the screen gets a "Vignette" and a red pulse
    float healthFactor = clamp(u_PlayerHP / 100.0, 0.0, 1.0);
    float pulse = sin(u_Time * 5.0) * (1.0 - healthFactor) * 0.1;
    
    vec3 baseColor = vec3(0.05, 0.05, 0.05); // Dark mansion floor
    vec3 bloodColor = vec3(0.4, 0.0, 0.0);
    
    // The lower the health, the more the world turns red
    vec3 finalColor = mix(bloodColor, baseColor, healthFactor + pulse);
    fragColor = vec4(finalColor, 1.0);
}

