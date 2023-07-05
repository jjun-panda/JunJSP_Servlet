package jsp_12;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>> doPost():void - FileUploadServlet");
		File file;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		HttpServlet pageContext = this;
		PrintWriter out = resp.getWriter();
		
		ServletContext context = pageContext.getServletContext();
		//String filePath = context.getInitParameter("file-upload");
		String filePath = "/Users/jjun/Dev/SIAT/Jsp_Servlet/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";
		System.out.println(filePath);

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File(filePath));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);

			try {

				// Parse the request to get file items.
				List fileItems = upload.parseRequest(request);

				// Process the uploaded file items
				Iterator i = fileItems.iterator();

				out.println("<html>");
				out.println("<head>");
				out.println("<title>JSP File upload</title>");
				out.println("</head>");
				out.println("<body>");

				while (i.hasNext()) {

			FileItem fi = (FileItem) i.next();
			if (!fi.isFormField()) {
				// Get the uploaded file parameters
				String fieldName = fi.getFieldName();
				String fileName = fi.getName();
				boolean isInMemory = fi.isInMemory();
				long sizeInBytes = fi.getSize();

				// Write the file
				if (fileName.lastIndexOf("\\") >= 0) {
					file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
				} else {
					file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
				}
				fi.write(file);
				out.println("Uploaded Filename: " + filePath + fileName + "<br>");
				System.out.println(">>> file upload.jsp");
			}
				}
				out.println("</body>");
				out.println("</html>");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
