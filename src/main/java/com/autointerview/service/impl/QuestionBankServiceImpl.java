package com.autointerview.service.impl;

import com.autointerview.domain.entity.QuestionBank;
import com.autointerview.domain.entity.User;
import com.autointerview.dto.questionbank.QuestionBankRequest;
import com.autointerview.repository.QuestionBankRepository;
import com.autointerview.repository.UserRepository;
import com.autointerview.service.QuestionBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionBankServiceImpl implements QuestionBankService {

    private final QuestionBankRepository questionBankRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public QuestionBank createQuestionBank(QuestionBankRequest request, String creatorEmail) {
        User creator = userRepository.findByEmail(creatorEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        QuestionBank questionBank = QuestionBank.builder()
                .name(request.getName())
                .description(request.getDescription())
                .createdBy(creator)
                .active(true)
                .build();

        return questionBankRepository.save(questionBank);
    }

    @Override
    @Transactional
    public QuestionBank updateQuestionBank(Long id, QuestionBankRequest request) {
        QuestionBank questionBank = getQuestionBank(id);
        questionBank.setName(request.getName());
        questionBank.setDescription(request.getDescription());
        return questionBankRepository.save(questionBank);
    }

    @Override
    @Transactional
    public void deleteQuestionBank(Long id) {
        QuestionBank questionBank = getQuestionBank(id);
        questionBank.setActive(false);
        questionBankRepository.save(questionBank);
    }

    @Override
    public QuestionBank getQuestionBank(Long id) {
        return questionBankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question bank not found"));
    }

    @Override
    public List<QuestionBank> getAllQuestionBanks() {
        return questionBankRepository.findByActive(true);
    }

    @Override
    public List<QuestionBank> getQuestionBanksByCreator(String creatorEmail) {
        User creator = userRepository.findByEmail(creatorEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return questionBankRepository.findByCreatedBy(creator);
    }

    @Override
    public List<QuestionBank> searchQuestionBanks(String query) {
        return questionBankRepository.findByNameContainingIgnoreCase(query);
    }
} 