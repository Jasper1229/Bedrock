package me.jasper1229.bedrock.commands.punish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Invalid arguments! Usage: /kick <player> <reason>");
            return true;
        }
        
        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Error: Player not found.");
            return true;
        }

        String reason = String.join(" ", args, 1);
        target.disconnect(ChatColor.translateAlternateColorCodes('&', reason));

        sender.sendMessage(ChatColor.GREEN + "Sucessfully kicked " + target.getName() + " from server.");
        return true;
    }
}
