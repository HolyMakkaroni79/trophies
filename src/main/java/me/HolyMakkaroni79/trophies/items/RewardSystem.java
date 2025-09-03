package me.HolyMakkaroni79.trophies.items;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class RewardSystem {

        //player.getInventory().addItem(item.build());
    public static void reward (Player player, ItemStack item, boolean isObtained){
        player.getInventory().addItem(item);
    }
}
