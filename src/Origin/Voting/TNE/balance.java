package Origin.Voting.TNE;

import net.tnemc.core.TNE;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.math.MathContext;

public class balance {

    public static void addToBal(Player player, BigDecimal value){
        //Gets Balance of player and increases depending on value
        BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
        BigDecimal zero = new BigDecimal( 0);

        if (bal == zero) {
            TNE.instance().api().getAccount(player.getUniqueId()).setHoldings(value);
        } else {
            MathContext mc = new MathContext(4);
            BigDecimal newBal = bal.add(value,mc);
            TNE.instance().api().getAccount(player.getUniqueId()).setHoldings(newBal);
        }



    }
    public static Boolean reduceToBal(Player player, BigDecimal value){
        //Gets Balance of player and decreases depending on value
        BigDecimal bal = TNE.instance().api().getAccount(player.getUniqueId()).getHoldings();
        BigDecimal zero = new BigDecimal( 0);
        if (bal.equals(zero)){
            return false;
        } else if (bal.compareTo(value) < 0 ) {
            return false;
        }
        MathContext mc = new MathContext(4);
        BigDecimal newBal = bal.subtract(value, mc);
        TNE.instance().api().getAccount(player.getUniqueId()).setHoldings(newBal);
        return true;
    }
}
