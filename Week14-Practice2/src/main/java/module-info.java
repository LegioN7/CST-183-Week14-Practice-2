module com.example.week14practice2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week14practice2 to javafx.fxml;
    exports com.example.week14practice2;
}