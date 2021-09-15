package bek.dev.appsalessystem.service;

import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AttachmentService {
    HttpEntity<String> uploadAttachment(MultipartHttpServletRequest request) throws IOException;


    void downloadAttachment(Integer id, HttpServletResponse response) throws IOException;
}
