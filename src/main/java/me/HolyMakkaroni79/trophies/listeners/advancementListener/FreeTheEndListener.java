package me.HolyMakkaroni79.trophies.listeners.advancementListener;

import me.HolyMakkaroni79.trophies.items.ItemClass;
import me.HolyMakkaroni79.trophies.items.RewardSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class FreeTheEndListener implements Listener {
    Player player;


    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event){
        Advancement advancement = event.getAdvancement();
        NamespacedKey key = advancement.getKey();
        Player player= event.getPlayer();
        this.player = player;
        Bukkit.broadcastMessage("advancement" + key);
        if(key.equals(NamespacedKey.minecraft("end/kill_dragon"))){
            getDragonSlayer();
        }
    }
    public ItemStack getDragonSlayer() {
        ItemClass test = new ItemClass("dragon slayer", Material.MUSIC_DISC_OTHERSIDE,
                Arrays.asList("You were one of the first people", "who free the end!"), null, true);

        for (Player player : Bukkit.getOnlinePlayers()) {
            RewardSystem.reward(player, test.build());
        }
        return test.build();
    }
}
