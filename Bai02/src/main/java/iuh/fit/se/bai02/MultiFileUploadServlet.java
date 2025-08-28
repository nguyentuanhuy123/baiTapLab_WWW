package iuh.fit.se.bai02;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class MultiFileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/upload.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                part.write(uploadFilePath + File.separator + fileName);
            }
        }

        response.getWriter().println("Upload thành công!");
    }
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
                return new File(fileName).getName();
            }
        }
        return null;
    }
}
