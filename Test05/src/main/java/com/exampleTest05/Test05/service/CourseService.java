package com.exampleTest05.Test05.service;

import com.exampleTest05.Test05.model.Course;
import com.exampleTest05.Test05.model.Student;
import com.exampleTest05.Test05.repository.CourseRepository;
import com.exampleTest05.Test05.repository.StudentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public Course addCourse(JSONObject jsonObject) {
        Course course = new Course();
        String course_id = UUID.randomUUID().toString();
        course.setCourse_id(course_id);
        course.setTitle(jsonObject.getString("title"));
        course.setDescription(jsonObject.getString("description"));
        course.setDuration(jsonObject.getString("duration"));
        course.setStudentList(new ArrayList<>());
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(String course_id) {
        if(course_id!=null){
            List<Course>list = new ArrayList<>();
            list.add(courseRepository.findById(course_id).get());
            return list;
        }
        return courseRepository.findAll();
    }

    public Course addStudentToCourse(String course_id, String student_id) {
        Course course = courseRepository.findById(course_id).get();
        Student student = studentRepository.findById(student_id).get();
        List<Student>list = course.getStudentList();
        list.add(student);
        course.setStudentList(list);
        return courseRepository.save(course);
    }

    public void deleteCourseById(String courseId) {
        courseRepository.deleteById(courseId);
    }
}
