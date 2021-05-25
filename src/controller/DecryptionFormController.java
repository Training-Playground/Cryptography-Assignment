package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import util.Crypt;

public class DecryptionFormController {
    public TextField txtCipherText;
    public TextField txtKey;
    public TextField txtText;

    public void btnDecrypt_OnAction(ActionEvent actionEvent) {
        String cipherText = txtCipherText.getText();
        String key = txtKey.getText();

        if(cipherText.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please input a valid Cipher Text", ButtonType.OK).show();
            return;
        }
        if(key.trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please input a valid Key", ButtonType.OK).show();
            return;
        }
        txtText.setText(Crypt.decrypt(cipherText,key));
    }
}
