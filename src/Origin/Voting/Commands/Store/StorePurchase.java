package Origin.Voting.Commands.Store;

import Origin.Voting.TNE.balance;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.math.BigDecimal;
import java.util.HashMap;

public class StorePurchase {

    private static HashMap<String, BigDecimal> commandCost = new HashMap<String, BigDecimal>();


    public void registerCommandCost(String name, BigDecimal cost){
        commandCost.put(name, cost);
    }

    public boolean commandCostExists(String name) {
        return commandCost.containsKey(name);
    }

    public BigDecimal getCommandCost(String name) {
        return commandCost.get(name);
    }

    //https://javadoc.io/doc/net.luckperms/api/latest/index.html

    public void givePlayerCommandAccess(Player player, String permission, String commandName, BigDecimal cost) {
        if (player == null) {
            return;
        }
        if (permission == null) {
            return;
        }
    try {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            Node node = Node.builder(permission).build();
            api.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
                DataMutateResult result = user.data().add(node);
                if (result.wasSuccessful()){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                            + ChatColor.AQUA + "You've purchased " + commandName + " for " + ChatColor.DARK_RED + cost + " chips");
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                            + ChatColor.RED + "Error: You already have access to " + commandName + " command!" );
                    balance.addToBal(player, cost);
                }
            });
        }

    } catch (Exception e){
        Bukkit.getLogger().info(e.toString());
    }
    }


    public void purchaseCommand(Player player, String commandName, String permission){
        if (!(this.commandCostExists(commandName))){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                   + ChatColor.RED + "Error: Command does not exist");
        }
        BigDecimal cost = this.getCommandCost(commandName);
        Boolean funds = balance.reduceToBal(player, cost);
        if (funds){
            this.givePlayerCommandAccess(player, permission, commandName, cost);
        } else {
            BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&' , "&e[&4Server&e]&f ")
                    + ChatColor.RED + "You have insufficient chip balance of " + bal.toString()+ "!");
        }
    }
}
