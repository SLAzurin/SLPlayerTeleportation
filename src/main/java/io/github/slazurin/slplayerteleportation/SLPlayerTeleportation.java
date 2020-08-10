package io.github.slazurin.slplayerteleportation;

import io.github.slazurin.slplayerteleportation.commands.PlayerTeleportationCommands;
import org.bukkit.plugin.java.JavaPlugin;

public class SLPlayerTeleportation extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
    }
    
    @SuppressWarnings({"NullableProblems"})
    private void registerCommands() {
        this.getCommand("pp").setExecutor(new PlayerTeleportationCommands(this));
    }
}