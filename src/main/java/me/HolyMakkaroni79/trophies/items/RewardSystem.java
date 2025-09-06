package me.HolyMakkaroni79.trophies.items;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class RewardSystem {

        //player.getInventory().addItem(item.build());
    public static void reward (Player player, ItemStack item){
        Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " obtained the " + item.getItemMeta().getDisplayName() + "!");
        player.getInventory().addItem(item);
    }
}
