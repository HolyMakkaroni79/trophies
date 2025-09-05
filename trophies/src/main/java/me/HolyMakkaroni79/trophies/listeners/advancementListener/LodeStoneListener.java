package me.HolyMakkaroni79.trophies.listeners.advancementListener;

import me.HolyMakkaroni79.trophies.Trophies;
import me.HolyMakkaroni79.trophies.items.ItemClass;
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
    Player player;
    private final Trophies plugin;
    public LodeStoneListener(Trophies plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onAdvancementDone(PlayerAdvancementDoneEvent event){
        Advancement advancement = event.getAdvancement();
        NamespacedKey key = advancement.getKey();
        Player player= event.getPlayer();
        this.player = player;
        if(key.equals(NamespacedKey.minecraft("adventure/honey_block_slide"))){
            getTest();
        }
    }
    public ItemStack getTest() {
        ItemClass test = new ItemClass("test", Material.MUSIC_DISC_OTHERSIDE, Arrays.asList("kuck kuck", "HI"), null, true);

        plugin.getRewardSystem().reward(player, test.build());
        return test.build();
    }
}
