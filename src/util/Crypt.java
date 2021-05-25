package util;

public class Crypt {
    public static String encrypt(String text,String key){
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
        return cipherText;
    }
    public static String decrypt(String cipherText,String key){
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
        return text;
    }
}
