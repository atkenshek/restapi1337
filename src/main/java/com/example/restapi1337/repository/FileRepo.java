package com.example.restapi1337.repository;

import com.example.restapi1337.entities.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileDb, Long> {
}
