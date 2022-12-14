package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.UsedJWSTokens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedJWSTokensRepository extends JpaRepository<UsedJWSTokens, Long> {
    UsedJWSTokens findByfullToken(String fullToken);
}
