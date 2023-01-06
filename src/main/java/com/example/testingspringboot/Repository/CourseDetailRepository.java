package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail , Long> {

    @Query("select c from CourseDetail c where c.courseId=?1")
    public List<CourseDetail> getCourseDetailByCourseId(Long id);

//    @Query("FROM Course
//            INNER JOIN CourseDetail INNER JOIN Video
//            WHERE Course.id = CourseDetail.
//            AND videos.course_detail_id = course_detail.id
//            AND videos.default = 1");


    @Query("SELECT v FROM  Video v inner join CourseDetail cd On cd.id = v.courseDetailId INNER JOIN Course c ON c.id = cd.courseId where c.id=?1 and v.defualt = true ")
    public Video findDefaultVideo(Long id);
//    @Query("SELECT c FROM  Course c  inner join CourseDetail cd On Course .id = CourseDetail .courseId " +
//            "inner join Video v On v.courseDetailId = CourseDetail .id where c.id=?1")
//    public List<Video> findDefaultVideo(Long id);


    @Query("SELECT SUM(c.price) FROM Course c where c.id IN (:id)")
    public Double getTotalPriceCourse(@Param("id") List<Long> id);

}
