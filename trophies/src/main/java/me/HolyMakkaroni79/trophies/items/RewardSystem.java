package me.HolyMakkaroni79.trophies.items;
import me.HolyMakkaroni79.trophies.Trophies;
import me.HolyMakkaroni79.trophies.inventory.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.C;


public class RewardSystem {
    private final Trophies plugin;

    public RewardSystem(Trophies plugin){
        this.plugin = plugin;
    }

    //CustomInventory customInventory = new CustomInventory();
        //player.getInventory().addItem(item.build());
    public void reward (Player player, ItemStack item){

        Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " obtain the " + item.getItemMeta().getDisplayName() + " trophy!");
        player.getInventory().addItem(item);
        //plugin.getCustomInventory().addTrophy(player, item);
    }
}
