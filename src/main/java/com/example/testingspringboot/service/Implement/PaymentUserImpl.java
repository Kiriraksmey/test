package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.PaymentUserRepository;
import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.PaymentUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentUserImpl implements PaymentUserService {
    private final PaymentUserRepository paymentUserRepository;

    public PaymentUserImpl(PaymentUserRepository paymentUserRepository) {
        this.paymentUserRepository = paymentUserRepository;
    }

    @Override
    public void deletePaymentUser(long id) {
        paymentUserRepository.deleteById(id);
    }

    @Override
    public List<PaymentUser> getAllPaymentUser() {
        return paymentUserRepository.findAll();
    }

    @Override
    public PaymentUser savePaymentUser(PaymentUser paymentUser) {
        return paymentUserRepository.save(paymentUser);
    }

    @Override
    public PaymentUser getPaymentUserById(Long id) {
        PaymentUser lst =  paymentUserRepository.findById(id).get();
        return  lst;
    }

    @Override
    public PaymentUser editPaymentUser(PaymentUser paymentUser) {
        return paymentUserRepository.save(paymentUser);
    }

    @Override
    public PaymentUser updateClassRoom(PaymentUser paymentUser) {
        return null;
    }

    @Override
    public List<PaymentUser> listAll(String keyword) {
       return  null;
    }
}
