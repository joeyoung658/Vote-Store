package Origin.Voting.Commands.Store.Commands;

import Origin.Voting.Commands.Store.StoreCommandInterface;
import Origin.Voting.Commands.Store.StorePurchase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nicknameCmd implements StoreCommandInterface
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String commandLabel, String[] args) {
        Player p = (Player) sender;

        //We don't have to check if the args length is equal to one, but you will have to check if it is greater than 1.
        if(args.length > 1) return false;

        //broken
        String commandName = "nickname";
        String permission = "<FP>.nick";
        StorePurchase storePurchase = new StorePurchase();
        storePurchase.purchaseCommand(p,commandName,permission);
        return false;
    }

}
