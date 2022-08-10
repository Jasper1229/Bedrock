package ml.jasper1229.bedrock.commands.utility;

import ml.jasper1229.bedrock.Bedrock;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FindCommand implements CommandExecutor
{
    private final Bedrock plugin;

    public FindCommand(Bedrock plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(!(sender instanceof Player) || !(args.length == 1) || !Bukkit.getOnlinePlayers().toString().contains(args[0]))
        {
            sender.sendMessage(plugin.pluginPrefix + ChatColor.LIGHT_PURPLE +  " /find <Online Player>" );
            return true;
        }

        Player player = (Player)sender;
        Player findPlayer = Bukkit.getPlayer(args[0]);
        String findPlayerName = findPlayer.getName();

        TextComponent clickTeleport = new TextComponent("Click to teleport.");
        clickTeleport.setColor(net.md_5.bungee.api.ChatColor.LIGHT_PURPLE);
        clickTeleport.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/btp " + findPlayerName)); // Sets textcomponent to teleport to player

        player.sendMessage(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + ChatColor.translateAlternateColorCodes('&', "               &r"));
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Name » " + findPlayer.getName()); // Name of findPlayer
        player.sendMessage(ChatColor.LIGHT_PURPLE + "World » " + findPlayer.getWorld().getName()); // World of findPlayer
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Location » " + findPlayer.getLocation().getBlockX() + " " + findPlayer.getLocation().getBlockY() + " " + findPlayer.getLocation().getBlockZ()); // Location of findPlayer
        player.spigot().sendMessage(clickTeleport);
        player.sendMessage(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + ChatColor.translateAlternateColorCodes('&', "               &r"));
        return true;
    }
}
