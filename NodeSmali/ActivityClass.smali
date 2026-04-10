.class public Lcom/xatandcatch/survivalhorror/engine/ActivityClass;
.super Landroid/app/Activity;
.source "ActivityClass.java"

# --- INSTANCE FIELDS ---
# These store the state of your engine
.field private healthNode:Lcom/xatandcatch/survivalhorror/logic/NodeHP;
.field private movement:Lcom/xatandcatch/survivalhorror/logic/MoveLogic;


# --- CONSTRUCTOR ---
.method public constructor <init>()V
    .locals 0
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V
    return-void
.end method


# --- ONCREATE METHOD ---
# This boots the engine when the app opens
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    # 1. Call super.onCreate(savedInstanceState)
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    # 2. Print the 18+ Warning to Logcat
    const-string v0, "ENGINE_BOOT: 18+ EXTREME GORE ENABLED"
    const-string v1, "HorrorSurvival"
    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    # 3. Initialize NodeHP (Health Logic)
    new-instance v0, Lcom/xatandcatch/survivalhorror/logic/NodeHP;
    invoke-direct {v0}, Lcom/xatandcatch/survivalhorror/logic/NodeHP;-><init>()V
    iput-object v0, p0, Lcom/xatandcatch/survivalhorror/engine/ActivityClass;->healthNode:Lcom/xatandcatch/survivalhorror/logic/NodeHP;

    # 4. Trigger the World-Wide Metadata Sync
    # This prepares the DataBridge.bin for session persistence
    invoke-virtual {p0}, Lcom/xatandcatch/survivalhorror/engine/ActivityClass;->initializeMetadataSync()V

    return-void
.end method


# --- CUSTOM METHOD: METADATA SYNC ---
.method public initializeMetadataSync()V
    .locals 2
    
    # Logic to talk to your GlobalMetadataStorer
    const-string v0, "SYNC"
    const-string v1, "Establishing Worldwide Progress Link..."
    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    
    return-void
.end method
