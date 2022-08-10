package ml.jasper1229.bedrock.commands.utility;

import ml.jasper1229.bedrock.Bedrock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeleportCommand implements CommandExecutor
{

    private final Bedrock plugin;

    public TeleportCommand(Bedrock plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("Can only be run be players!");
            return true;
        }

        Player playerSender = (Player) sender;

        if (args.length == 0 || !Bukkit.getOnlinePlayers().toString().contains(args[0]) || args.length > 1 && !Bukkit.getOnlinePlayers().toString().contains(args[0]))
        {
            playerSender.sendMessage(plugin.pluginPrefix + ChatColor.LIGHT_PURPLE + " /btp <Online Player>");
            return true;
        }
        else if(args.length == 2 && Bukkit.getOnlinePlayers().toString().contains(args[1])) // If teleport command has two arguments example: /teleport Jasper1229 MonkeygirIs
        {
            Player teleporting = Bukkit.getPlayer(args[0]); // Teleporting player (First argument)
            Player teleportDestination = Bukkit.getPlayer(args[1]); // Destination player (Second argument)
            teleporting.sendMessage(plugin.pluginPrefix + ChatColor.LIGHT_PURPLE + " Teleporting");
            teleporting.teleport(teleportDestination.getLocation()); // Teleporting..
            return true;
        }
        else
        {
            Player playerRequested = Bukkit.getPlayer(args[0]);
            playerSender.sendMessage(plugin.pluginPrefix + ChatColor.LIGHT_PURPLE + " Teleporting");
            playerSender.teleport(playerRequested.getLocation());
            return true;
        }


    }

}
