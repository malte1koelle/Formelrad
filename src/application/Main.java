package application;

import java.io.FileInputStream;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(new FileInputStream("src/application/formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label error = new Label("");
			error.relocate(10, 280);
			error.setTextFill(Color.web("#c70a0a"));
			root.getChildren().add(error);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 300);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			TextField txLeistung = new TextField();
			txLeistung.relocate(100, 300);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 340);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			TextField txSpannung = new TextField();
			txSpannung.relocate(100, 340);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 380);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			TextField txStrom = new TextField();
			txStrom.relocate(100, 380);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 420);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			TextField txWiderstand = new TextField();
			txWiderstand.relocate(100, 420);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);

			Button btnBerechnen = new Button();
			btnBerechnen.relocate(100, 460);
			btnBerechnen.setText("Berechnen");
			root.getChildren().add(btnBerechnen);


			
			btnBerechnen.setOnAction(e -> {
				int counter = 0;
				Calculator calculator = new Calculator();
				if(!txLeistung.getText().isEmpty() && isNumeric(txLeistung.getText())){
					calculator.setLeistung(Double.parseDouble(txLeistung.getText()));
					counter++;
				}
				if(!txSpannung.getText().isEmpty() && isNumeric(txSpannung.getText())) {
					calculator.setSpannung(Double.parseDouble(txSpannung.getText()));
					counter++;
				}
				if(!txStrom.getText().isEmpty() && isNumeric(txStrom.getText())) {
					calculator.setStrom(Double.parseDouble(txStrom.getText()));
					counter++;
				}
				if(!txWiderstand.getText().isEmpty() && isNumeric(txWiderstand.getText())) {
					calculator.setWiderstand(Double.parseDouble(txWiderstand.getText()));
					counter++;
				}

				if(counter != 2){
					error.setText("Fill out exactly 2 fields with numeric values!");
				}
				else{
					error.setText("");
					calculator.calculate();
					DecimalFormat f = new DecimalFormat("###0.00");

					txLeistung.setText(f.format(calculator.getLeistung()));
					txSpannung.setText(f.format(calculator.getSpannung()));
					txStrom.setText(f.format(calculator.getStrom()));
					txWiderstand.setText(f.format(calculator.getWiderstand()));
				}
			});

			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static boolean isNumeric(String str)
	{
		try
		{
			double d = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
}
