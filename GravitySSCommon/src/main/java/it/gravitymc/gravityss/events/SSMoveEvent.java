package it.gravitymc.gravityss.events;

import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class SSMoveEvent extends UTILS implements Listener {

    private final PluginManager pluginManager;

    public SSMoveEvent(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();

        if(!(perms.hasPermission(perms.getUser(player), "gravityss.staff"))){
            event.setCancelled(true);
            player.setVelocity(new Vector().zero());
        }

    }

}
