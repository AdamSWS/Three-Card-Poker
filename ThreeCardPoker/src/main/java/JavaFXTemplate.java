import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.lang.model.util.AbstractElementVisitor14;

import java.util.Timer;
import java.util.TimerTask;

import static javafx.application.Platform.exit;

public class JavaFXTemplate extends Application implements EventHandler<ActionEvent> {

	// ALL CLASS DECLARATIONS

	// all button declarations
	Button sb, inc1, inc2, dec1, dec2, nxt1, nxt2, opn, ffb, play, fold, playAgain, extb, fsb, nlb, bckb;

	// all hBox declarations
	HBox l1, l2, buttonBox, headerBox, nlhb, fshb, ehb;

	// all vBox declarations
	VBox v1, pi, pi2, bs1, optbx, bckBx, bs2;

	// all borderPane declarations
	BorderPane sp, b1p, opnp,b2p, loadingPane, displayPane, winPane, losePane, foldPane, ldg1p, ldg2p;

	// all imageView declarations
	ImageView lv, sbv, sdlv, sdrv, opnv, nxt1v, gtv1, gtv2, ltv1, ltv2, nlv, fsv, extv, bckv, ffv;

	// all rotate transitions declarations
	RotateTransition rtsl, rtsr;

	// all scene declarations
	Scene temp, home, bet1, option, loading1, loading2;

	// all sequential transitions
	SequentialTransition st1, st2;

	// image object to store the jpeg of the background photo
	Image hsbd, li, sbi, sdl, sdr, opni, nxt1i, gti, lti, nli, fsi, exti, bcki, ffi;

	// backgroundImage object to store the image object of the background photo
	BackgroundImage hbi;

	// Background object to store the background image object to input in the BorderPane root
	Background hb;

	// text object to store the name of the game
	Text gt, gtSub, p1h, p2h, dm1, dm2, ppd, ad, ppb1, ab1, ppb2, ab2, b1, b2, p1i, p2i, p1i2, p2i2, nldt, fsdt, edt, msg1;

	// loading in custom fonts
	Font dqd;

	// both players
	Player player1, player2;

	// all timer declarations
	Timer t1;

	// all timer task declarations
	TimerTask tt1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Three Hand Poker");

		// setting up the delinquente demo font
		dqd = Font.loadFont("file:src/main/resources/DelinquenteDemo-6Zw1.ttf", 45);

		// setting up the background image for the app
		hsbd = new Image("backgroundphoto.jpg");
		hbi = new BackgroundImage(hsbd, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		hb = new Background(hbi);

		// setting up header for game
		gt = new Text(170, 150, "Three Card Poker");
		gt.setFont(dqd);
		gt.setFill(Color.WHITESMOKE);
		gt.setUnderline(true);
		gtSub = new Text(270, 200, "A 2 PLAYER GAME");
		gtSub.setFill(Color.WHITESMOKE);
		gtSub.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.ITALIC, 20));

		// 777 Image Setup
		li = new Image("777lucky.png");
		lv = new ImageView(li);
		lv.setX(220);
		lv.setY(400);

		// start button
		sbi = new Image("PlayGameButtonIMG.png");
		sbv = new ImageView(sbi);
		sb = new Button("",sbv);

		// button functionality
		sb.setOnAction(e -> {
			primaryStage.setScene(bet1);
			player1 = new Player();
			player2 = new Player();
		});

		// suit design left
		sdl = new Image("HeartsPhoto.png");
		sdlv = new ImageView(sdl);
		sdlv.setY(250);
		sdlv.setX(30);

		// suit design left spinning transition
		rtsl = new RotateTransition(Duration.millis(5000), sdlv);
		rtsl.setByAngle(360);
		rtsl.setCycleCount(10000);
		rtsl.setAutoReverse(true);
		st1 = new SequentialTransition (
				new PauseTransition(Duration.millis(500)),
				rtsl
		);
		st1.play();

		//suit design right
		sdr = new Image("CloverPhoto.png");
		sdrv = new ImageView(sdr);
		sdrv.setY(250);
		sdrv.setX(540);

		// suit design right spinning transition
		rtsr = new RotateTransition(Duration.millis(5000), sdrv);
		rtsr.setByAngle(360);
		rtsr.setCycleCount(10000);
		rtsr.setAutoReverse(true);
		st2 = new SequentialTransition (
				new PauseTransition(Duration.millis(500)),
				rtsr
		);
		st2.play();

		// setting up the border pane for the start screen
		sp = new BorderPane();
		sp.setBackground(hb);
		sp.setCenter(sb);
		sp.getChildren().addAll(gt, gtSub, lv, sdlv, sdrv);

		// home scene initializations
		home = new Scene(sp, 700,700);

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

		// setting up next button functionality
		nxt1.setOnAction(e -> primaryStage.setScene(loading1));

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

		// setting up the option button on the first betting page
		opn.setOnAction(e -> {
			temp = primaryStage.getScene();
			primaryStage.setScene(option);
		});

		// setting up the new look button
		nli = new Image("NewLookIMG.png");
		nlv = new ImageView(nli);
		nlb = new Button("", nlv);

		// setting up the description for the new look button
		nldt = new Text("Dark Mode");
		nldt.setFont(Font.font("Cambria Math", FontWeight.BOLD, FontPosture.REGULAR, 40));
		nldt.setFill(Color.WHITESMOKE);

		// setting up the new look hBox
		nlhb = new HBox(100, nlb, nldt);

		// setting up the fresh start button
		fsi = new Image("FreshStartIMG.png");
		fsv = new ImageView(fsi);
		fsb = new Button("", fsv);

		// setting up the description for the new look button
		fsdt = new Text("Reset & Restart");
		fsdt.setFont(Font.font("Cambria Math", FontWeight.BOLD, FontPosture.REGULAR, 40));
		fsdt.setFill(Color.WHITESMOKE);

		// setting up the fresh start hBox
		fshb = new HBox(100, fsb, fsdt);

		// setting up the exit button
		exti = new Image("ExitIMG.png");
		extv = new ImageView(exti);
		extb = new Button("", extv);

		// setting up the description for the new look button
		edt = new Text("Exit and Close Program");
		edt.setFont(Font.font("Cambria Math", FontWeight.BOLD, FontPosture.REGULAR, 40));
		edt.setFill(Color.WHITESMOKE);

		// setting up the exit hBox
		ehb = new HBox(100, extb, edt);

		// setting up the player 1 display for the bottom right corner of the screen
		p1i2 = new Text("Player 1's current stats:\n" +
				"Ante Bet: \n" +
				"Pair Plus Bet: \n" +
				"Play Bet: \n" +
				"Total Winnings:\n");
		p1i2.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		p1i2.setFill(Color.WHITESMOKE);

		// setting up the player 2 display for the bottom right corner of the screen
		p2i2 = new Text("Player 2's current stats:\n" +
				"Ante Bet: \n" +
				"Pair Plus Bet: \n" +
				"Play Bet: \n" +
				"Total Winnings:\n");
		p2i2.setFont(Font.font("Cambria Math", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		p2i2.setFill(Color.WHITESMOKE);

		pi2 = new VBox(10, p1i2, p2i2);
		// setting layout for the vertical box
		pi2.setLayoutX(10);
		pi2.setLayoutY(400);

		// setting up a vertical box for the option scene buttons
		optbx = new VBox(50, nlhb, fshb, ehb, pi2);
		optbx.setLayoutY(10);
		optbx.setLayoutX(10);

		// setting up the next button
		bcki = new Image("BackIMG.png");
		bckv = new ImageView(bcki);
		bckb = new Button("", bckv);

		// back button compatability
		bckb.setOnAction(e -> primaryStage.setScene(temp));
		extb.setOnAction(e -> {exit();});

		// setting up the vbox for the back button
		bckBx = new VBox(50, bckb);
		bckBx.setLayoutY(600);
		bckBx.setLayoutX(500);

		// setting up the border pane for the option scene
		opnp = new BorderPane();
		opnp.setBackground(hb);
		opnp.getChildren().addAll(optbx, bckBx);

		// option scene initializations
		option = new Scene(opnp,700, 700);

		primaryStage.setScene(home);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent actionEvent) {
	}
}