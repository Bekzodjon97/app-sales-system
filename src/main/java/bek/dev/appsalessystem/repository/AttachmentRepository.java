package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
