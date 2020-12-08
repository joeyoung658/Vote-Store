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

public class editVotesCmd implements AdminCommandInterface {

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (args.length > 3){
            new AdminMsg(sender).incorrectArgs();
            return false;
        }

        Player target = Bukkit.getPlayerExact(args[1]); //Makes
        int editAmount = Integer.parseInt(args[2]);
        if (target == null) { //Checks of player is online or not

            OfflinePlayer offlineTarget = Bukkit.getOfflinePlayer(args[1]);
            if (!(offlineTarget.hasPlayedBefore())){
                new AdminMsg(sender).neverPlayedBefore();
                return false;
            }

            if (!(Main.votec.containsKey(args[1]))) {
                sender.sendMessage(new AdminMsg(sender).getServerPrefix() + ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
                Main.votec.put(offlineTarget.getUniqueId(), editAmount);
            } else {
                sender.sendMessage(new AdminMsg(sender).getServerPrefix() + ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
                Main.votec.put(offlineTarget.getUniqueId(), editAmount);
            }

        } else {
            sender.sendMessage(new AdminMsg(sender).getServerPrefix() +  ChatColor.DARK_RED + "You have edited " + target.getDisplayName() + " votes");
            target.sendMessage(new AdminMsg(sender).getServerPrefix() + ChatColor.DARK_RED + "Your total votes have been edited by an Administrator!");
            Main.votec.put(target.getUniqueId(), editAmount);

        }
        return false;
    }
}
