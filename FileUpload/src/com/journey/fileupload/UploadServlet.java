package com.journey.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.得到 FileItem 的集合
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("E:\\mobile\\FileUpload\\WebRoot\\tempDirectory\\");
		factory.setRepository(tempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1024 * 1024);

		// Parse the request
		try {
			List<FileItem> /* FileItem */ items = upload.parseRequest(request);
			//2.遍历 items
			for(FileItem item: items){
				//若是一个一般的表单域, 打印信息
				if (item.isFormField()) {
			        String name = item.getFieldName();
			        String value = item.getString();
			        System.out.println(name + ":" + value);
			    } else {
			    	String fieldName = item.getFieldName();
			        String fileName = item.getName();
			        String contentType = item.getContentType();
			        long sizeInBytes = item.getSize();
			        
			        System.out.println(fieldName);
			        System.out.println(fileName);
			        System.out.println(contentType);
			        System.out.println(sizeInBytes);
			        
			        InputStream in = item.getInputStream();
			        byte[] buffer = new byte[1024];
			        
			        int len = 0;
			        fileName = "E:\\mobile\\FileUpload\\WebRoot\\files\\" + fileName;
			        
			        System.out.println(fileName);
			        OutputStream out = new FileOutputStream(fileName);
			        
			        while((len = in.read(buffer))!=-1){
			        	out.write(buffer, 0, len);
			        }
			        out.close();
			        in.close();
			    }
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		// 若是文件域则把文件保存到d:\\files 目录下.
		

		/*InputStream in = request.getInputStream();
		Reader reader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String str = null;
		
		while((str = bufferedReader.readLine())!=null){
			System.out.println(str);
		}*/
		
		
		
		//1.获取请求信息
		/*String file = request.getParameter("file");
		String desc = request.getParameter("desc");
		
		System.out.println(file);
		System.out.println(desc);*/
				
	}

}
