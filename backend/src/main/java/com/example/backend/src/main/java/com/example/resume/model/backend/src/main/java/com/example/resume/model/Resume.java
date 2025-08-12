package com.example.resume.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resumeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String resumeTitle;p

    @Lob
    private String resumeData;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters
    public Integer getResumeId() { return resumeId; }
    public void setResumeId(Integer resumeId) { this.resumeId = resumeId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getResumeTitle() { return resumeTitle; }
    public void setResumeTitle(String resumeTitle) { this.resumeTitle = resumeTitle; }

    public String getResumeData() { return resumeData; }
    public void setResumeData(String resumeData) { this.resumeData = resumeData; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
