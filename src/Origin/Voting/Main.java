package Origin.Voting;

/*todo
1) Add each player vote to hash map so they will be kept track of
2) Add raffle system
    A) Gives raffle ticket every x votes
    B) Command to put all players into a raffle and output a winner
    C) Command to reset raffle for the next month

*/

import England.Origin.FirstPlugin.Listeners.PlayerJoin;
import Origin.Voting.Commands.Store.Commands.*;
import Origin.Voting.Commands.Store.StoreCommandHandler;
import Origin.Voting.Commands.Store.StorePurchase;
import Origin.Voting.Commands.Store.StoreTabCompleter;
import Origin.Voting.Commands.Store.storeCmd;
import Origin.Voting.Commands.myChips;
import Origin.Voting.Listeners.playerJoinVote;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static Origin.Voting.Data.Votes.saveVotes.saveVotes;
import static Origin.Voting.Data.Votes.votesToHash.votesToHash;
import static Origin.Voting.TNE.balance.addToBal;


public class Main extends JavaPlugin implements Listener{
    public static HashMap<String, Integer> votec = new HashMap<>(); //Hashmap to store votes when server is online
    public static Main instance;

    @Override
    public void onEnable() {

        instance = this;


       // createConfig();
        votesToHash();
        saveVotesToFile();


        registerCommands();

        registerListeners();
        getLogger().info("Voting-Rewards has been enabled");
    }




    @Override
    public void onDisable() { //When plugin ends
        saveVotes();
        getLogger().info("Voting-Rewards has been disabled");
    }

    public void registerCommands() {
        registerStoreCommnds();

        this.getCommand("chips").setExecutor(new myChips());
        //this.getCommand("estore").setExecutor(new purchaseCommand());
    }


    public void registerStoreCommnds(){
        //For convenience' sake, we will initialize a variable.
        StoreCommandHandler StoreCommands = new StoreCommandHandler();
        StorePurchase storePurchase = new StorePurchase();

        //Registers the command /example which has no arguments.
        StoreCommands.register("store", new storeCmd());
        //Registers the command /example args based on args[0] (args)

        StoreCommands.register("back", new backCmd());
        storePurchase.registerCommandCost("back", new BigDecimal(500));

        StoreCommands.register("enderchest", new enderchestCmd());
        storePurchase.registerCommandCost("enderchest", new BigDecimal(300));

        StoreCommands.register("colours", new coloursCmd());
        storePurchase.registerCommandCost("colours", new BigDecimal(25));

        StoreCommands.register("togglekeepinven", new togglekeepinvenCmd());
        storePurchase.registerCommandCost("togglekeepinven", new BigDecimal(500));

        StoreCommands.register("togglekeepxp", new togglekeepxpCmd());
        storePurchase.registerCommandCost("togglekeepxp", new BigDecimal(150));

        StoreCommands.register("tpskip", new tpskipCmd());
        storePurchase.registerCommandCost("tpskip", new BigDecimal(100));

        StoreCommands.register("tag", new tagCmd());
        storePurchase.registerCommandCost("tag", new BigDecimal(25));

        StoreCommands.register("hat", new hatCmd());
        storePurchase.registerCommandCost("hat", new BigDecimal(25));

        StoreCommands.register("nickname", new nicknameCmd());
        storePurchase.registerCommandCost("nickname", new BigDecimal(25));

        StoreCommands.register("craftingtable", new craftingtableCmd());
        storePurchase.registerCommandCost("craftingtable", new BigDecimal(25));

        StoreCommands.register("home", new homeCmd());
        storePurchase.registerCommandCost("home", new BigDecimal(10));

        StoreCommands.register("help", new helpCmd());
        getCommand("store").setExecutor(StoreCommands);
        getCommand("store").setTabCompleter(new StoreTabCompleter());

    }


    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new playerJoinVote(), this);
    }

    @EventHandler(priority= EventPriority.NORMAL)
    public void onVotifierEvent(VotifierEvent event) {
        Vote v = event.getVote();
        Player player = Bukkit.getServer().getPlayer(v.getUsername()); //sets player as the voter
        Player target = Bukkit.getPlayerExact(v.getUsername()); //sets player as target

        if (!(target == null)) { //Checks if player is online
            Bukkit.broadcastMessage(target.getDisplayName() + ChatColor.RED + " has voted @ " + ChatColor.GREEN + v.getServiceName()
                    + ChatColor.RED + " Type " + ChatColor.GREEN + "/vote " + ChatColor.RED + "to find out how to vote!");

            BigDecimal voteReward = new BigDecimal(1);
            addToBal(player,voteReward);

            coinRewardMessage(target, 1);
            luckyVote(target);
            voteReward(target);

        } else { //If player is not online
            Main.instance.getLogger().info(v.getUsername() + " was not online so no rewards were given.");
        }
    }




    private void luckyVote (Player player){
        Integer coins = 0;
        if (ThreadLocalRandom.current().nextInt(100) == 5) {
            coins = 50;
        }
        if (ThreadLocalRandom.current().nextInt(500) == 5) {
           coins = 100;
        }
        if (ThreadLocalRandom.current().nextInt(1000) == 5) {
            coins = 1000;
        }
        if (coins == 0) {
            return;
        } else {
            Bukkit.broadcastMessage(player.getDisplayName() + ChatColor.GOLD + " was extra lucky and received " + ChatColor.GREEN +  coins.toString()   +
                    " chips!");
            BigDecimal luckyVoteReward = new BigDecimal(coins);
            addToBal(player,luckyVoteReward);
            coinRewardMessage(player, coins);
            return;
        }
    }

    private void voteReward(Player player){
        if (votec.containsKey(player.getName())) { //Updates vote counter
            votec.put(player.getName(), votec.get(player.getName()) + 1);
        } else {
            votec.put(player.getName(), 1);
        }

        Integer playersVotes = votec.get(player.getName());
        if (playersVotes == 30){
            //Give player a ticket
        }
        else if (playersVotes == 60){
            //Give player a ticket
        }
        else if (playersVotes == 90){
            //Give player two tickets


            BigDecimal standardVoteReward = new BigDecimal(200);
            addToBal(player,standardVoteReward);
            coinRewardMessage(player, 200);

        }


    }

    private void coinRewardMessage (Player player, Integer coins) {
        player.sendMessage(ChatColor.DARK_RED + "You have received " + ChatColor.AQUA + coins.toString() + " chips"+ ChatColor.DARK_RED + ", which can be spent on in game perks!");
        return;
    }

    private void saveVotesToFile(){
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
            @Override
            public void run() {
                saveVotes();
            }
        }, (20l * 60) * 30) ;
    }

}