package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Video;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.TeacherService;
import com.example.testingspringboot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/system/")
public class VideoController {
    @Autowired
    private final VideoService videoService;
    private final CourseService courseService;
    private final CourseDetailService courseDetailService;

    private final TeacherService teacherService;

    public VideoController(VideoService videoService, CourseService courseService, CourseDetailService courseDetailService, TeacherService teacherService) {
        this.videoService = videoService;
        this.courseService = courseService;
        this.courseDetailService = courseDetailService;

        this.teacherService = teacherService;
    }
    @GetMapping("/videoList")
    public String listVideo(Model model) {
        List list = videoService.getAllVideo();
        model.addAttribute("videos", videoService.getAllVideo());
        return "video/video";
    }

    @GetMapping("/deletevideo/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return "redirect:/system/videoList";
    }

    @GetMapping("/create-video")
    public String createEmployee(Model model) {
        List lst = courseDetailService.getAllCourseDetail();
        model.addAttribute("courses", courseDetailService.getAllCourseDetail());
//        model.addAttribute("teacherList", teacherService.getAllTeacher());
        model.addAttribute("videos", courseService.getAllCourse());
        return "video/create-video";
    }
//    @GetMapping("/create-video")
//    public String createEmployee(Model model) {
//        model.addAttribute("courses", courseService.getAllCourse());
//        model.addAttribute("teacherList", teacherService.getAllTeacher());
//        return "/course/video";
//    }


    @PostMapping("/saveVideo")
    public String saveEmploye(@ModelAttribute("videos") Video video) {
        Date date = new Date();
        video.setCreateDate(date);
        videoService.saveVideo(video);
        return "redirect:/system/videoList";
    }

    @GetMapping("editVideo/{id}")
    public String editsvideos(@PathVariable Long id, Model model) {
        model.addAttribute("videos", videoService.getVideoById(id));
        return "video/editvideo";

    }

    @PostMapping("/updateVideo/{id}")
    public String updateStudent(@PathVariable Long id, Video video) {
        videoService.saveVideo(video);
        return "redirect:/system/videoList";

    }
}
