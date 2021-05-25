package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane main;

    public void btnOpenEncryptionForm_OnAction(ActionEvent actionEvent) throws IOException {
        setUI("/view/EncryptionForm.fxml","Encryption");
    }

    public void btnOpenDecryptionForm_OnAction(ActionEvent actionEvent) throws IOException {
        setUI("/view/DecryptionForm.fxml","Decryption");
    }

    public void setUI(String location,String title) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource(location));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initOwner(this.main.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();

    }


}
