package Origin.Voting.Commands.Store;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StoreCommandHandler implements CommandExecutor
{

    //This is where we will store the commands
    private static HashMap<String, StoreCommandInterface> commands = new HashMap<String, StoreCommandInterface>();

    //Register method. When we register commands in our onEnable() we will use this.
    public void register(String name, StoreCommandInterface cmd) {

        //When we register the command, this is what actually will put the command in the hashmap.
        commands.put(name, cmd);
    }

    //This will be used to check if a string exists or not.
    public boolean exists(String name) {

        //To actually check if the string exists, we will return the hashmap
        return commands.containsKey(name);
    }

    //Getter method for the Executor.
    public StoreCommandInterface getExecutor(String name) {

        //Returns a command in the hashmap of the same name.
        return commands.get(name);
    }

    public List<String> getCommands(){
        List<String> commandsList = new ArrayList<>();

        for (String i:
             commands.keySet()) {
            commandsList.add(i);
        }
        

        return commandsList;
    }

    //This will be a template. All commands will have this in common.
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        //For example, in each command, it will check if the sender is a player and if not, send an error message.
        if(sender instanceof Player) {

            //If there aren't any arguments, what is the command name going to be? For this example, we are going to call it /example.
            //This means that all commands will have the base of /example.
            if(args.length == 0) {
                getExecutor("store").onCommand(sender, cmd, commandLabel, args);
                return true;
            }

            //What if there are arguments in the command? Such as /example args
            if(args.length > 0) {

                //If that argument exists in our registration in the onEnable();
                if(exists(args[0])){

                    //Get The executor with the name of args[0]. With our example, the name of the executor will be args because in
                    //the command /example args, args is our args[0].
                    getExecutor(args[0]).onCommand(sender, cmd, commandLabel, args);
                    return true;
                } else {

                    //We want to send a message to the sender if the command doesn't exist.
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                            + ChatColor.AQUA + "That's not something you can purchase yet, type /store info for everything you can buy with chips!");
                    return true;
                }
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                    + ChatColor.AQUA + "You must be a player to use this command.");
            return true;
        }
        return false;
    }

}
