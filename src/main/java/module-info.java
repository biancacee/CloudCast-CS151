module com.example.cloudcastcs151 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cloudcastcs151 to javafx.fxml;
    exports com.example.cloudcastcs151;
}