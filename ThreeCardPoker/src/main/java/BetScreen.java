import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BetScreen extends JavaFXTemplate{

    public Scene display() {

        // setting up the background image for the app
        hsbd = new Image("backgroundphoto.jpg");
        hbi = new BackgroundImage(hsbd, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        hb = new Background(hbi);

        // setting up the header for the bet scene 1
        p1h = new Text(225, 150, "Player One");
        p1h.setFont(dqd);
        p1h.setFill(Color.WHITESMOKE);
        p1h.setUnderline(true);

        // setting up the dealers message
        dm1 = new Text(30, 220, "DEALER SAYS: 'PLACE YOUR BETS!'");
        dm1.setFont(Font.font("Cambria Math", FontWeight.BOLD, FontPosture.REGULAR, 40));
        dm1.setFill(Color.WHITESMOKE);

        // setting up the ante dail
        ad = new Text(140, 280, "Ante        :       5                         25");
        ad.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        ad.setFill(Color.GREEN);

        // setting up the pairs plus dial
        ppd = new Text(140, 330, "Pair Plus:       5                         25");
        ppd.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        ppd.setFill(Color.RED);

        // setting up the balance tab for player one
        b1 = new Text(650, 10, "0");
        b1.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        b1.setFill(Color.GOLD);

        // setting up the less than button
        lti = new Image("LessThanIMG.png");
        ltv1 = new ImageView(lti);
        ltv2 = new ImageView(lti);

        // setting up the greater than button
        gti = new Image("GreaterThanIMG.png");
        gtv1 = new ImageView(gti);
        gtv2 = new ImageView(gti);

        // setting up bet dial buttons
        inc1 = new Button("", gtv1);
        dec1 = new Button("", ltv1);
        inc2 = new Button("", gtv2);
        dec2 = new Button("", ltv2);

        //		ab1 = new Text(String.valueOf(player1.anteBet));
        //		ab1.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        //		ppb1 = new Text(String.valueOf(player1.pairPlusBet));
        //		ppb1.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 10));

        // organizing the above buttons into two horizontal boxes and 1 vertical box
        l1 = new HBox(40, dec1, inc1);
        l2 = new HBox(40, dec2, inc2);
        v1 = new VBox(15, l1, l2);

        // setting layout for the vertical box
        v1.setLayoutX(320);
        v1.setLayoutY(255);

        // setting up the player 1 display for the bottom right corner of the screen
        p1i = new Text("Player 1's current stats:\n" +
                "Ante Bet: \n" +
                "Pair Plus Bet: \n" +
                "Play Bet: \n" +
                "Total Winnings:\n");
        p1i.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        p1i.setFill(Color.WHITESMOKE);

        // setting up the player 2 display for the bottom right corner of the screen
        p2i = new Text("Player 2's current stats:\n" +
                "Ante Bet: \n" +
                "Pair Plus Bet: \n" +
                "Play Bet: \n" +
                "Total Winnings:\n");
        p2i.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        p2i.setFill(Color.WHITESMOKE);

        // setting up a VBox for the player info
        pi = new VBox(10, p1i, p2i);

        // setting layout for the vertical box
        pi.setLayoutX(10);
        pi.setLayoutY(400);

        // setting up the next button
        nxt1i = new Image("NextButtonIMG.png");
        nxt1v = new ImageView(nxt1i);
        nxt1 = new Button("", nxt1v);

        // setting up the options button
        opni = new Image("OptionsButtonIMG.png");
        opnv = new ImageView(opni);
        opn = new Button("", opnv);

        // setting up a vBox for betting scene 1
        bs1 = new VBox(50, nxt1, opn);
        bs1.setLayoutX(350);
        bs1.setLayoutY(400);

        // setting up the border pane for the bet scene 1
        b1p = new BorderPane();
        b1p.setBackground(hb);
        b1p.getChildren().addAll(p1h, dm1, ad, ppd, v1, b1, pi, bs1);

        // bet1 scene initializations
        bet1 = new Scene(b1p, 700, 700);
        return bet1;
    }
}
