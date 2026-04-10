#version 300 es
precision highp float;

in vec2 v_TexCoord;
in float v_LightIntensity;
uniform sampler2D u_Texture;

out vec4 fragColor;

void main() {
    vec4 texColor = texture(u_Texture, v_TexCoord);
    
    // Multiplies the texture by the 3D light intensity and horror darkness
    fragColor = vec4(texColor.rgb * v_LightIntensity * 0.5, texColor.a);
}

