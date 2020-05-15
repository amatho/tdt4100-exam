package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

	private String message;

	@FXML
	private void initialize() {
		message = Sample.hello();
	}

	@FXML
	private Button clickMeButton;

	@FXML
	private void handleClickMe() {
		clickMeButton.setText(message);
	}
}
