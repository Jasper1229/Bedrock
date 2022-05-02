package me.jasper1229.bedrock;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;



public class Events implements Listener
{
    int sneakDown = 1;

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event)
    {
        sneakDown++;
        if(sneakDown%2 == 0)
        {
            ;
            Player player = event.getPlayer();
            player.sendMessage("Sneak event is happening");
            if (!FrogCommand.isFrog.containsKey(player.getUniqueId()) || !player.isOnGround()) return;
            Vector v = player.getVelocity();
            v.setY(100);
            v.setX(0);
            v.setZ(0);
            player.setVelocity(v);

        }
        return;

    }
    @EventHandler
    public void onDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            Player player = (Player) event.getEntity();
            if (!FrogCommand.isFrog.containsKey(player.getUniqueId()) || !player.isOnGround()) return;
            event.setCancelled(true);
        }

    }

}

