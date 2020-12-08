package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class editVotesCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player target = Bukkit.getPlayerExact(args[1]); //Makes
        int edit = Integer.parseInt(args[2]); //Sets edit int
        if (target == null) { //Checks of player is online or not
            if (!(votec.containsKey(args[1]))) {
                player.sendMessage(ChatColor.DARK_RED + args[1] + " is not in the vote data base!");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
                votec.put(args[1], edit);
            }
        } else {
            player.sendMessage(ChatColor.DARK_RED + "You have edited " + args[1] + " votes");
            target.sendMessage(ChatColor.DARK_RED + "Your total votes have been edited by an Administrator!");
            votec.put(args[1], edit);
        }



        Player target = Bukkit.getPlayerExact(args[1]); //Makes
        int edit = Integer.parseInt(args[2]); //Sets edit int
        if (target == null) { //Checks of player is online or not
            player.sendMessage(ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
            votec.put(args[1], edit);
        } else {
            player.sendMessage(ChatColor.DARK_RED + "You have edited " + args[1] + " votes");
            target.sendMessage(ChatColor.DARK_RED + "Your total votes have been edited by an Administrator!");
            votec.put(args[1], edit);
        }






        return false;
    }
}
