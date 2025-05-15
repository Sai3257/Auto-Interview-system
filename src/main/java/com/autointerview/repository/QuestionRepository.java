package com.autointerview.repository;

import com.autointerview.domain.entity.Question;
import com.autointerview.domain.enums.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionBankIdAndType(Long questionBankId, QuestionType type);
    List<Question> findByQuestionBankIdAndActive(Long questionBankId, boolean active);
    List<Question> findByTagsContaining(String tag);
} 