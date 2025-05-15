package com.autointerview.controller;

import com.autointerview.domain.entity.Question;
import com.autointerview.domain.enums.QuestionType;
import com.autointerview.dto.question.QuestionRequest;
import com.autointerview.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Question> createQuestion(
            @RequestBody @Valid QuestionRequest request
    ) {
        return ResponseEntity.ok(questionService.createQuestion(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long id,
            @RequestBody @Valid QuestionRequest request
    ) {
        return ResponseEntity.ok(questionService.updateQuestion(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/bank/{questionBankId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Question>> getQuestionsByQuestionBank(
            @PathVariable Long questionBankId
    ) {
        return ResponseEntity.ok(questionService.getQuestionsByQuestionBank(questionBankId));
    }

    @GetMapping("/bank/{questionBankId}/type/{type}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Question>> getQuestionsByType(
            @PathVariable Long questionBankId,
            @PathVariable QuestionType type
    ) {
        return ResponseEntity.ok(questionService.getQuestionsByType(questionBankId, type));
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Question>> searchQuestionsByTag(
            @RequestParam String tag
    ) {
        return ResponseEntity.ok(questionService.searchQuestionsByTag(tag));
    }
} 