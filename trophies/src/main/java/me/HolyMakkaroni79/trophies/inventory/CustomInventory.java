package me.HolyMakkaroni79.trophies.inventory;

import me.HolyMakkaroni79.trophies.Trophies;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class CustomInventory implements Listener{
    private final HashMap<UUID, Inventory> playerInventory = new HashMap<>();
    private final Trophies plugin;

    public CustomInventory(Trophies plugin){
        this.plugin = plugin;
    }

    public void openInventory(Player player){
        Inventory inv = playerInventory.get(player.getUniqueId());
        if (inv == null) {
            inv = Bukkit.createInventory(player, 9, ChatColor.GOLD + "trophy delivery");
            playerInventory.put(player.getUniqueId(), inv);
        }
        player.openInventory(inv);
    }

    public void addTrophy(Player player, ItemStack item) {
        Inventory inv = playerInventory.get(player.getUniqueId());
        if (inv == null) {
            inv = Bukkit.createInventory(player, 9, ChatColor.GOLD + "trophy delivery");
            playerInventory.put(player.getUniqueId(), inv);
        }

        inv.addItem(item);

        if (player.getOpenInventory().getTopInventory().equals(inv)) {
            player.updateInventory();
        }
    }


    public Inventory getInventory(Player player){
        return playerInventory.get(player.getUniqueId());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("trophy delivery")) {
            List<ItemStack> items = Arrays.asList(inventory.getContents());
            plugin.getConfig().set("inventories." + player.getUniqueId(), items);
            plugin.saveConfig();
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory clicked = event.getClickedInventory();
        if (clicked == null || clicked instanceof PlayerInventory) return;

        String name = ChatColor.stripColor(event.getView().getTitle());
        if (!name.equalsIgnoreCase("trophy delivery")) return;

        ItemStack cursor = event.getCursor(); // das Item auf der Maus
        ItemStack current = event.getCurrentItem(); // das Item im Slot

        // Wenn Spieler etwas reinlegen will
        if (cursor != null && cursor.getType() != Material.AIR && cursor.getType() != Material.MUSIC_DISC_OTHERSIDE) {
            event.setCancelled(true); // Nur Disc darf rein
            return;

        }

        // Wenn Spieler etwas rausnehmen will
        if (current != null && current.getType() != Material.MUSIC_DISC_OTHERSIDE) {
            event.setCancelled(true);
        }
    }
}
