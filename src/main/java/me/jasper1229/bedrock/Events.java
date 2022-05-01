package me.jasper1229.bedrock;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;

public class Events implements Listener
{
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event)
    {
        Player player = event.getPlayer();
        player.sendMessage("Sneak event is happening");
        if(!FrogCommand.isFrog.containsKey(player.getUniqueId())) return;

    }

}

