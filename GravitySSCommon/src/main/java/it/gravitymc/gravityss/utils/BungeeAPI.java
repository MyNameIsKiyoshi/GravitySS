package it.gravitymc.gravityss.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import it.gravitymc.gravityss.GravitySS;
import org.bukkit.entity.Player;

public class BungeeAPI {

    public void sendPlayerToServer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
            p.sendPluginMessage(GravitySS.getInstance(), "BungeeCord", out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
