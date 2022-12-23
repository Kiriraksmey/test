package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.VideoReposiory;
import com.example.testingspringboot.entities.Video;
import com.example.testingspringboot.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Videoimpl implements VideoService {
    private final VideoReposiory videoReposiory;


    public Videoimpl(VideoReposiory videoReposiory) {
        this.videoReposiory = videoReposiory;
    }

    @Override
    public void deleteVideo(long id) {

    }

    @Override
    public List<Video> getAllVideo() {
        return videoReposiory.findAll();
    }

    @Override
    public Video saveVideo(Video video) {
        return videoReposiory.save(video);
    }

    @Override
    public List<Video> getListVideos(long id) {
        return  videoReposiory.getVideoByCourseDetailId(id);
    }

    @Override
    public Video getVideoById(Long id) {
        Video lst = videoReposiory.findById(id).get();
        return  lst;
    }

    @Override
    public Video editVideo(Video video) {
        return videoReposiory.save(video);
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
