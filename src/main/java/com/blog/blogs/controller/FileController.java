package com.blog.blogs.controller;

import com.blog.blogs.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

import static com.blog.blogs.utils.IOUtils.readInputStream;


@Controller
public class FileController {
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request){
        FileDTO fileDTO = new FileDTO();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String originalFilename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            byte[] data = readInputStream(inputStream);
            String[] split = originalFilename.split("\\.");
            String picname = split[0]+UUID.randomUUID().toString().substring(0,4);
            String type = split[1];
            String fileName=picname+"."+type;
            String pathname = "G:\\githubcode\\blog\\src\\main\\resources\\static\\images\\"+fileName;
            File newFile = new File(pathname);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            fileOutputStream.write(data);
            fileOutputStream.close();
            fileDTO.setUrl("/images/"+fileName);
            fileDTO.setSuccess(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileDTO;
    }
}
