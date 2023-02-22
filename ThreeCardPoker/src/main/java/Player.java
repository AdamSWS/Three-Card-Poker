import java.util.ArrayList;

public class Player {
    int anteBet, playBet, pairPlusBet, totalWinnings;
    Player () {
        anteBet = 5;
        pairPlusBet = 0;
        playBet = 0;
        totalWinnings = 0;
    }
    ArrayList<Card> hand;
}
