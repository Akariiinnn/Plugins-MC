package me.akariiinnn.helloworld.commands;

import me.akariiinnn.helloworld.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.akariiinnn.helloworld.libs.Library;


public class BurnCommand implements CommandExecutor{

    private Main plugin;

    public BurnCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("burn").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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


        if(p.hasPermission("burn.use")){
            loc.getBlock().setType(Material.FIRE);
        }else{
            p.sendMessage(Library.playerperms);
        }
        return false;
    }
}
