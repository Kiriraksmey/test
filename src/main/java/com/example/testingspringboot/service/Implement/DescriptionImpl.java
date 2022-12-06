package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.DescriptionRepository;
import com.example.testingspringboot.entities.Description;
import com.example.testingspringboot.service.DescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionImpl implements DescriptionService {
    private final DescriptionRepository descriptionRepository;

    public DescriptionImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Override
    public void deleteDescription(long id) {

    }

    @Override
    public List<Description> getAllDescription() {
        return null;
    }

    @Override
    public Description saveDescription(Description description) {
        return null;
    }

    @Override
    public Description getDescriptionById(Long id) {
        return null;
    }

    @Override
    public Description editDescription(Description description) {
        return null;
    }

    @Override
    public Description updateClassRoom(Description description) {
        return null;
    }

    @Override
    public Description editEmployee(Description description) {
        return null;
    }

    @Override
    public List<Description> listAll(String keyword) {
        return null;
    }
}
