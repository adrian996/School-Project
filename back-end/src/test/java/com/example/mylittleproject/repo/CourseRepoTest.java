package com.example.mylittleproject.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.mylittleproject.model.Course;

@DataJpaTest
@ActiveProfiles("test")
public class CourseRepoTest {

    @Autowired
    CourseRepo courseRepoTest;

    @AfterEach
    private void tearDown(){
        courseRepoTest.deleteAll();
    }

    @Test
    public void shouldGetAllCourses() {

        List<Course> courses = courseRepoTest.findAll();

        assertEquals(2, courses.size());
        assertEquals("Physics", courses.get(0).getName());
    }

    @Test
    public void shouldGetCourseByName() {

        List<Course> courses = courseRepoTest.findByNameContaining("Physics");

        assertNotNull(courses);
        assertEquals(1, courses.size());
        assertEquals("Physics", courses.get(0).getName());
    }

}
