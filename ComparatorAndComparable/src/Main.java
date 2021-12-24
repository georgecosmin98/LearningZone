import Comparator.Player;
import Comparator.PlayerAgeComparator;
import Comparator.PlayerNameComparator;
import Comparator.PlayerRankingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        Player player4 = new Player(39, "Trevor", 23);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);

        PlayerRankingComparator playerComparator = new PlayerRankingComparator();
        Collections.sort(footballTeam, playerComparator);
        System.out.println("After PlayerRankingSorting : " + footballTeam);

        PlayerAgeComparator playerAgeComparator = new PlayerAgeComparator();
        Collections.sort(footballTeam, playerAgeComparator);
        System.out.println("After PlayerAgeComparator : " + footballTeam);

        PlayerNameComparator playerNameComparator = new PlayerNameComparator();
        Collections.sort(footballTeam, playerNameComparator);
        System.out.println("After PlayerNameComparator : " + footballTeam);
    }
}
