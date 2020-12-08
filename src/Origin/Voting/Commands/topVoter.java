package Origin.Voting.Commands;

import Origin.Voting.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class topVoter implements CommandExecutor {

    ArrayList<String> votet = new ArrayList<String>(); //Array list to store sorted top voters
    //int votesc;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;


        if (cmd.getName().equalsIgnoreCase("topvoters")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player!");
            } else {
                Map<Integer, String> map = sortByValues(Main.instance.votec);
                //After Sorting
                Set set2 = map.entrySet();
                Iterator iterator2 = set2.iterator();
                int votecs;
                votecs = Main.instance.votec.size();
                if (!(votecs < 10)) {
                    while (iterator2.hasNext()) {
                        Map.Entry me2 = (Map.Entry) iterator2.next();
                        votet.add(me2.getKey() + ": " + me2.getValue());
                    }
                    sender.sendMessage(ChatColor.AQUA + "Exhibit MineCraft Top Voters!");
                    sender.sendMessage("1) "  + ChatColor.GREEN + votet.get(votecs-1));
                    sender.sendMessage("2) " + ChatColor.GREEN  + votet.get(votecs-2));
                    sender.sendMessage("3) "  + ChatColor.GREEN + votet.get(votecs-3));
                    sender.sendMessage("4) "  + ChatColor.GREEN + votet.get(votecs-4));
                    sender.sendMessage("5) " + ChatColor.GREEN  + votet.get(votecs-5));
                    sender.sendMessage("6) "  + ChatColor.GREEN + votet.get(votecs-6));
                    sender.sendMessage("7) " + ChatColor.GREEN  + votet.get(votecs-7));
                    sender.sendMessage("8) "  + ChatColor.GREEN + votet.get(votecs-8));
                    sender.sendMessage("9) " + ChatColor.GREEN  + votet.get(votecs-9));
                    sender.sendMessage("10) " + ChatColor.GREEN + votet.get(votecs-10));
                    votet.clear();



                } else {
                    player.sendMessage(ChatColor.DARK_RED + "Ten Players need to vote for the server before this list is active.");
                    player.sendMessage(ChatColor.DARK_RED + "Currently " + votecs + " players have voted.");
                }

            }
        }

        return false;
    }

    private static HashMap sortByValues(HashMap map) { //all the sorting crap
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });


        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

}


