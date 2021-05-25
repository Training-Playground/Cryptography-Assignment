package controller;

import ijse.dep7.CryptingAlgorithm;
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
            txtText.requestFocus();
            return;
        }
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please input a valid Key", ButtonType.OK).show();
            txtKey.requestFocus();
            return;
        }
        /**
         * Returns the encrypted String cipherText corresponding with the String text and the String key given.
         * Encrypting algorithm as follows--->
         * String key concatenated at the end with String "cinnamon".
         * String text concatenated with the new String key.
         * Integer code of char at index of new String text undergoes following changes in a for loop...
         * if (index % 3 == 0), code equals to (code + 69)
         * if (index % 3 == 1), code equals to (code + 194)
         * else code equals to (code + 227)
         * Corresponding to index, char values of codes assigned to cipherChar, cipherText is formulated accordingly
         * returns new String cipherText
         */
        txtCipherText.setText(CryptingAlgorithm.encrypt(text,key));
    }
}
