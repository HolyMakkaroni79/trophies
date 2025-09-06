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

public class GateWayListener implements Listener {
    Player player;


    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event){
        Advancement advancement = event.getAdvancement();
        NamespacedKey key = advancement.getKey();
        Player player= event.getPlayer();
        this.player = player;
        if(key.equals(NamespacedKey.minecraft("end/enter_end_gateway"))){
            getTest();
        }
    }
    public ItemStack getTest() {
        ItemClass test = new ItemClass("gateway", Material.MUSIC_DISC_OTHERSIDE, Arrays.asList("You reached for", "new horizons"), null, true);

        RewardSystem.reward(player, test.build());
        return test.build();
    }
}
