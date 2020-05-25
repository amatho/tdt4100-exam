module ord2020 {
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires junit;

	exports sample;
	exports food;

	opens sample to javafx.fxml;
	opens food to javafx.fxml;
}
