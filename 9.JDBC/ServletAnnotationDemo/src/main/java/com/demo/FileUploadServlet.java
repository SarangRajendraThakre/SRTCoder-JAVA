package com.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Part filePart = req.getPart("file");
        if (filePart == null) {
            res.getWriter().println("No file part in the request.");
            return;
        }
        String fileName = PathUtils.getSubmittedFileName(filePart);
        if (fileName == null || fileName.isEmpty()) {
            res.getWriter().println("Invalid file name.");
            return;
        }

        // Save to webapp/upload directory
        String uploadDirPath = getServletContext().getRealPath("/upload");
        if (uploadDirPath == null) uploadDirPath = System.getProperty("java.io.tmpdir") + File.separator + "upload";
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        File outFile = new File(uploadDir, fileName);
        try (InputStream in = filePart.getInputStream();
             FileOutputStream fos = new FileOutputStream(outFile)) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }

        res.setContentType("text/html;charset=UTF-8");
        res.getWriter().println("File uploaded to: " + outFile.getAbsolutePath());
    }
}
