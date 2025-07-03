package com.example.stokyonetim.repository;

import com.example.stokyonetim.model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {
} 