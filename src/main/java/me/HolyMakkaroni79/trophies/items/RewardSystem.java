package me.HolyMakkaroni79.trophies.items;
import me.HolyMakkaroni79.trophies.Trophies;
import me.HolyMakkaroni79.trophies.listeners.advancementListener.LodeStoneListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class RewardSystem {

        //player.getInventory().addItem(item.build());
    public static void reward (Player player, ItemStack item){
        Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " obtained the " + item.getItemMeta().getDisplayName() + "!");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(item.getItemMeta().getDisplayName());
        item.setItemMeta(meta);
        player.getInventory().addItem(item);

        /*Bukkit.getScheduler().runTaskLater(Trophies.getInstance(), () -> {
            player.updateInventory();
        }, 20L);
        meta = item.getItemMeta();
        meta.setDisplayName(item.getItemMeta().getDisplayName());
        item.setItemMeta(meta);*/
    }
}
