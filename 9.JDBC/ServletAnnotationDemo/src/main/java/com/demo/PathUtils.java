package com.demo;

import jakarta.servlet.http.Part;
import java.lang.reflect.Method;

public class PathUtils {
    // Fallback method to get submitted file name from Part (supports servlet implementations)
    public static String getSubmittedFileName(Part part) {
        try {
            // Use Part.getSubmittedFileName() if available
            Method m = part.getClass().getMethod("getSubmittedFileName");
            Object v = m.invoke(part);
            if (v != null) return v.toString();
        } catch (Exception ignored) {}
        // Fallback to header parsing
        String cd = part.getHeader("content-disposition");
        if (cd == null) return null;
        for (String seg : cd.split(";")) {
            seg = seg.trim();
            if (seg.startsWith("filename")) {
                String[] kv = seg.split("=", 2);
                if (kv.length == 2) {
                    String fname = kv[1].trim();
                    if (fname.startsWith("\"") && fname.endsWith("\"")) {
                        fname = fname.substring(1, fname.length()-1);
                    }
                    return fname;
                }
            }
        }
        return null;
    }
}
