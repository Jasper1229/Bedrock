package me.jasper1229.bedrock;

import org.bukkit.plugin.java.JavaPlugin;

public final class Bedrock extends JavaPlugin {

    private static Bedrock instance;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        getLogger().info("Bedrock has been enabled! ♥");
        getCommand("btp").setExecutor(new TeleportCommand(this));

    }

    @Override
    public void onDisable() {
        getLogger().info("Bedrock has been disabled! See you next time!");
    }

}
