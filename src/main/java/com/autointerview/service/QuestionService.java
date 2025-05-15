package com.autointerview.service;

import com.autointerview.domain.entity.Question;
import com.autointerview.domain.enums.QuestionType;
import com.autointerview.dto.question.QuestionRequest;

import java.util.List;

public interface QuestionService {
    Question createQuestion(QuestionRequest request);
    Question updateQuestion(Long id, QuestionRequest request);
    void deleteQuestion(Long id);
    Question getQuestion(Long id);
    List<Question> getAllQuestions();
    List<Question> getQuestionsByQuestionBank(Long questionBankId);
    List<Question> getQuestionsByType(Long questionBankId, QuestionType type);
    List<Question> searchQuestionsByTag(String tag);
} 