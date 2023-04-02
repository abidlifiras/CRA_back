package com.example.cra.repository;
import com.example.cra.model.CraServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CraServerRepository extends JpaRepository<CraServer, Long> {
}
