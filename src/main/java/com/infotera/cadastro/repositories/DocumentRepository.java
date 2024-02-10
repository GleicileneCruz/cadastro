package com.infotera.cadastro.repositories;

import com.infotera.cadastro.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository <Document, Integer> {
}
