package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoReposiory extends JpaRepository<Video, Long> {
    @Query("select c from Video c where c.courseDetailId=?1")
    public List<Video> getVideoByCourseDetailId(Long id);
}
