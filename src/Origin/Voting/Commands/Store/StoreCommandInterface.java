package Origin.Voting.Commands.Store;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface StoreCommandInterface {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);
}
