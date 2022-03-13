package me.akariiinnn.helloworld.commands;

import me.akariiinnn.helloworld.Main;
import me.akariiinnn.helloworld.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.akariiinnn.helloworld.libs.Library;

public class FlyCommand implements CommandExecutor {

    private Main plugin;

    public FlyCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args ){
        if(!(sender instanceof Player)){
            sender.sendMessage(Library.consolerestraint);
            return true;
        }

        Player p = (Player) sender;
        float flyspeed = (float)0.3;

        if(p.hasPermission("fly.use")){
            p.setAllowFlight(true);
            p.setFlySpeed(flyspeed);
            p.sendMessage("You can fly for 30 seconds");
        }else{
            p.sendMessage(Library.playerperms);
        }

        if(p.getAllowFlight()){
            try {
                Thread.sleep(25000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("5 seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("4 seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("3 seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("2 seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("1 seconds left");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.sendMessage("Flight deactivated");
            p.setAllowFlight(false);
            return true;
        }

        return false;
    }
}
