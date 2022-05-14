package me.jasper1229.bedrock;

import me.jasper1229.bedrock.commands.utility.*;
import me.jasper1229.bedrock.commands.fun.*;
import me.jasper1229.bedrock.commands.punish.*;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedrock extends JavaPlugin {

    public String pluginPrefix = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-prefix"));
    // Variable so I don't have to type pointless code every time I want to use the plugin prefix.


    @Override
    public void onEnable() {

        saveDefaultConfig();

        getLogger().info("Bedrock has been enabled! ♥");
        getCommand("btp").setExecutor(new TeleportCommand(this));
        getCommand("frog").setExecutor(new FrogCommand(this));
        getCommand("find").setExecutor(new FindCommand(this));
        getCommand("dnp").setExecutor(new DisableNetherPortalsCommand(this));
        getServer().getPluginManager().registerEvents(new Events(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Bedrock has been disabled! See you next time!");
    }

}
