package me.HolyMakkaroni79.trophies.listeners.advancementListener;

import me.HolyMakkaroni79.trophies.items.ItemClass;
import me.HolyMakkaroni79.trophies.items.RewardSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static org.bukkit.enchantments.Enchantment.UNBREAKING;

public class ElytraListener implements Listener {
    Player player;


    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event){
        Advancement advancement = event.getAdvancement();
        NamespacedKey key = advancement.getKey();
        Player player= event.getPlayer();
        this.player = player;
        if(key.equals(NamespacedKey.minecraft("end/elytra"))){
            getDragonSlayer();
        }
    }
    public ItemStack getDragonSlayer() {
        ItemClass test = new ItemClass("the taste of freedom", Material.MUSIC_DISC_OTHERSIDE,
                Arrays.asList("Now", "fly", "away"), null, true);

        for (Player player : Bukkit.getOnlinePlayers()) {
            RewardSystem.reward(player, test.build());
        }
        return test.build();
    }
}
