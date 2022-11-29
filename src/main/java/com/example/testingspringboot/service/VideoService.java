package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Video;

import java.util.List;

public interface VideoService {
        void deleteVideo(long id);
        List<Video> getAllVideo();
        Video saveVideo(Video video);

        List<Video> getListVideos(long id);

        Video editVideo(Video video);
        Video updateClassRoom(Video video);
        Video editEmployee(Video video);
        //    Student search(Student student);
        List<Video>listAll(String keyword);
        }
