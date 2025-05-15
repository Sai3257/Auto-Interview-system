package com.autointerview.dto.question;

import com.autointerview.domain.enums.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Question type is required")
    private QuestionType type;

    private Integer difficultyLevel;

    private List<String> tags;

    // For MCQ questions
    private List<String> options;
    private String correctAnswer;

    // For coding questions
    private String sampleInput;
    private String sampleOutput;
    private String testCases;

    // For video/audio questions
    private String mediaUrl;
    private Integer durationSeconds;

    @NotNull(message = "Question bank ID is required")
    private Long questionBankId;
} 