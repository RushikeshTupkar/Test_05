package com.exampleTest05.Test05.controller;

import com.exampleTest05.Test05.model.Course;
import com.exampleTest05.Test05.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
@Autowired
   private CourseService courseService;

@PostMapping("/addCourse")
    public Course addCourse(@RequestBody String course){
    JSONObject jsonObject = new JSONObject(course);
    return courseService.addCourse(jsonObject);
}
@GetMapping("/get_all_courses/")
    public List<Course> getAllCourses(@Nullable @RequestParam("course_id") String course_id){
    return courseService.getAllCourses(course_id);
}
@PutMapping("/add_student_to_course")
    public Course addStudentToCourse(@RequestParam ("course_id") String course_id,
                                     @RequestParam ("student_id") String student_id ){

    return courseService.addStudentToCourse(course_id,student_id);
     }
@DeleteMapping("/delete_course_by_id")
    public void deleteCourseById(@RequestParam("course_id") String course_id){
     courseService.deleteCourseById(course_id);
    }
}


