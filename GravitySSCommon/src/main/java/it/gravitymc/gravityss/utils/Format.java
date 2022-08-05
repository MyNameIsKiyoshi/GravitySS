package it.gravitymc.gravityss.utils;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class Format {

    public static String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String rgb(Integer red, Integer green, Integer blue, String text){
        return ChatColor.of(new Color(red, green, blue)) + color(text);
    }

}
