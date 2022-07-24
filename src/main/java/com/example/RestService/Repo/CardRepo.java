package com.example.RestService.Repo;

import com.example.RestService.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
}
