package com.autointerview.service.impl;

import com.autointerview.domain.entity.Interview;
import com.autointerview.domain.entity.QuestionBank;
import com.autointerview.domain.entity.User;
import com.autointerview.domain.enums.InterviewStatus;
import com.autointerview.dto.interview.InterviewRequest;
import com.autointerview.repository.InterviewRepository;
import com.autointerview.repository.QuestionBankRepository;
import com.autointerview.repository.UserRepository;
import com.autointerview.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService {

    private final InterviewRepository interviewRepository;
    private final UserRepository userRepository;
    private final QuestionBankRepository questionBankRepository;

    @Override
    @Transactional
    public Interview scheduleInterview(InterviewRequest request, String recruiterEmail) {
        User candidate = userRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        User recruiter = userRepository.findByEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        QuestionBank questionBank = questionBankRepository.findById(request.getQuestionBankId())
                .orElseThrow(() -> new RuntimeException("Question bank not found"));

        Interview interview = Interview.builder()
                .candidate(candidate)
                .recruiter(recruiter)
                .questionBank(questionBank)
                .scheduledStartTime(request.getScheduledStartTime())
                .scheduledEndTime(request.getScheduledEndTime())
                .status(InterviewStatus.SCHEDULED)
                .isAutoInterview(request.isAutoInterview())
                .build();

        return interviewRepository.save(interview);
    }

    @Override
    @Transactional
    public Interview updateInterview(Long id, InterviewRequest request) {
        Interview interview = getInterview(id);

        User candidate = userRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        QuestionBank questionBank = questionBankRepository.findById(request.getQuestionBankId())
                .orElseThrow(() -> new RuntimeException("Question bank not found"));

        interview.setCandidate(candidate);
        interview.setQuestionBank(questionBank);
        interview.setScheduledStartTime(request.getScheduledStartTime());
        interview.setScheduledEndTime(request.getScheduledEndTime());
        interview.setAutoInterview(request.isAutoInterview());

        return interviewRepository.save(interview);
    }

    @Override
    @Transactional
    public void cancelInterview(Long id) {
        Interview interview = getInterview(id);
        interview.setStatus(InterviewStatus.CANCELLED);
        interviewRepository.save(interview);
    }

    @Override
    public Interview getInterview(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public List<Interview> getInterviewsByCandidate(Long candidateId) {
        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        return interviewRepository.findByCandidate(candidate);
    }

    @Override
    public List<Interview> getInterviewsByRecruiter(String recruiterEmail) {
        User recruiter = userRepository.findByEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        return interviewRepository.findByRecruiter(recruiter);
    }

    @Override
    public List<Interview> getInterviewsByStatus(InterviewStatus status) {
        return interviewRepository.findByStatus(status);
    }

    @Override
    public List<Interview> getInterviewsByDateRange(LocalDateTime start, LocalDateTime end) {
        return interviewRepository.findByScheduledStartTimeBetween(start, end);
    }

    @Override
    @Transactional
    public void startInterview(Long id) {
        Interview interview = getInterview(id);
        interview.setStatus(InterviewStatus.IN_PROGRESS);
        interview.setActualStartTime(LocalDateTime.now());
        interviewRepository.save(interview);
    }

    @Override
    @Transactional
    public void endInterview(Long id) {
        Interview interview = getInterview(id);
        interview.setStatus(InterviewStatus.PENDING_REVIEW);
        interview.setActualEndTime(LocalDateTime.now());
        interviewRepository.save(interview);
    }

    @Override
    @Transactional
    public void submitFeedback(Long id, String feedback, Double score) {
        Interview interview = getInterview(id);
        interview.setFeedback(feedback);
        interview.setScore(score);
        interview.setStatus(InterviewStatus.COMPLETED);
        interviewRepository.save(interview);
    }
} 