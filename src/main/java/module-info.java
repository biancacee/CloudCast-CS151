module com.example.cloudcastcs151 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires json.simple;


    opens com.example.cloudcastcs151 to javafx.fxml;
    exports com.example.cloudcastcs151;
}