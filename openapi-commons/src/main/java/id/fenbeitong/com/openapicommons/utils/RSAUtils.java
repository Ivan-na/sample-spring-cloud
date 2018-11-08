package id.fenbeitong.com.openapicommons.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;


/**
 * RSAUtils
 * <p>RSA Generate, Encrypt, Decrypt
 *
 * @author Created by ivan on 上午11:50 18-11-8.
 * @version 1.0
 **/
public class RSAUtils {
    //
    private static final Logger LOGGER = LogUtils.get(RSAUtils.class);
    private static final String RSAEXCEPTION = "RSA Exception";

    private RSAUtils() {
    }

    /**
     * 生成公钥和私钥.
     *
     * @return Map 公钥和私钥
     */
    public static Map<String, Object> getKeys() {
        Map<String, Object> map = new HashMap<>();
        KeyPairGenerator keyPairGen;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(1024);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            map.put("public", publicKey);
            map.put("private", privateKey);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info(RSAEXCEPTION, e);
        }
        return map;
    }

    /**
     * 使用模和指数生成RSA公钥.
     *
     * @param modulus  模
     * @param exponent 指数
     * @return RSAPublicKey 公钥
     */
    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
        RSAPublicKey rSAPublicKey = null;
        BigInteger b1 = new BigInteger(modulus);
        BigInteger b2 = new BigInteger(exponent);
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("RSA");

            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            rSAPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            LOGGER.info(RSAEXCEPTION, e);
        }
        return rSAPublicKey;
    }

    /**
     * 使用模和指数生成RSA私钥.
     *
     * @param modulus  模
     * @param exponent 指数
     * @return RSAPrivateKey 私钥
     */
    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
        RSAPrivateKey rSAPrivateKey = null;
        BigInteger b1 = new BigInteger(modulus);
        BigInteger b2 = new BigInteger(exponent);
        KeyFactory keyFactory;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            rSAPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (GeneralSecurityException e) {
            LOGGER.info(RSAEXCEPTION, e);
        }
        return rSAPrivateKey;
    }

    /**
     * 公钥加密.
     *
     * @param data      需要加密的数据
     * @param publicKey 公钥
     * @return String 加密后字符串
     */
    public static String encryptByPublicKey(String data, RSAPublicKey publicKey) {
        StringBuilder mi = new StringBuilder();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            // 模长
            int keyLen = publicKey.getModulus().bitLength() / 8;
            // 加密数据长度 <= 模长-11
            String[] datas = splitString(data, keyLen - 11);

            // 如果明文长度大于模长-11则要分组加密
            for (String s : datas) {
                mi.append(bcd2Str(cipher.doFinal(s.getBytes())));
            }
        } catch (GeneralSecurityException e) {
            LOGGER.info(RSAEXCEPTION, e);
        }
        return mi.toString();
    }

    /**
     * 私钥解密.
     *
     * @param data       用公钥加密的字符串
     * @param privateKey 私钥
     * @return String 解密后的字符串
     */
    public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey) {
        // 如果密文长度大于模长则要分组解密
        StringBuilder ming = new StringBuilder();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            // 模长
            int keyLen = privateKey.getModulus().bitLength() / 8;
            byte[] bytes = data.getBytes();
            byte[] bcd = asc2bcd(bytes, bytes.length);

            byte[][] arrays = splitArray(bcd, keyLen);
            for (byte[] arr : arrays) {
                ming.append(new String(cipher.doFinal(arr)));
            }
        } catch (GeneralSecurityException e) {
            LOGGER.info(RSAEXCEPTION, e);
        }
        return ming.toString();
    }

    /**
     * JS私钥解密 -- 结果到序.
     *
     * @param data       用公钥加密的字符串，由JS传入
     * @param privateKey 解密用私钥
     * @return String 解密后字符串
     */
    public static String decryptByPrivateKeyJS(String data, RSAPrivateKey privateKey) {
        return StringUtils.reverse(decryptByPrivateKey(data, privateKey));
    }

    /**
     * ASCII码转BCD码.
     *
     * @param ascii  ASCII码
     * @param ascLen 长度
     * @return byte[] BCD字节数组
     */
    private static byte[] asc2bcd(byte[] ascii, int ascLen) {
        byte[] bcd = new byte[ascLen / 2];
        int j = 0;
        for (int i = 0; i < (ascLen + 1) / 2; i++) {
            bcd[i] = asc2bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= ascLen) ? 0x00 : asc2bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    /**
     * 单字节ASCII码转BCD码.
     *
     * @param asc ASCII码
     * @return byte 单字节BCD
     */
    private static byte asc2bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9')) {
            bcd = (byte) (asc - '0');
        } else if ((asc >= 'A') && (asc <= 'F')) {
            bcd = (byte) (asc - 'A' + 10);
        } else if ((asc >= 'a') && (asc <= 'f')) {
            bcd = (byte) (asc - 'a' + 10);
        } else {
            bcd = (byte) (asc - 48);
        }
        return bcd;
    }

    /**
     * BCD转字符串.
     *
     * @param bytes BCD字节数组
     * @return String 结果字符串
     */
    private static String bcd2Str(byte[] bytes) {
        char[] temp = new char[bytes.length * 2];
        char val;

        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串.
     *
     * @param string 需要拆分字符串
     * @param len    拆分长度
     * @return String[] 字符串数组
     */
    private static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str;
        for (int i = 0; i < x + z; i++) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 拆分字节数组.
     *
     * @param data 字节数组
     * @param len  拆分长度
     * @return byte[][] 二维字节数组
     */
    private static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    public static void main(String[] args) {
        Map<String, Object> map = RSAUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        //模
        String modulus = publicKey.getModulus().toString();
        System.err.println("modulus:" + modulus);
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        System.err.println("public_exponent:" + public_exponent);
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        System.err.println("private_exponent:" + private_exponent);
        //明文
        String ming = "123456789";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        //加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println("密文：" + mi);
        //解密后的明文
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println(ming);
    }
}