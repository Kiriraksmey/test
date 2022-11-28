package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.entities.Video;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Videoimpl implements VideoService {
    @Override
    public void deleteVideo(long id) {

    }

    @Override
    public List<Video> getAllVideo() {
        return null;
    }

    @Override
    public Video saveVideo(Video video) {
        return null;
    }

    @Override
    public List<Video> getVideobyID(long id) {
        return null;
    }

    @Override
    public Video editVideo(Video video) {
        return null;
    }

    @Override
    public Video updateClassRoom(Video video) {
        return null;
    }

    @Override
    public Video editEmployee(Video video) {
        return null;
    }

    @Override
    public List<Video> listAll(String keyword) {
        return null;
    }
}
