package com.example.democdtst.services;

import com.example.democdtst.entities.Student;
import com.example.democdtst.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student setUserIsWorkingStatus(Long id, boolean isWorking) {
        return studentRepository.findById(id).map(user -> {
            user.setWorking(isWorking);
            return studentRepository.save(user);
        }).orElse(null);
    }
}