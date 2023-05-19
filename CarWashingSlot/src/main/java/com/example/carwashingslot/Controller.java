package com.example.carwashingslot;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox<String> timeComboBox;

    @FXML
    private Button bookButton;

    @FXML
    private void initialize() {
        populateTimeSlots();
    }

    private void populateTimeSlots() {
        // Add available time slots to the ComboBox
        timeComboBox.getItems().addAll(
                "09:00 AM", "10:00 AM", "11:00 AM",
                "12:00 PM", "01:00 PM", "02:00 PM",
                "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM"
        );
    }

    @FXML
    private void bookSlot() {
        String name = nameTextField.getText();
        String selectedSlot = timeComboBox.getValue();

        if (!isValidName(name)) {
            showAlert("Error", "Please enter a valid name.");
            return;
        }

        if (selectedSlot == null || selectedSlot.isEmpty()) {
            showAlert("Error", "Please select a time slot.");
            return;
        }

        // Process the booking
        System.out.println("Booking confirmed!");
        System.out.println("Name: " + name);
        System.out.println("Time Slot: " + selectedSlot);

        // Reset the fields
        nameTextField.clear();
        timeComboBox.getSelectionModel().clearSelection();
    }

    private boolean isValidName(String name) {
        // Regular expression pattern to allow only alphabetic characters and spaces
        String pattern = "^[a-zA-Z ]+$";
        return name.matches(pattern);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
