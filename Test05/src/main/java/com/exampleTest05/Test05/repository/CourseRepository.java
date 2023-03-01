package com.exampleTest05.Test05.repository;

import com.exampleTest05.Test05.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
}
