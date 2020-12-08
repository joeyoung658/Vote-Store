package Origin.Voting.Commands.Admin.Commands;

import Origin.Voting.Commands.Admin.AdminCommandInterface;
import Origin.Voting.Commands.Admin.AdminMsg;
import Origin.Voting.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class clearVotesCmd implements AdminCommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (args.length > 1) {
            new AdminMsg(sender).incorrectArgs();
            return false;
        }
        sender.sendMessage(ChatColor.DARK_RED + "Vote Data base cleared");
        Main.votec.clear();
        Main.instance.getConfig().set("votec", null);
        Main.instance.saveConfig();
        return false;
    }
}
