package com.autointerview.controller;

import com.autointerview.domain.entity.Interview;
import com.autointerview.domain.enums.InterviewStatus;
import com.autointerview.dto.interview.InterviewRequest;
import com.autointerview.service.InterviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/interviews")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Interview> scheduleInterview(
            @RequestBody @Valid InterviewRequest request,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(interviewService.scheduleInterview(request, userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Interview> updateInterview(
            @PathVariable Long id,
            @RequestBody @Valid InterviewRequest request
    ) {
        return ResponseEntity.ok(interviewService.updateInterview(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> cancelInterview(@PathVariable Long id) {
        interviewService.cancelInterview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Interview> getInterview(@PathVariable Long id) {
        return ResponseEntity.ok(interviewService.getInterview(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Interview>> getAllInterviews() {
        return ResponseEntity.ok(interviewService.getAllInterviews());
    }

    @GetMapping("/candidate/{candidateId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Interview>> getInterviewsByCandidate(
            @PathVariable Long candidateId
    ) {
        return ResponseEntity.ok(interviewService.getInterviewsByCandidate(candidateId));
    }

    @GetMapping("/my-interviews")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Interview>> getMyInterviews(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(interviewService.getInterviewsByRecruiter(userDetails.getUsername()));
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Interview>> getInterviewsByStatus(
            @PathVariable InterviewStatus status
    ) {
        return ResponseEntity.ok(interviewService.getInterviewsByStatus(status));
    }

    @GetMapping("/date-range")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<List<Interview>> getInterviewsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        return ResponseEntity.ok(interviewService.getInterviewsByDateRange(start, end));
    }

    @PostMapping("/{id}/start")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> startInterview(@PathVariable Long id) {
        interviewService.startInterview(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/end")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> endInterview(@PathVariable Long id) {
        interviewService.endInterview(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/feedback")
    @PreAuthorize("hasRole('ADMIN') or hasRole('RECRUITER')")
    public ResponseEntity<Void> submitFeedback(
            @PathVariable Long id,
            @RequestParam String feedback,
            @RequestParam Double score
    ) {
        interviewService.submitFeedback(id, feedback, score);
        return ResponseEntity.ok().build();
    }
} 