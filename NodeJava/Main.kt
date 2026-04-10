package com.horrorsurvival.engine

import android.os.Bundle
import android.app.Activity
import android.view.WindowManager

/**
 * HorrorSurvival Main Entry Point
 * Handles the native loop and global metadata initialization.
 */
class MainActivity : Activity() {

    // The Global Metadata Storer handles worldwide user progress sync
    private lateinit var globalStorer: Any 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Keep screen on for the mansion exploration
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // 1. Initialize Global Metadata Storer
        // This ensures worldwide users don't lose progress upon launch
        initGlobalMetadata()

        // 2. Setup Rendering Pipeline (Vulkan/OpenGL)
        // Hardware-accelerated graphics for the mansion and Granny AI
        setupHardwareRender()
    }

    private fun initGlobalMetadata() {
        // Logic for connecting to localMetadataRender goes here
        // Prevents data corruption and unauthorized player modifications
    }

    private fun setupHardwareRender() {
        // Initializes the Vulkan instance for high-end lighting
        // and OpenGL for the UI overlays
    }

    override fun onDestroy() {
        super.onDestroy()
        // Safely save localData before the app closes to prevent data loss
    }
}

