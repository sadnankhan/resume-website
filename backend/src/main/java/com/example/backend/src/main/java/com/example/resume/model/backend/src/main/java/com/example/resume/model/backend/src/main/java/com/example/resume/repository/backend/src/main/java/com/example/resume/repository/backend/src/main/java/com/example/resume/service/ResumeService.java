package com.example.resume.service;

import com.example.resume.model.Resume;
import com.example.resume.model.User;
import com.example.resume.repository.ResumeRepository;
import com.example.resume.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final Random random = new Random();

    @Autowired
    public ResumeService(ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    public List<Resume> getResumes(Integer userId) {
        return resumeRepository.findByUserUserId(userId);
    }

    @Transactional
    public Resume createResume(Integer userId, Resume resume) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // create a new user skeleton using data attached to resume.user if present
            throw new RuntimeException("User not found: " + userId);
        }
        if (user.getResumes().size() >= 5) {
            throw new RuntimeException("User cannot have more than 5 resumes.");
        }
        resume.setUser(user);
        return resumeRepository.save(resume);
    }

    public Resume getRandomUserResume() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) return null;
        User ru = users.get(random.nextInt(users.size()));
        List<Resume> resumes = ru.getResumes();
        if (resumes.isEmpty()) return null;
        return resumes.get(random.nextInt(resumes.size()));
    }
}
