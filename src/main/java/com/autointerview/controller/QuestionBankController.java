package com.autointerview.controller;

import com.autointerview.domain.entity.QuestionBank;
import com.autointerview.dto.questionbank.QuestionBankRequest;
import com.autointerview.service.QuestionBankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question-banks")
@RequiredArgsConstructor
public class QuestionBankController {

    private final QuestionBankService questionBankService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<QuestionBank> createQuestionBank(
            @RequestBody @Valid QuestionBankRequest request,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(questionBankService.createQuestionBank(request, userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<QuestionBank> updateQuestionBank(
            @PathVariable Long id,
            @RequestBody @Valid QuestionBankRequest request
    ) {
        return ResponseEntity.ok(questionBankService.updateQuestionBank(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> deleteQuestionBank(@PathVariable Long id) {
        questionBankService.deleteQuestionBank(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<QuestionBank> getQuestionBank(@PathVariable Long id) {
        return ResponseEntity.ok(questionBankService.getQuestionBank(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<QuestionBank>> getAllQuestionBanks() {
        return ResponseEntity.ok(questionBankService.getAllQuestionBanks());
    }

    @GetMapping("/my-banks")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<QuestionBank>> getMyQuestionBanks(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(questionBankService.getQuestionBanksByCreator(userDetails.getUsername()));
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<QuestionBank>> searchQuestionBanks(
            @RequestParam String query
    ) {
        return ResponseEntity.ok(questionBankService.searchQuestionBanks(query));
    }
} 