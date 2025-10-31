package me.HolyMakkaroni79.trophies.SpecialTrophies.CommandTrophies;

import me.HolyMakkaroni79.trophies.items.ItemClass;
import me.HolyMakkaroni79.trophies.items.RewardSystem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class HalloweenTrophy {
    public ItemStack getTrophy(Player player) {
        ItemClass trophie = new ItemClass("the taste of freedom", Material.MUSIC_DISC_OTHERSIDE,
                Arrays.asList("Now", "fly", "away"), null, true, 7003);


        RewardSystem.reward(player, trophie.build());


        return trophie.build();
    }
}
