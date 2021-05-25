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

        /**
         * Returns the decrypted String text corresponding with the String cipherText and the String key given.
         * Decrypting algorithm as follows--->
         * Integer code of char at index of String ciphertext undergoes following changes in a for loop...
         *          * if (index % 3 == 0), code equals to (code - 69)
         *          * if (index % 3 == 1), code equals to (code - 194)
         *          * else code equals to (code - 227)
         * Corresponding to index, char values of codes assigned to textChar, String text is formulated accordingly
         * String text becomes the subString from the index=0 to index = (length of text - length of key - length of "cinnamon")
         * returns new String text
         */
        txtText.setText(Crypt.decrypt(cipherText,key));
    }
}
