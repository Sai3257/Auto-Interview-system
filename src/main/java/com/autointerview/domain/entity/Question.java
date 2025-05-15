package com.autointerview.domain.entity;

import com.autointerview.domain.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private Integer difficultyLevel;

    @ElementCollection
    private List<String> tags;

    // For MCQ questions
    @ElementCollection
    private List<String> options;

    private String correctAnswer;

    // For coding questions
    @Column(columnDefinition = "TEXT")
    private String sampleInput;

    @Column(columnDefinition = "TEXT")
    private String sampleOutput;

    @Column(columnDefinition = "TEXT")
    private String testCases;

    // For video/audio questions
    private String mediaUrl;
    private Integer durationSeconds;

    @ManyToOne
    @JoinColumn(name = "question_bank_id")
    private QuestionBank questionBank;

    private boolean active = true;
} 