package Origin.Voting;

/*todo
1) Add each player vote to hash map so they will be kept track of
2) Add raffle system
    A) Gives raffle ticket every x votes
    B) Command to put all players into a raffle and output a winner
    C) Command to reset raffle for the next month

*/

import Origin.Voting.Commands.Admin.AdminCommandHandler;
import Origin.Voting.Commands.Admin.AdminTabCompleter;
import Origin.Voting.Commands.Admin.Commands.*;
import Origin.Voting.Commands.Admin.adminCmd;
import Origin.Voting.Commands.Store.Commands.*;
import Origin.Voting.Commands.Store.StoreCommandHandler;
import Origin.Voting.Commands.Store.StorePurchase;
import Origin.Voting.Commands.Store.StoreTabCompleter;
import Origin.Voting.Commands.Store.storeCmd;
import Origin.Voting.Commands.myChips;
import Origin.Voting.Listeners.newVote;
import Origin.Voting.Listeners.playerJoinVote;
import Origin.Voting.Runnables.saveVotes;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

import static Origin.Voting.Data.Votes.saveVotes.saveVotes;
import static Origin.Voting.Data.createConfig.createConfig;
import static Origin.Voting.Listeners.newVote.coinRewardMessage;

import static Origin.Voting.Listeners.newVote.luckyVote;
import static Origin.Voting.TNE.balance.addToBal;


public class Main extends JavaPlugin implements Listener{
    public static HashMap<UUID, Integer> votec = new HashMap<>(); //Hashmap to store votes when server is online
    public static Main instance;

    @Override
    public void onEnable() {

        instance = this;
//        createConfig();
//
//        BukkitTask saveVotes =
//                new saveVotes(this)
//                        .runTaskTimerAsynchronously
//                                (this, (20l * 60) * 30, (20l * 60) * 30);
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
        registerAdminCommands();
        this.getCommand("chips").setExecutor(new myChips());
    }


    private void registerStoreCommnds(){
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

        StoreCommands.register("prefix", new prefixCmd());
        storePurchase.registerCommandCost("prefix", new BigDecimal(25));

        StoreCommands.register("hat", new hatCmd());
        storePurchase.registerCommandCost("hat", new BigDecimal(25));

        StoreCommands.register("nickname", new nicknameCmd());
        storePurchase.registerCommandCost("nickname", new BigDecimal(25));

        StoreCommands.register("craftingtable", new craftingtableCmd());
        storePurchase.registerCommandCost("craftingtable", new BigDecimal(25));

        StoreCommands.register("home", new homeCmd());
        storePurchase.registerCommandCost("home", new BigDecimal(10));

        StoreCommands.register("land", new landCmd());
        storePurchase.registerCommandCost("land", new BigDecimal(100));

        StoreCommands.register("help", new helpCmd());
        getCommand("store").setExecutor(StoreCommands);
        getCommand("store").setTabCompleter(new StoreTabCompleter());

    }

    private void registerAdminCommands(){
        AdminCommandHandler AdminCommands = new AdminCommandHandler();

        AdminCommands.register("avote", new adminCmd());

        //AdminCommands.register("check", new checkVotesCmd());
        //AdminCommands.register("clear", new clearVotesCmd());
        //AdminCommands.register("edit", new editVotesCmd());
        AdminCommands.register("fake", new fakeVoteCmd());
        //AdminCommands.register("raffle", new raffleCmd());
        //AdminCommands.register("save", new saveVotesCmd());

        getCommand("avote").setExecutor(AdminCommands);
        getCommand("avote").setTabCompleter(new AdminTabCompleter());

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

        } else { //If player is not online
            Main.instance.getLogger().info(v.getUsername() + " was not online so no rewards were given.");
        }
    }



}