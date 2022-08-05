package it.gravitymc.gravityss.events;

import it.gravitymc.gravityss.GravitySS;
import it.gravitymc.gravityss.manager.PluginManager;
import it.gravitymc.gravityss.utils.abs.UTILS;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SSJoinEvent extends UTILS implements Listener {

    private final PluginManager pluginManager;

    public SSJoinEvent(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @SuppressWarnings("ConstantConditions")
    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if(perms.hasPermission(perms.getUser(player), "gravityss.staff")){

            World staffer_world = Bukkit.
                    getWorld(GravitySS.getInstance().getConfig().getString("Locations.Staffer.World"));
            double staffer_x = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Staffer.X");
            double staffer_y = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Staffer.Y");
            double staffer_z = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Staffer.Z");
            float staffer_yaw = GravitySS.getInstance().
                    getConfig().getInt("Locations.Staffer.YAW");
            float staffer_pitch = GravitySS.getInstance().
                    getConfig().getInt("Locations.Staffer.PITCH");

            Location staffer_location = new Location(staffer_world, staffer_x, staffer_y, staffer_z, staffer_yaw, staffer_pitch);

            if(staffer_world != null){
                player.teleport(staffer_location);
            } else {
                player.sendMessage(format.color("&cImpossibile trovare la posizione di spawn per lo staffer"));
                player.teleport(new Location(player.getWorld(), 10, 75, 10));
            }

        } else if (!(perms.hasPermission(perms.getUser(player), "gravityss.staff"))){

            World suspect_world = Bukkit.
                    getWorld(GravitySS.getInstance().getConfig().getString("Locations.Suspect.World"));
            double suspect_x = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Suspect.X");
            double suspect_y = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Suspect.Y");
            double suspect_z = GravitySS.getInstance().
                    getConfig().getDouble("Locations.Suspect.Z");
            float suspect_yaw = GravitySS.getInstance().
                    getConfig().getInt("Locations.Suspect.YAW");
            float suspect_pitch = GravitySS.getInstance().
                    getConfig().getInt("Locations.Suspect.PITCH");

            Location suspect_location = new Location(suspect_world, suspect_x, suspect_y, suspect_z, suspect_yaw, suspect_pitch);

            if(suspect_world != null){
                player.teleport(suspect_location);
            } else {
                player.sendMessage(format.color("&cImpossibile trovare la posizione di spawn per il sospetto"));
                player.teleport(new Location(player.getWorld(), 10, 75, 10));
            }

        }

    }

}
