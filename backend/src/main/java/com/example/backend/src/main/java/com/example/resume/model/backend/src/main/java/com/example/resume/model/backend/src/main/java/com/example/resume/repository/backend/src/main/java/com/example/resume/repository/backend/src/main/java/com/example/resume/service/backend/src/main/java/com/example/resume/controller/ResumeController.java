package com.example.resume.controller;

import com.example.resume.model.Resume;
import com.example.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin // allow frontend served from file:// or other origin
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/{userId}")
    public List<Resume> getResumes(@PathVariable Integer userId) {
        return resumeService.getResumes(userId);
    }

    @PostMapping("/{userId}")
    public Resume createResume(@PathVariable Integer userId, @RequestBody Resume resume) {
        return resumeService.createResume(userId, resume);
    }

    @GetMapping("/random")
    public Resume getRandomUserResume() {
        return resumeService.getRandomUserResume();
    }
}
