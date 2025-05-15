package com.autointerview.repository;

import com.autointerview.domain.entity.QuestionBank;
import com.autointerview.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long> {
    List<QuestionBank> findByCreatedBy(User createdBy);
    List<QuestionBank> findByActive(boolean active);
    List<QuestionBank> findByNameContainingIgnoreCase(String name);
} 