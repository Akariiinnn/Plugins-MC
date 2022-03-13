package me.akariiinnn.helloworld.commands;

import me.akariiinnn.helloworld.Main;
import me.akariiinnn.helloworld.libs.Library;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HorseCommand implements CommandExecutor {
    private Main plugin;

    public HorseCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("horse").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(Library.consolerestraint);
            return true;
        }

        Player p = (Player) sender;

        Location loc = p.getLocation();

        World world = Bukkit.getServer().getWorld("World");
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        int xINT = (int)x;
        int yINT = (int)y;
        int zINT = (int)z;

        loc = new Location(world,x,y,z);

        if(p.hasPermission("horse.use")){
            if (world != null) {
                Horse horse = (Horse) Bukkit.getWorld("world").spawnEntity(p.getLocation(), EntityType.HORSE);
                horse.setTamed(true);
                horse.setCustomName("Epona");
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            }
            return true;
        }else{
            p.sendMessage(Library.playerperms);
        }

        return false;
    }
}
