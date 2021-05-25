package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class EncryptionFormController {
    public TextField txtText;
    public TextField txtKey;
    public TextField txtCipherText;

    public void btnEncrypt_OnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();

        if(text.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please input a valid Text", ButtonType.OK).show();
            return;
        }
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please input a valid Key", ButtonType.OK).show();
            return;
        }
        key += "cinnamon";
        text += key;
        String cipherText = "";
        for (int i = 0; i < text.length(); i++) {
            int code = text.charAt(i);
            if(i%3==0){code += 69;}
            else if(i%3==1){code += 194;}
            else{code += 227;}
            char cipherChar = (char) code;
            cipherText += cipherChar;
        }
        txtCipherText.setText(cipherText);
    }
}
