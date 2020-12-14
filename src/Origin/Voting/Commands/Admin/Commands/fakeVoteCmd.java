package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import Origin.Voting.Commands.Admin.AdminMsg;
import Origin.Voting.Listeners.newVote;
import Origin.Voting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

import static Origin.Voting.TNE.balance.addToBal;

public class fakeVoteCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {


        AdminMsg adminMsg = new AdminMsg(sender);
        if (args.length < 2){
            adminMsg.incorrectArgs();
            return false;
        }

        Player target = Bukkit.getPlayerExact(args[1]);
        if (target == null) {
            adminMsg.offlineTarget();
            return false;
        }

            if (Main.votec.containsKey(target.getUniqueId())) { //If user already in map
                Main.votec.put(target.getUniqueId(), Main.votec.get(target.getUniqueId())+1);
            } else {
                Main.votec.put(target.getUniqueId(), 1); //if user is not already in map
            }
            BigDecimal voteReward = new BigDecimal(1);
            addToBal(target,voteReward);
            newVote.coinRewardMessage(target, 1);
            Bukkit.broadcastMessage(target.getDisplayName() + ChatColor.RED + " has voted @ " + ChatColor.GREEN + "FakeVote"
                    + ChatColor.RED + " Type " + ChatColor.GREEN + "/vote " + ChatColor.RED + "to find out how to vote!"); //sends fakevote message


        return false;
    }
}
