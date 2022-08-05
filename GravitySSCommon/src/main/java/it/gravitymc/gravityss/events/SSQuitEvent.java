package it.gravitymc.gravityss.events;

import it.gravitymc.gravityss.manager.PluginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static it.gravitymc.gravityss.GravitySS.targetName;

public class SSQuitEvent implements Listener {

    private final PluginManager pluginManager;

    public SSQuitEvent(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        targetName.clear();
    }

}
