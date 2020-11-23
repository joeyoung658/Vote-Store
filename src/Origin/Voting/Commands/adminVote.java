//package Origin.Voting.Commands;
//
//
//import Origin.Voting.Main;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//
//import org.bukkit.entity.Player;
//import java.util.HashMap;
//
//
//public class adminVote implements CommandExecutor {
//    HashMap<String, Integer> votec = new HashMap<>(); //Hashmap to store votes when server is online
////    ArrayList<String> votet = new ArrayList<String>(); //Array list to store sorted top voters
////    int votesc;
//
//    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//        Player player = (Player) sender;
//        if (cmd.getName().equalsIgnoreCase("avote")) {
//            if (!(sender instanceof Player)) {
//                sender.sendMessage("This command can only be run by a player!");
//            } else {
//                if (args.length == 0) { //Sender only typed '/avote' and nothing else
//                    player.sendMessage(ChatColor.AQUA + "Admin Vote commands - Please note this will not change eCoin Balance");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote - View help for vote rewards");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote fakevote [PlayerName]  - Sends a fake vote to the user");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote check [playername ]- Checks a players vote count");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote edit [PlayerName] [Vote count] - Edits users votes");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote offedit [PlayerName] [Vote count] - Edits a user not in the database votes");
//                    player.sendMessage(ChatColor.LIGHT_PURPLE + "/avote clear - Clears all votes within database");
//                } else { //if the user has typed more than rules
//                    if (args[0].equalsIgnoreCase("fakevote")) {
//                        Player target = Bukkit.getPlayerExact(args[1]);
//                        if (!(args.length == 2)) {//if user types /fakevote and nothing else
//                            player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /avote for help."); //
//                        } else {
//                            if (target == null) { //if user is not online
//                                player.sendMessage(ChatColor.DARK_RED + args[1] + " is not online!");
//                                return false;
//                            } else {
//                                if (votec.containsKey(args[1])) { //If user already in map
//                                    votec.put(target.getName(), votec.get(target.getName())+1);
//                                } else {
//                                    votec.put(args[1], 1); //if user is not already in map
//                                }
//                                Bukkit.broadcastMessage(target.getDisplayName() + ChatColor.RED + " has voted @ " + ChatColor.GREEN + "FakeVote"
//                                        + ChatColor.RED + " Type " + ChatColor.GREEN + "/vote " + ChatColor.RED + "to find out how to vote!"); //sends fakevote message
//                            }
//                        }
//
//
//                    } else if (args[0].equalsIgnoreCase("edit")) {
//                        if (!(args.length == 3)) {
//                            player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /avote for help.");
//                        } else {
//                            Player target = Bukkit.getPlayerExact(args[1]); //Makes
//                            int edit = Integer.parseInt(args[2]); //Sets edit int
//                            if (target == null) { //Checks of player is online or not
//                                if (!(votec.containsKey(args[1]))) {
//                                    player.sendMessage(ChatColor.DARK_RED + args[1] + " is not in the vote data base!");
//                                } else {
//                                    player.sendMessage(ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
//                                    votec.put(args[1], edit);
//                                }
//                            } else {
//                                player.sendMessage(ChatColor.DARK_RED + "You have edited " + args[1] + " votes");
//                                target.sendMessage(ChatColor.DARK_RED + "Your total votes have been edited by an Administrator!");
//                                votec.put(args[1], edit);
//                            }
//                        }
//
//                    } else if (args[0].equalsIgnoreCase("offedit")) {
//                        if (!(args.length == 3)) {
//                            player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /avote for help.");
//                        } else {
//                            Player target = Bukkit.getPlayerExact(args[1]); //Makes
//                            int edit = Integer.parseInt(args[2]); //Sets edit int
//                            if (target == null) { //Checks of player is online or not
//                                player.sendMessage(ChatColor.DARK_RED + "You have edited (Offline)" + args[1] + " votes");
//                                votec.put(args[1], edit);
//                            } else {
//                                player.sendMessage(ChatColor.DARK_RED + "You have edited " + args[1] + " votes");
//                                target.sendMessage(ChatColor.DARK_RED + "Your total votes have been edited by an Administrator!");
//                                votec.put(args[1], edit);
//                            }
//                        }
//
//                    }else if (args[0].equalsIgnoreCase("clear")) {
//                        player.sendMessage(ChatColor.DARK_RED + "Vote Data base cleared");
//                        votec.clear();
//                        Main.instance.getConfig().set("votec", null);
//                        Main.instance.saveConfig();
//                    }else if (args[0].equalsIgnoreCase("check")) {
//                        if (!(args.length == 2)) {
//                            player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /avote for help.");
//                        } else {
//                            if (votec.containsKey(args[1])) {
//                                player.sendMessage(ChatColor.RED + args[1] +  " has " + votec.get(args[1]) + " votes!");
//                            } else {
//                                player.sendMessage(ChatColor.DARK_RED + args[1] + " is not in the vote data base!");
//                            }
//                        }
//
//                    } else if (args[0].equalsIgnoreCase("save")) {
//                        player.sendMessage(ChatColor.RED + "Data base updated to latest votes!");
//                        Main.instance.savevotes();
//                    }else {
//                        player.sendMessage(ChatColor.DARK_RED + "Incorrect arguments type /avote for help.");
//                    }
//                }
//            }
//            return true;
//        }
//
//
//        return false;
//    }
//
//}