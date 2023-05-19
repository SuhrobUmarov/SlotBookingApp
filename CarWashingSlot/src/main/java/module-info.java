module com.example.carwashingslot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carwashingslot to javafx.fxml;
    exports com.example.carwashingslot;
}