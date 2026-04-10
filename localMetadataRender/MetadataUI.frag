#version 300 es
/* * Survival-Horror: OpenGL UI Shader
 * Location: localMetadataRender
 */

precision highp float;
out vec4 fragColor;

void main() {
    // Renders the UI and metadata menus without lag
    // Keeping it separate from Vulkan to prevent crashes
    fragColor = vec4(0.1, 0.1, 0.1, 1.0); 
}
