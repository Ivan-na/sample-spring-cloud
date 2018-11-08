package id.fenbeitong.com.openapicommons.utils;

import id.fenbeitong.com.openapicommons.constants.ResponseCode;
import io.jsonwebtoken.*;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * JWTUtils
 * <p>JWT Utils, use for generate/check token etc.
 *
 * @author Created by ivan on 上午11:36 18-11-8.
 * @version 1.0
 **/
public class JWTUtils {
    //TODO should put somewhere safe or move to service
    private static String modulus = "98746252924509645725181626243911270993601150278364030221374385123191199962925789462981267533027743595112234757646377587420280007465625595493652287787723256596790746125566548102736894604926297884372768163201775383592720436560680120724258290996870434958385247924268253693544381430561969733896268420053357233847";
    private static String public_exponent = "65537";
    private static String private_exponent = "44537291761838055113762358517231079532170474710135684717237674136082040369625149316207078246010148052671354306746864749783420918575406670692843248466016313407438909266998089918028652814633796446255269179167407748792492169030483606592708186939277625839955679262524913330353239273238644821191427525269586880953";
    /**
     * Use RSA for JWT sign
     */
    private static RSAPrivateKey priKey;
    private static RSAPublicKey pubKey;

    /**
     * @param modulus         :
     * @param privateExponent :
     * @param publicExponent  :
     * @return id.fenbeitong.com.openapicommons.utils.JWTUtils
     * @author Created by ivan on 上午11:44 18-11-8.
     * <p>get util Instance with RSA params
     **/
    public synchronized static JWTUtils getInstance(String modulus, String privateExponent, String publicExponent) {
        if (priKey == null && pubKey == null) {
            priKey = RSAUtils.getPrivateKey(modulus, privateExponent);
            pubKey = RSAUtils.getPublicKey(modulus, publicExponent);
        }
        return SingletonHolder.INSTANCE;
    }

    /**
     * @param modulus         :
     * @param privateExponent :
     * @param publicExponent  :
     * @author Created by ivan on 上午11:45 18-11-8.
     * <p>reload util keys if need
     **/
    public synchronized static void reload(String modulus, String privateExponent, String publicExponent) {
        priKey = RSAUtils.getPrivateKey(modulus, privateExponent);
        pubKey = RSAUtils.getPublicKey(modulus, publicExponent);
    }

    /**
     * @return id.fenbeitong.com.openapicommons.utils.JWTUtils
     * @author Created by ivan on 上午11:45 18-11-8.
     * <p>get util Instance by default
     **/
    public synchronized static JWTUtils getInstance() {
        if (priKey == null && pubKey == null) {
            priKey = RSAUtils.getPrivateKey(JWTUtils.modulus, JWTUtils.private_exponent);
            pubKey = RSAUtils.getPublicKey(JWTUtils.modulus, JWTUtils.public_exponent);
        }
        return SingletonHolder.INSTANCE;
    }

    /**
     * @param uid : user input like userId
     * @param exp : expired time in mins
     * @return java.lang.String
     * @author Created by ivan on 上午11:46 18-11-8.
     * <p>get Token with self-set expired time
     **/
    public String getToken(String uid, int exp) {
        long expiredTime = System.currentTimeMillis() + 1000 * 60 * exp;
        return Jwts.builder().setSubject(uid).setExpiration(new Date(expiredTime))
                .signWith(SignatureAlgorithm.RS512, priKey).compact();
    }

    /**
     * @param uid : user input like userId
     * @return java.lang.String
     * @author Created by ivan on 上午11:46 18-11-8.
     * <p>get a day Token
     **/
    public String getToken(String uid) {
        long expiredTime = System.currentTimeMillis() + 1000 * 60 * 1440;
        return Jwts.builder().setSubject(uid).setExpiration(new Date(expiredTime))
                .signWith(SignatureAlgorithm.RS512, priKey).compact();
    }

    /**
     * @param token :
     * @return id.fenbeitong.com.openapicommons.utils.JWTUtils.JWTResult
     * @author Created by ivan on 上午11:47 18-11-8.
     * <p>check Token
     **/
    public JWTResult checkToken(String token) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(pubKey).parseClaimsJws(token).getBody();
            String sub = claims.get("sub", String.class);
            return new JWTResult(true, sub, "valid", ResponseCode.SUCCESS_CODE.getCode());
        } catch (ExpiredJwtException e) {
            return new JWTResult(false, null, "expired", ResponseCode.TOKEN_TIMEOUT_CODE.getCode());
        } catch (SignatureException e) {
            return new JWTResult(false, null, "invalid", ResponseCode.NO_AUTH_CODE.getCode());
        }
    }

    /**
     * @author Created by ivan on 上午11:47 18-11-8.
     * <p> singleton holder
     **/
    private static class SingletonHolder {
        private static final JWTUtils INSTANCE = new JWTUtils();
    }

    /**
     * JWTUtils
     * <p>JWT return Object
     *
     * @author Created by ivan on 上午11:48 18-11-8.
     * @version 1.0
     **/
    static class JWTResult {
        // true/false
        private boolean status;
        // user input
        private String uid;
        // string message
        private String msg;
        // code message
        private int code;

        // Constructor
        private JWTResult() {
        }

        JWTResult(boolean status, String uid, String msg, int code) {
            super();
            this.status = status;
            this.uid = uid;
            this.msg = msg;
            this.code = code;
        }

        // Getter/Setter
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
