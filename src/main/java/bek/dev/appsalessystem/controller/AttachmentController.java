package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.serviceImpl.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentServiceImpl attechmentServiceImpl;


    /**
     * upload file
     * @param request
     * @return String
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public HttpEntity<String> uploadFile(MultipartHttpServletRequest request) throws IOException {
        return attechmentServiceImpl.uploadAttachment(request);

    }


    /**
     * download file by id
     * @param id
     * @param response
     * @throws IOException
     */
    @GetMapping( "/download/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attechmentServiceImpl.downloadAttachment(id, response);
    }

}
