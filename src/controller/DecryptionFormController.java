package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

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
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please input a valid Key", ButtonType.OK).show();
            return;
        }
        String text = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int code = cipherText.charAt(i);
            if(i%3==0){code -= 69;}
            else if(i%3==1){code -= 194;}
            else{code -= 227;}
            char textChar = (char) code;
            text += textChar;
        }
        text = text.substring(0,text.length()-key.length()-8); // length of "cinnamon" = 8
        txtText.setText(text);
    }
}
