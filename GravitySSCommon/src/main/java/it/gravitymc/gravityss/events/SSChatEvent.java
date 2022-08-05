package it.gravitymc.gravityss.events;

import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SSChatEvent extends UTILS implements Listener {

    private final PluginManager pluginManager;

    public SSChatEvent(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if(perms.hasPermission(perms.getUser(player), "gravityss.staff")){
            event.setFormat(format.color(perms.getPrefixGroup(player) + " &7" + player.getName() + " > " + event.getMessage()));
        } else {
            event.setFormat(format.color(perms.getPrefixGroup(player) + " &7" + player.getName() + " > " + event.getMessage()));
        }

    }

}
