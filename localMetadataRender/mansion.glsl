#version 300 es
precision highp float;

uniform sampler2D u_Texture;
in vec2 v_TexCoord;
out vec4 fragColor;

void main() {
    vec4 color = texture(u_Texture, v_TexCoord);
    
    // Low-light horror multiplier
    // This creates the "Dark Mansion" look without heavy GPU cost
    float ambient = 0.2; 
    fragColor = vec4(color.rgb * ambient, color.a);
}
