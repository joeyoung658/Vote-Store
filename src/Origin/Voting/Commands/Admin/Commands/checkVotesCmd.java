package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class checkVotesCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


        if (votec.containsKey(args[1])) {
            player.sendMessage(ChatColor.RED + args[1] +  " has " + votec.get(args[1]) + " votes!");
        } else {
            player.sendMessage(ChatColor.DARK_RED + args[1] + " is not in the vote data base!");
        }




        return false;
    }
}
