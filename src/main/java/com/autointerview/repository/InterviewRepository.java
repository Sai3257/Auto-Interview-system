package com.autointerview.repository;

import com.autointerview.domain.entity.Interview;
import com.autointerview.domain.entity.User;
import com.autointerview.domain.enums.InterviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByCandidate(User candidate);
    List<Interview> findByRecruiter(User recruiter);
    List<Interview> findByStatus(InterviewStatus status);
    List<Interview> findByScheduledStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Interview> findByCandidateAndStatus(User candidate, InterviewStatus status);
    List<Interview> findByRecruiterAndStatus(User recruiter, InterviewStatus status);
} 