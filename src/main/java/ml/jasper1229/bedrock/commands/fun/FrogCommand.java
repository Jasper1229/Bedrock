package ml.jasper1229.bedrock.commands.fun;

import ml.jasper1229.bedrock.Bedrock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


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
            player.sendMessage(plugin.pluginPrefix + ChatColor.translateAlternateColorCodes('&', "&2&l You have switched back into a human :("));
            //player.removePotionEffect(PotionEffectType.JUMP);
            return true;
        }
        else if(!isFrog.containsKey(player.getUniqueId()))
        {
            isFrog.put(player.getUniqueId(), "");
            player.sendMessage(plugin.pluginPrefix + ChatColor.translateAlternateColorCodes('&', "&2&l You have switched into a frog :D"));
            //player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 25));
            return true;
        }
        return true;
    }

    public static HashMap<UUID, String> isFrog = new HashMap<>();

}
