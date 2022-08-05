package it.gravitymc.gravityssbungee;

import it.gravitymc.gravityssbungee.commands.ScreenShare;
import net.md_5.bungee.api.plugin.Plugin;

public final class GravitySSBungee extends Plugin {

    public void Commands(){
        getProxy().getPluginManager().registerCommand(this, new ScreenShare("ScreenShare", "gravityss.use", "ss"));
    }

    @Override
    public void onEnable() {
        Commands();
    }
}
