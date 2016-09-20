package com.huawei.wuqf;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Servlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final long FILE_MAX_SIZE = 1024 * 1024 * 200;
    private static final String FILE_SAVE_PATH = "/home/wuqf/Documents";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("do get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        RequestContext req = new ServletRequestContext(request);

        if (FileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setHeaderEncoding("UTF-8");
            fileUpload.setFileSizeMax(FILE_MAX_SIZE);
            List<FileItem> items = new ArrayList<FileItem>();
            try {
                items = fileUpload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> it = items.iterator();
            while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName()
                            + " "
                            + fileItem.getName()
                            + " "
                            + new String(fileItem.getString().getBytes(
                            "ISO-8859-1"), "GBK"));
                } else {
                    System.out.println(fileItem.getFieldName() + " "
                            + fileItem.getName() + " " + fileItem.isInMemory()
                            + " " + fileItem.getContentType() + " "
                            + fileItem.getSize());
                    if (fileItem.getName() != null && fileItem.getSize() != 0) {
                        File fullFile = new File(fileItem.getName());
                        File newFile = new File(FILE_SAVE_PATH
                                + fullFile.getName());
                        try {
                            fileItem.write(newFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("no file choosen or empty file");
                    }
                }
            }
        }
        else{
            System.out.println("nothing found in body.");
        }
    }
}