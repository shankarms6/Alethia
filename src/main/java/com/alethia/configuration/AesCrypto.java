package com.alethia.configuration;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class AesCrypto {

	private static final String algorithm = "AES/CBC/NoPadding";
    private static final String algoUsed = "AES";

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public String encrypt(String data, String keyValue, String ivValue)
            throws Exception {
        data = padString(data);
        IvParameterSpec ivspec = new IvParameterSpec(ivValue.getBytes());
        SecretKeySpec keyspec = new SecretKeySpec(keyValue.getBytes(), algoUsed);

        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
        byte[] encVal = c.doFinal(data.getBytes());
        byte[] encodedBytes = Base64.encodeBase64(encVal);

        String encryptedValue = new String(encodedBytes);
        return encryptedValue;
    }

    public String decrypt(String encryptedData, String keyValue, String ivValue)
            throws Exception {
        IvParameterSpec ivspec = new IvParameterSpec(ivValue.getBytes());
        SecretKeySpec keyspec = new SecretKeySpec(keyValue.getBytes(), algoUsed);

        Cipher c = Cipher.getInstance(algorithm);
        c.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

        byte[] decordedValue = Base64.decodeBase64(encryptedData.getBytes());
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue.trim();
    }

    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private String padString(String source) {
        char paddingChar = ' ';
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }
        return source;
    }
}
