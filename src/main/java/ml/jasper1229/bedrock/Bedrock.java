package ml.jasper1229.bedrock;

import ml.jasper1229.bedrock.commands.fun.FrogCommand;
import ml.jasper1229.bedrock.commands.punish.KickCommand;
import ml.jasper1229.bedrock.commands.utility.DisableNetherPortalsCommand;
import ml.jasper1229.bedrock.commands.utility.FindCommand;
import ml.jasper1229.bedrock.commands.utility.TeleportCommand;
import ml.jasper1229.bedrock.utils.PermissionUtil;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bedrock extends JavaPlugin {

    public String pluginPrefix = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-prefix"));
    // Variable so I don't have to type pointless code every time I want to use the plugin prefix.

    private static Bedrock plugin;
    @Override
    public void onEnable() {

        saveDefaultConfig();

        getLogger().info("Bedrock has been enabled! ♥");
        getCommand("btp").setExecutor(new TeleportCommand(this));
        getCommand("frog").setExecutor(new FrogCommand(this));
        getCommand("find").setExecutor(new FindCommand(this));
        getCommand("dnp").setExecutor(new DisableNetherPortalsCommand(this));
        getCommand("bkick").setExecutor(new KickCommand());
        getServer().getPluginManager().registerEvents(new Events(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Bedrock has been disabled! See you next time!");
    }

    public static Bedrock getPlugin(){
        return plugin;
    }

}
