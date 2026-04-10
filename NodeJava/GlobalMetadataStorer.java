package com.xatandcatch.survivalhorror.logic;

import java.io.FileOutputStream;
import java.io.DataOutputStream;

/**
 * GlobalMetadataStorer: The unhackable "Black Box".
 * Saves Worldwide Progress in binary format.
 */
public class GlobalMetadataStorer {
    private static final String DATA_PATH = "localMetadataRender/DataBridge.bin";

    public static void lockDeathState(String reason, int hp) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_PATH))) {
            // Write binary headers to prevent text-editing
            dos.writeInt(0xDEADBEEF); 
            dos.writeUTF(reason);     // Store "Chainsaw Dismemberment"
            dos.writeInt(hp);         // Store 0 HP
            dos.writeLong(System.currentTimeMillis());
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

