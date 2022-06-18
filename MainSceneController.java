package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

public class MainSceneController {
	Alert alert = new Alert(AlertType.ERROR);
    
	@FXML
	private TextField numberBox;
	@FXML
	private Button plusB;
	@FXML
	private Button minusB;
	@FXML
	private Button divideB;
	@FXML
	private Button multB;
	@FXML
	private Button modB;
	@FXML
	private Button logB;
	@FXML
	private Button sqrB;
	@FXML
	private Button eB;
	@FXML
	private TextField numberBox2;
	@FXML
	private Button equals;
	private int result;
	private int value1;
	private int value2;
	private String symbol;
	Image image = new Image("https://c.tenor.com/3FC0GaZWrIoAAAAC/xqc-xqc-mald.gif");
	ImageView im = new ImageView(image);
	

	public void plusChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		String second = numberBox2.getText();
		this.value2 = Integer.parseInt(second);
		this.result = value1 + value2;
		numberBox.setText("" + result);
		numberBox2.setText("0");
	}
	public void minusChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		String second = numberBox2.getText();
		this.value2 = Integer.parseInt(second);
		this.result = value1 - value2;
		if (result < 0) {
			numberBox.setText("" + (~(result)));
			numberBox2.setText("0");
		} else {
			numberBox.setText("" + result);
			numberBox2.setText("0");
		}
		
	}

	public void divideChange() {
		try {
			String intial = numberBox.getText();
			this.value1 = Integer.parseInt(intial);
			String second = numberBox2.getText();
			this.value2 = Integer.parseInt(second);
			this.result = value1 / value2;
			if (value2 !=0) {
				numberBox.setText("" + result);
				numberBox2.setText("0");
			}
		} catch (Exception e) {
			im.setPreserveRatio(true);
			im.setFitWidth(80);
			alert.setGraphic(im);
			alert.setHeaderText("Input not valid");
			alert.setContentText("Cannot Divide by 0");
			alert.showAndWait();
			//System.err.print("w");
		}
	}
	
	public void multiplyChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		String second = numberBox2.getText();
		this.value2 = Integer.parseInt(second);
		this.result = value1 * value2;
		numberBox.setText("" + result);
		numberBox2.setText("0");
	}

	public void moduleChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		String second = numberBox2.getText();
		this.value2 = Integer.parseInt(second);
		this.result = value1 % value2;
		numberBox.setText("" + result);
		numberBox2.setText("0");
	}

	public void logChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		this.result = (int)Math.log(value1);
		numberBox.setText("" + result);
		numberBox2.setText("0");
	}
	
	public void rootChange() {
		String intial = numberBox.getText();
		this.value1 = Integer.parseInt(intial);
		this.result = (int)Math.sqrt(value1);
		numberBox.setText("" + result);
		numberBox2.setText("0");
	}
	// Event Listener on Button[#plusB].onAction
	@FXML
	public void plus(ActionEvent event) {
		this.symbol = "plus";
	}

	// Event Listener on Button[#minusB].onAction
	@FXML
	public void minus(ActionEvent event) {
		this.symbol = "minus";
	}

	// Event Listener on Button[#divideB].onAction
	@FXML
	public void divide(ActionEvent event) {
		this.symbol = "divide";
	}

	// Event Listener on Button[#multB].onAction
	@FXML
	public void multiply(ActionEvent event) {
		this.symbol = "multiply";
	}

	// Event Listener on Button[#modB].onAction
	@FXML
	public void module(ActionEvent event) {
		this.symbol = "module";
	}

	// Event Listener on Button[#logB].onAction
	@FXML
	public void log(ActionEvent event) {
		this.symbol = "log";
	}

	// Event Listener on Button[#sqrB].onAction
	@FXML
	public void root(ActionEvent event) {
		this.symbol = "root";
	}

	// Event Listener on Button[#equals].onAction
	@FXML
	public void equal(ActionEvent event) {
		switch (this.symbol) {
			case "plus":
				plusChange();
				break;
			case "minus":
				minusChange();
				break;
			case "divide":
				divideChange();
				break;
			case "multiply":
				multiplyChange();
				break;
			case "module":
				moduleChange();
				break;
			case "log":
				logChange();
				break;
			case "root":
				rootChange();
				break;
		}
	}
}
