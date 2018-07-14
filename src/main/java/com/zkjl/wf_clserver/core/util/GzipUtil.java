package com.zkjl.wf_clserver.core.util;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class GzipUtil {
    
    public static String Compress(String str) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gos = new GZIPOutputStream(os);
            gos.write(str.getBytes());
            gos.close();
            byte[] compressed = os.toByteArray();
            os.close();

            String result = Base64.encodeBase64String(compressed);
            return result;
        } catch (Exception ex) {
        }
        return "";
    }

    public static String Decompress(String str) {
        try {
            byte[] compressed = Base64.decodeBase64(str);
            final int BUFFER_SIZE = 32;
            ByteArrayInputStream inputStream = new ByteArrayInputStream(compressed);
            GZIPInputStream gis = new GZIPInputStream(inputStream, BUFFER_SIZE);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] data = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = gis.read(data)) != -1) {
                baos.write(data, 0, bytesRead);
            }
            return baos.toString("UTF-8");
        } catch (Exception ex) {
        }
        return "";
    }
   
}