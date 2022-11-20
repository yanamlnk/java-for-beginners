package encryptdecrypt;

class Shift extends Cypher {

    private String lowerAlpha = "abcdefghijklmnopqrstuvwxyz";
    private String upperAlpha = lowerAlpha.toUpperCase();

    @Override
    public String encrypt(String text, int key) {
        String cipherText = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isLowerCase(text.charAt(i))) {
                    int charPosition = lowerAlpha.indexOf(text.charAt(i));
                    int keyVal = (charPosition + key) % 26;
                    cipherText += lowerAlpha.charAt(keyVal);
                } else {
                    int charPosition = upperAlpha.indexOf(text.charAt(i));
                    int keyVal = (key + charPosition) % 26;
                    cipherText += upperAlpha.charAt(keyVal);
                }
            } else {
                cipherText += text.charAt(i);
            }
        }
        return cipherText;
    }

    @Override
    public String decrypt(String text, int key) {
        String cipherText = "";
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isLowerCase(text.charAt(i))) {
                    int charPosition = lowerAlpha.indexOf(text.charAt(i));
                    int keyVal = (charPosition - key) % 26;
                    if (keyVal < 0) {
                        keyVal = lowerAlpha.length() + keyVal;
                    }
                    cipherText += lowerAlpha.charAt(keyVal);
                } else {
                    int charPosition = upperAlpha.indexOf(text.charAt(i));
                    int keyVal = (charPosition - key) % 26;
                    if (keyVal < 0) {
                        keyVal = upperAlpha.length() + keyVal;
                    }
                    cipherText += upperAlpha.charAt(keyVal);
                }
            } else {
                cipherText += text.charAt(i);
            }
        }
        return cipherText;
    }
}
