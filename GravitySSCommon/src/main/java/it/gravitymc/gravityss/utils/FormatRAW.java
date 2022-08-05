package it.gravitymc.gravityss.utils;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class FormatRAW {

    public String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public String rgb(Integer red, Integer green, Integer blue, String text){
        return ChatColor.of(new Color(red, green, blue)) + color(text);
    }

}
