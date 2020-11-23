package Origin.Voting.Commands;

import Origin.Voting.TNE.balance;
import net.tnemc.core.TNE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.util.HashMap;

public class purchaseCommand implements CommandExecutor {
    HashMap<String, Integer> votec = new HashMap<>(); //Hashmap to store votes when server is online
//    ArrayList<String> votet = new ArrayList<String>(); //Array list to store sorted top voters
//    int votesc;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("estore")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player!");
            } else {
                if (args.length == 0) { //Sender only typed '/estore' and nothing else
                    player.sendMessage(ChatColor.AQUA + "eCoin Store commands - Please note this will not change eCoin Balance");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore home - 10 eCoin");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore workbench - 25 eCoin");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore nickname - 25 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore hat - 25 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore tag - 25 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore tpskip - 100 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore togglekeepexp - 150 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore togglekeepinven - 500 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore colours - 25 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore enderchest - 300 eCoins");
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/estore back - 500 eCoins");
                } else { //if the user has typed more than rules
                     if (args[0].equalsIgnoreCase("home")) {
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(10);
                             Boolean funds = balance.reduceToBal(player, cost);
                             if (funds){
                                 String command = "ahome increase " + player.getName() +  " 1";
                                 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                                 player.sendMessage(ChatColor.AQUA + "You've purchased a home for" + ChatColor.DARK_RED +  "10 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }

                    } else if (args[0].equals("workbench")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(25);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.workbench";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased workbench for" + ChatColor.DARK_RED +  "25 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("nickname")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(25);
                             Boolean funds = balance.reduceToBal(player, cost);;
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.nick";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased nickname for" + ChatColor.DARK_RED +  "25 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("colours")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(25);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.ColourCodesChat";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased colours for" + ChatColor.DARK_RED +  "25 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("hat")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(25);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.hat";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased hat for" + ChatColor.DARK_RED +  "25 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("tag")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(25);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.prefix";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased customprefix for" + ChatColor.DARK_RED +  "25 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("tpskip")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(100);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.BYPASS.TPCOOL";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased tpskip for" + ChatColor.DARK_RED +  "100 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("togglekeepexp")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(150);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.keepxp";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased togglekeepexp for" + ChatColor.DARK_RED +  "150 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("togglekeepinven")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(500);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.keepinven";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased togglekeepinven for" + ChatColor.DARK_RED +  "500 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     }  else if (args[0].equals("enderchest")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(300);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.enderchest";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased enderchest for" + ChatColor.DARK_RED +  "300 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     } else if (args[0].equals("back")){
                         if (!(args.length == 1)) {
                             player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                         } else {
                             BigDecimal cost = new BigDecimal(500);
                             Boolean funds = balance.reduceToBal(player, cost);
                             //CHange perm
                             if (funds){
                             String command = "manuaddp " + player.getName() +  " <FP>.back";
                             Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                             player.sendMessage(ChatColor.AQUA + "You've purchased back for" + ChatColor.DARK_RED +  "500 eCoins");
                             } else {
                                 BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
                                 player.sendMessage(ChatColor.RED + "You have insufficient eCoin balance of " + bal.toString()+ "!");
                             }
                         }
                     }
                        else {
                        player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /estore for help.");
                    }
                }
            }
            return true;
        }
        return false;
    }

}
