package jai.framework.common;


import jai.framework.domain.MyEncryptBO;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MyEncryptor {


    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static boolean isInitialized = false;

    private static void initializeEncryption()
    {
        String myKey = "ThisIsSecretKey";

        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            isInitialized = true;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static MyEncryptBO encrypt(MyEncryptBO myEncryptBO)
    {
        try
        {
            if(!isInitialized){
                initializeEncryption();
            }
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            myEncryptBO.setEncryptedText(Base64.getEncoder().encodeToString(cipher.doFinal(myEncryptBO.getPlainText().getBytes(StandardCharsets.UTF_8))));
            return myEncryptBO;
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static MyEncryptBO decrypt(MyEncryptBO myEncryptBO)
    {
        try
        {
            if(!isInitialized){
                initializeEncryption();
            }
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            myEncryptBO.setPlainText(new String(cipher.doFinal(Base64.getDecoder().decode(myEncryptBO.getEncryptedText()))));
            return myEncryptBO;
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
