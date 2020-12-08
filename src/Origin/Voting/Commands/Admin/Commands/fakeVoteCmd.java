package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import Origin.Voting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fakeVoteCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


        if (args.length > 2){
            sender.sendMessage("Incorrect args!");
            return false;
        }

        Player target = Bukkit.getPlayerExact(args[1]);
        if (target == null) { //if user is not online
            sender.sendMessage(ChatColor.DARK_RED + args[1] + " is not online!");
            return false;
        }
            if (Main.votec.containsKey(args[1])) { //If user already in map
                Main.votec.put(target.getName(), Main.votec.get(target.getName())+1);
            } else {
                Main.votec.put(args[1], 1); //if user is not already in map
            }
            Bukkit.broadcastMessage(target.getDisplayName() + ChatColor.RED + " has voted @ " + ChatColor.GREEN + "FakeVote"
                    + ChatColor.RED + " Type " + ChatColor.GREEN + "/vote " + ChatColor.RED + "to find out how to vote!"); //sends fakevote message


        return false;
    }
}
