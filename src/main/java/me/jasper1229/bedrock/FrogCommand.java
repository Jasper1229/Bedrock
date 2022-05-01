package me.jasper1229.bedrock;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;


public class FrogCommand implements CommandExecutor
{
    private final Bedrock plugin;

    public FrogCommand(Bedrock plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!(sender instanceof Player)) return true;
        Player player = (Player)sender;
        if(isFrog.containsKey(player.getUniqueId()))
        {
            isFrog.remove(player.getUniqueId());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("plugin-prefix")) + ChatColor.translateAlternateColorCodes('&', "&2&l You have switched back into a human :("));
            player.removePotionEffect(PotionEffectType.JUMP);
            return true;
        }
        else if(!isFrog.containsKey(player.getUniqueId()))
        {
            isFrog.put(player.getUniqueId(), "");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("plugin-prefix")) + ChatColor.translateAlternateColorCodes('&', "&2&l You have switched into a frog :D"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 25));
            return true;
        }
        return true;
    }

    public static HashMap<UUID, String> isFrog = new HashMap<>();





}
