package it.gravitymc.gravityss.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class Sounds {

    public void openGuiOre(Player p){
        p.playSound(p.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 50, 2);
        p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 50, 2);
    }

    public void accessDenied(Player p){
        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 50, 2);
        p.playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 50, 2);
    }

    public void clickInv(Player p){
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 50, 2);
        p.playSound(p.getLocation(), Sound.ITEM_ARMOR_EQUIP_IRON, 50, 2);
    }

}
