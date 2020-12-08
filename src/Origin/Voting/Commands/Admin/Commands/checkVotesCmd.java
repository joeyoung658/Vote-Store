package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import Origin.Voting.Commands.Admin.AdminMsg;
import Origin.Voting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class checkVotesCmd implements AdminCommandInterface {

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (args.length > 2){
            new AdminMsg(sender).incorrectArgs();
            return false;
        }
        UUID targetUUID;
        Player target = Bukkit.getPlayerExact(args[1]);

        if (target == null){
            OfflinePlayer offlineTarget = Bukkit.getOfflinePlayer(args[1]);
            if (!(offlineTarget.hasPlayedBefore())){
                new AdminMsg(sender).neverPlayedBefore();
                return false;
            }
            targetUUID = offlineTarget.getUniqueId();
        } else {
            targetUUID = target.getUniqueId();
        }

        if (Main.votec.containsKey(targetUUID)) {
            sender.sendMessage(new AdminMsg(sender).getServerPrefix() + ChatColor.RED + args[1] +  " has " + Main.votec.get(targetUUID) + " votes!");
        } else {
            sender.sendMessage(new AdminMsg(sender).getServerPrefix() + ChatColor.DARK_RED + args[1] + " is not in the vote data base!");
        }
        return false;
    }
}
