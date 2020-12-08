package Origin.Voting.Commands.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class AdminMsg {

    CommandSender sender;
    String serverPrefix;
    public AdminMsg(CommandSender sender){
        this.sender = sender;
        this.serverPrefix =  ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ");
    }

    public void incorrectArgs(){
        this.sender.sendMessage(this.serverPrefix
                + "Incorrect arguments, please type ./avote help for correct usage");
    }

    public void offlineTarget(){
        this.sender.sendMessage(this.serverPrefix
                + "The player provided isn't online, please try again when the player is online!");
    }

    public void neverPlayedBefore(){
        this.sender.sendMessage(this.serverPrefix
                + "The player provided has never joined the server.");
    }

    public String getServerPrefix(){
        return this.serverPrefix;
    }

}
