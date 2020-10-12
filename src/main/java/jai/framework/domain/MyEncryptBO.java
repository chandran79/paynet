package jai.framework.domain;



public class MyEncryptBO {
    private String plainText;
    private String encryptedText;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    @Override
    public String toString() {
        return "MyEncryptBO{" +
                "plainText='" + plainText + '\'' +
                ", encryptedText='" + encryptedText + '\'' +
                '}';
    }
}
