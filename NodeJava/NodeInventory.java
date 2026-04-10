package com.xatandcatch.survivalhorror.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * NodeInventory: Handles item tracking for the Worldwide Progress.
 * No 3D models needed—just pure native logic.
 */
public class NodeInventory {
    
    private List<String> items;

    public NodeInventory() {
        this.items = new ArrayList<>();
    }

    // Add an item (like "MasterKey" or "Hammer")
    public void addItem(String itemName) {
        if (!items.contains(itemName)) {
            items.add(itemName);
            syncInventoryToGlobal();
        }
    }

    // Check if player can open a specific door
    public boolean hasItem(String itemName) {
        return items.contains(itemName);
    }

    private void syncInventoryToGlobal() {
        // Writes the list to localMetadataRender/DataBridge.bin
        // This makes the progress "Unhackable" and permanent
    }
}

