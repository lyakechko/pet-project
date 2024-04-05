package com.example.petproject;

import com.example.petproject.repositories.StudentRepository;
import com.example.petproject.repositories.redis.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@SpringBootTest
@WebAppConfiguration
class PetProjectApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Сохранение сущности в кэш и ее удаление")
    public void testSaveToCache() {

        Student student = Student.builder()
                .gender(Student.Gender.FEMALE)
                .id("1")
                .name("Test")
                .build();
        studentRepository.save(student);

        Optional<Student> studentCache = studentRepository.findById("1");
        Assertions.assertNotNull(studentCache.orElse(null));

        Assertions.assertEquals(studentCache.get().getId(), studentCache.get().getId());
        Assertions.assertEquals(studentCache.get().getName(), studentCache.get().getName());

        studentRepository.deleteById("1");
        Student studentAfterDelete = studentRepository.findById("1").orElse(null);
        Assertions.assertNull(studentAfterDelete);
    }
}
