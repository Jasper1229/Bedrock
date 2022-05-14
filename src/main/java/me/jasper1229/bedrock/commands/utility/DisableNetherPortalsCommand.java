package me.jasper1229.bedrock.commands.utility;

import me.jasper1229.bedrock.Bedrock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisableNetherPortalsCommand implements CommandExecutor
{
    private final Bedrock plugin;

    public DisableNetherPortalsCommand(Bedrock plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length != 1) {sender.sendMessage(plugin.pluginPrefix + ChatColor.RED + " /dnp <boolean>"); return true;}

        String argumentBoolean = args[0];
        Boolean netherPortalsDisabled = false;

        switch (argumentBoolean.toLowerCase())
        {
            case "yes":
            case "on":
            case "true":
                netherPortalsDisabled = true;
                break;
            case "off":
            case "no":
            case "false":
                netherPortalsDisabled = false;
                break;
            default:
                sender.sendMessage(plugin.pluginPrefix + ChatColor.RED + " /dnp <boolean>");
                return true;
        }


        plugin.getConfig().set("portals-disabled", netherPortalsDisabled);
        plugin.saveConfig();
        plugin.reloadConfig();
        sender.sendMessage(plugin.pluginPrefix + ChatColor.LIGHT_PURPLE + " Nether portals disabled set to " + netherPortalsDisabled.toString());

        return true;
    }
}
