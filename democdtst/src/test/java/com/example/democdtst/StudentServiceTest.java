package com.example.democdtst;

import com.example.democdtst.entities.Student;
import com.example.democdtst.repositories.StudentRepository;
import com.example.democdtst.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@ActiveProfiles(value = "test")
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void setUserWorkingStatus() {
        Student student = new Student();
        student.setFirstName("nome");
        student.setLastName("cognome");
        student.setWorking(true);

        studentRepository.save(student);

        Student resultStudent = studentService.setUserIsWorkingStatus(student.getId(), false);

        assertThat(resultStudent).isNotNull();
        assertThat(resultStudent.getId()).isEqualTo(student.getId());
        assertThat(resultStudent.isWorking()).isFalse();
    }
}