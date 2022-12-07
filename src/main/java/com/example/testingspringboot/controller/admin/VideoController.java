package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.Video;
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

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
    @GetMapping("/videoList")
    public String listVideo(Model model) {
        List list = videoService.getAllVideo();
        model.addAttribute("videos", videoService.getAllVideo());
        return "video";
    }
    @GetMapping("/deletevideo/{id}")
    public String deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return "redirect:/system/videoList";
    }

    @GetMapping("/create-video")
    public String createEmployee(Model model) {
        return "Create";
    }

    @PostMapping("/saveVideo")
    public String saveEmploye(@ModelAttribute("video") Video video) {
        videoService.saveVideo(video);
        return "redirect:/system/videoList";
    }

    @GetMapping("editVideo/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("course", videoService.getVideoById(id));
        return "employee/edit";

    }

    @PostMapping("/updateVideo")
    public String updateStudent(@PathVariable Long id, Video video) {
        videoService.saveVideo(video);
        return "redirect:/system/coursetList";

    }
}
