package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
