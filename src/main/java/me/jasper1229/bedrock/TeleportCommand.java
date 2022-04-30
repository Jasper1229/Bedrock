package me.jasper1229.bedrock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeleportCommand implements CommandExecutor {

    private final Bedrock plugin;

    public TeleportCommand(Bedrock plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player playerSender = (Player) sender;

            if (args.length == 0 || !Bukkit.getOnlinePlayers().toString().contains(args[0]) || args.length > 1)
            {
                playerSender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("plugin-prefix")) + ChatColor.LIGHT_PURPLE + " /btp <Online Player>");
                return true;
            } else {

                Player playerRequested = Bukkit.getPlayer(args[0]);
                playerSender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("plugin-prefix")) + ChatColor.LIGHT_PURPLE + " Teleporting");
                playerSender.teleport(playerRequested.getLocation());
                return true;
            }
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("plugin-prefix")) + "Can only be run be players!");
        return false;
    }

}
