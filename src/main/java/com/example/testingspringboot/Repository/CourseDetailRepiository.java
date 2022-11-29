package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.CourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailRepiository extends JpaRepository<CourseDetail , Long> {

    @Query("select c from CourseDetail c where c.courseId=?1")
    public List<CourseDetail> getCourseDetailByCourseId(Long id);


}
