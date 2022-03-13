package me.akariiinnn.helloworld;
import me.akariiinnn.helloworld.commands.HelloCommand;
import me.akariiinnn.helloworld.commands.BurnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
    new HelloCommand(this);
    new BurnCommand(this);
    }
}