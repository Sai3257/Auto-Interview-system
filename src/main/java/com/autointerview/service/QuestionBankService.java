package com.autointerview.service;

import com.autointerview.domain.entity.QuestionBank;
import com.autointerview.dto.questionbank.QuestionBankRequest;

import java.util.List;

public interface QuestionBankService {
    QuestionBank createQuestionBank(QuestionBankRequest request, String creatorEmail);
    QuestionBank updateQuestionBank(Long id, QuestionBankRequest request);
    void deleteQuestionBank(Long id);
    QuestionBank getQuestionBank(Long id);
    List<QuestionBank> getAllQuestionBanks();
    List<QuestionBank> getQuestionBanksByCreator(String creatorEmail);
    List<QuestionBank> searchQuestionBanks(String query);
} 