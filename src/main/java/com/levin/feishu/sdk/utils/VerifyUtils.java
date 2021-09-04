package com.levin.feishu.sdk.utils;

import com.google.gson.Gson;
import com.levin.feishu.sdk.event.VerifyEvent;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class VerifyUtils {

    /**
     * 飞书验签
     *
     * @param timestamp
     * @param nonce
     * @param encryptKey
     * @param bodyString
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String checkSignature(String timestamp, String nonce, String encryptKey, String bodyString) throws NoSuchAlgorithmException {
        StringBuilder content = new StringBuilder();
        content.append(timestamp).append(nonce).append(encryptKey).append(bodyString);
        MessageDigest alg = MessageDigest.getInstance("SHA-256");
        String sign = Hex.encodeHexString(alg.digest(content.toString().getBytes()));
        return sign;
    }

    /**
     * @param encryptKey
     * @param verifyEvent
     * @return
     */
    @SneakyThrows
    public static VerifyEvent firstVerify(String encryptKey, VerifyEvent verifyEvent) {

        if (StringUtils.hasText(verifyEvent.getEncrypt())) {

            String data = decrypt(encryptKey, verifyEvent.getEncrypt());

            verifyEvent = new Gson().fromJson(data, VerifyEvent.class);

        }

        return verifyEvent;
    }

    public static byte[] mdBysha256(String keyStr) {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // won't happen
        }

        return digest.digest(keyStr.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * @param key
     * @param encryptData
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String decrypt(String key, String encryptData) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {
        return decrypt(mdBysha256(key), encryptData);
    }

    /**
     * 飞书解密
     *
     * @param key
     * @param encryptData
     * @return
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String decrypt(byte[] key, String encryptData) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {

        byte[] decode = Base64.getDecoder().decode(encryptData);

        Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");

        byte[] iv = new byte[16];
        System.arraycopy(decode, 0, iv, 0, 16);

        byte[] data = new byte[decode.length - 16];
        System.arraycopy(decode, 16, data, 0, data.length);

        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));

        byte[] r = cipher.doFinal(data);
        if (r.length > 0) {
            int p = r.length - 1;
            for (; p >= 0 && r[p] <= 16; p--) {
            }

            if (p != r.length - 1) {
                byte[] rr = new byte[p + 1];
                System.arraycopy(r, 0, rr, 0, p + 1);
                r = rr;
            }
        }

        return new String(r, StandardCharsets.UTF_8);
    }
}
