package com.github.zxbu.webdavteambition.util;

import java.io.InputStream;
import java.security.MessageDigest;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class EncryptUtil {
    public static String createSha1(InputStream inputStream) throws Exception  {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        int n = 0;
        byte[] buffer = new byte[8192];
        while (n != -1) {
            n = inputStream.read(buffer);
            if (n > 0) {
                digest.update(buffer, 0, n);
            }
        }
        return new HexBinaryAdapter().marshal(digest.digest());
    }
}
