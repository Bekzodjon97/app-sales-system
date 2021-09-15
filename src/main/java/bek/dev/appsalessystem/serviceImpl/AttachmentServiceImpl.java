package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.entity.Attachment;
import bek.dev.appsalessystem.entity.AttachmentContent;
import bek.dev.appsalessystem.payload.Result;
import bek.dev.appsalessystem.repository.AttachmentContentRepository;
import bek.dev.appsalessystem.repository.AttachmentRepository;
import bek.dev.appsalessystem.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @Override
    public HttpEntity<String> uploadAttachment(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file!=null){
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attachment attachment=new Attachment();
            attachment.setSize(size);
            attachment.setContentType(contentType);
            attachment.setFileOriginalName(originalFilename);
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent=new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);
            return ResponseEntity.status(200).body("File saved");


        }
        return ResponseEntity.status(409).body("Error");
    }



    @Override
    public void downloadAttachment(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();

            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();
                response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getFileOriginalName() + "\"");
                response.setContentType(attachment.getContentType());


                FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
            }
        }
    }
}
