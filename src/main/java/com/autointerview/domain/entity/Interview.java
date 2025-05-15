package com.autointerview.domain.entity;

import com.autointerview.domain.enums.InterviewStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private User candidate;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User recruiter;

    @ManyToOne
    @JoinColumn(name = "question_bank_id")
    private QuestionBank questionBank;

    private LocalDateTime scheduledStartTime;
    private LocalDateTime scheduledEndTime;
    private LocalDateTime actualStartTime;
    private LocalDateTime actualEndTime;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    private Double score;
    
    @Column(columnDefinition = "TEXT")
    private String feedback;

    @ElementCollection
    @CollectionTable(name = "interview_responses")
    private List<String> responses = new ArrayList<>();

    private String meetingUrl;
    private String recordingUrl;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private boolean isAutoInterview;
} 