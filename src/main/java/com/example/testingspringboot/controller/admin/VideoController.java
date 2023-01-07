package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Video;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/")
public class VideoController {
    @Autowired
    private final VideoService videoService;
    private final CourseService courseService;
    public VideoController(VideoService videoService, CourseService courseService) {
        this.videoService = videoService;
        this.courseService = courseService;
    }
    @GetMapping("/videoList")
    public String listVideo(Model model) {
        List list = videoService.getAllVideo();
        model.addAttribute("videos", videoService.getAllVideo());
        return "frontend/Video/video";
    }

    @GetMapping("/deletevideo/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return "redirect:/system/videoList";
    }

    @GetMapping("/create-video")
    public String createEmployee(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "/course/video";
    }

    @PostMapping("/saveVideo")
    public String saveEmploye(@ModelAttribute("videos") Video video) {
        videoService.saveVideo(video);
        return "redirect:/system/videoList";
    }

    @GetMapping("editVideo/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("videos", videoService.getVideoById(id));
        return "employee/edit";

    }

    @PostMapping("/updateVideo")
    public String updateStudent(@PathVariable Long id, Video video) {
        videoService.saveVideo(video);
        return "redirect:/system/coursetList";

    }
}
