package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import Origin.Voting.Commands.Admin.AdminMsg;
import Origin.Voting.Main;
import Origin.Voting.Runnables.saveVotes;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

public class saveVotesCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        AdminMsg adminMsg = new AdminMsg(sender);
        if (args.length > 1){
           adminMsg.incorrectArgs();
            return false;
        }

        BukkitTask saveVotes =
                new saveVotes(Main.instance)
                        .runTaskAsynchronously(Main.instance);
        sender.sendMessage(adminMsg.getServerPrefix() + ChatColor.RED + "Votes");
        return false;
    }
}
