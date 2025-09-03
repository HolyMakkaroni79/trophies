package me.HolyMakkaroni79.trophies.listeners.advancementListener;

import me.HolyMakkaroni79.trophies.items.ItemClass;
import me.HolyMakkaroni79.trophies.items.RewardSystem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class LodeStoneListener implements Listener {
    public boolean isObtained = false;
    Player player;


    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event){
        Advancement advancement = event.getAdvancement();
        NamespacedKey key = advancement.getKey();
        Player player= event.getPlayer();
        this.player = player;
        if(key.equals(NamespacedKey.minecraft("story/lava_bucket"))){
            getTest();
        }
    }
    public ItemStack getTest() {
        ItemClass test = new ItemClass("test", Material.DAMAGED_ANVIL, Arrays.asList("kuck kuck", "HI"), null, true);

        RewardSystem.reward(player, test.build(), isObtained);
        isObtained = true;
        return test.build();
    }
}
