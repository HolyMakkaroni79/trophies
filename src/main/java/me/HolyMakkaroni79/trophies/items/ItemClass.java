package me.HolyMakkaroni79.trophies.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemClass {
    final String name;
    final Material material;
    final List<String> lore;
    final Map<Enchantment, Integer> enchantment;
    final boolean unbreakable;


    public ItemClass(String name, Material material, List<String> lore,
                     Map<Enchantment, Integer> enchantment, boolean unbreakable) {
        this.name = name;
        this.material = material;
        this.lore = lore != null ? lore : new ArrayList<>();
        this.enchantment = enchantment;
        this.unbreakable = unbreakable;
    }

    public ItemStack build(){
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        if(meta != null){
            if (name != null){
                meta.setDisplayName(name);
            }
            if(!lore.isEmpty()){
                meta.setLore(lore);
            }
            meta.setUnbreakable(unbreakable);
            if(enchantment != null){
                for (Map.Entry<Enchantment, Integer> entry : enchantment.entrySet()){
                    meta.addEnchant(entry.getKey(), entry.getValue(), true);
                }
            }
            item.setItemMeta(meta);
        }
        return item;
    }
}
