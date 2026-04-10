#version 300 es
layout(location = 0) in vec3 a_Position; // 3D Coordinates
layout(location = 1) in vec2 a_TexCoord;
layout(location = 2) in vec3 a_Normal;   // Used for 3D lighting

uniform mat4 u_MVPMatrix; // Model-View-Projection Matrix for 3D depth

out vec2 v_TexCoord;
out float v_LightIntensity;

void main() {
    // Transforms 3D points into the player's view
    gl_Position = u_MVPMatrix * vec4(a_Position, 1.0);
    v_TexCoord = a_TexCoord;
    
    // Simple 3D light calculation based on the wall's angle (Normal)
    vec3 lightDir = normalize(vec3(0.5, 1.0, 0.3));
    v_LightIntensity = max(dot(a_Normal, lightDir), 0.2);
}

