package top.jsoft.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class SelfMath {
    public static String md5Custom(final String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (final NoSuchAlgorithmException e) {
            System.out.println("md5Custom: " + e);
        }

        final BigInteger bigInt = new BigInteger(1, digest);
        StringBuilder md5Hex = new StringBuilder(bigInt.toString(16));

        while (md5Hex.length() < 32) {
            md5Hex.insert(0, '0');
        }

        return md5Hex.toString();
    }
}
