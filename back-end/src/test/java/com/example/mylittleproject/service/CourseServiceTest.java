package com.example.mylittleproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.hamcrest.Matchers;

import com.example.mylittleproject.model.Course;
import com.example.mylittleproject.model.Student;
import com.example.mylittleproject.repo.CourseRepo;
import com.example.mylittleproject.repo.EventRepo;
import com.example.mylittleproject.repo.StudentRepo;
import com.example.mylittleproject.repo.TeacherRepo;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @InjectMocks
    CourseService courseService;
    @Mock
    CourseRepo courseRepo;
    @Mock
    TeacherRepo teacherRepo;
    @Mock
    StudentRepo studentRepo;
    @Mock
    EventRepo eventRepo;

    @BeforeEach
    void setUp(){
        courseService = new CourseService(courseRepo, studentRepo, teacherRepo, eventRepo);
    }

    @Test
    @MethodSource("mockCourseData")
    @DisplayName("Should get all courses")
    void shouldGetAllCourses() {
        when(courseRepo.findAll()).thenReturn(mockCourseData());

        List<Course> courses = courseService.getCourses(null);

        assertNotNull(courses);
        assertEquals(2, courses.size());
        verify(courseRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get course by name")
    void shouldGetCourseByName() {

        String courseName = "Maths";

        when(courseRepo.findByNameContaining(anyString())).thenReturn(List.of(new Course(courseName, "Maths1", 5)));

        List<Course> courses = courseService.getCourses("Maths");

        assertNotNull(courses);
        assertEquals(1, courses.size());
        verify(courseRepo, times(1)).findByNameContaining(anyString());
        assertEquals(courseName, courses.get(0).getName());
    }

    @Test
    @DisplayName("Should get course by id")
    void shouldGetCourseById() {
        
        when(courseRepo.findById(anyLong())).thenReturn(Optional.of(new Course("Maths", "Maths1", 5)));

        Optional<Course> course = courseService.getCourseById(1L);

        assertNotNull(course);
        assertTrue(course.isPresent());
        verify(courseRepo, times(1)).findById(anyLong());
    }

    @Test
    @MethodSource("mockCourseData")
    @DisplayName("Should get students by course id")
    void shouldGetStudentsByCourseId() {
        
        when(courseRepo.findById(anyLong())).thenReturn(Optional.of(mockCourseData().get(0)));

        Set<Student> students = courseService.getStudentsByCourseId(1L);

        assertNotNull(students);
        assertEquals(1, students.size());
        verify(courseRepo, times(1)).findById(anyLong());
    }

    @Test
    @MethodSource("mockCourseData")
    @DisplayName("Should create new course")
    void shouldCreateCourse() {

        ArgumentCaptor<Course> courseCaptor = ArgumentCaptor.forClass(Course.class);
        Course course = mockCourseData().get(0);

        courseService.createCourse(course);

        verify(courseRepo, times(1)).save(courseCaptor.capture());
        assertNotNull(courseCaptor.getValue());
        assertEquals(course, courseCaptor.getValue());
    }

    @Test
    @Disabled
    @MethodSource("mockCourseData")
    @DisplayName("Should edit course with success")
    void shouldEditCourse() {

        Course course = mockCourseData().get(0);
        Course course2 = mockCourseData().get(1);
        course2.setId(1L);

        when(courseRepo.existsById(anyLong())).thenReturn(true);
        when(courseRepo.save(course)).thenReturn(course);

        //assert that saved course was Maths course
        assertEquals("Maths", courseService.createCourse(course).getName());

        Course updatedCourse = courseService.updateCourse(1L, course2);

        verify(courseRepo, times(2)).save(Mockito.any());
        assertEquals(course, updatedCourse);
    }



    private List<Course> mockCourseData(){
        Course course1 = new Course("Maths", "Maths1", 5);
        course1.setId(1L);
        Course course2 = new Course("Bio", "Biology1", 5);

        Student student1 = new Student();
        student1.setLastName("Smith");

        course1.setStudents(Set.of(student1));

        List<Course> courseList = new ArrayList<>();

        courseList.add(course1);
        courseList.add(course2);

        return courseList;
    }


}
