package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.PaymentUserDetailsRepository;
import com.example.testingspringboot.Repository.PaymentUserRepository;
import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.PaymentUserDetails;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.PaymentUserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PaymentDetailServiceImpl implements PaymentUserDetailService {
    private final PaymentUserDetailsRepository paymentUserDetailsRepository;



    public PaymentDetailServiceImpl(PaymentUserDetailsRepository paymentUserDetailsRepository) {
        this.paymentUserDetailsRepository = paymentUserDetailsRepository;
    }



    @Override
    public void deletePaymentUserDetail(long id) {
        paymentUserDetailsRepository.deleteById(id);

    }

    @Override
    public List<PaymentUserDetails> getAllPaymentUserDetail() {
        return paymentUserDetailsRepository.findAll();
    }

    @Override
    public PaymentUserDetails savePaymentUserDetails(PaymentUserDetails paymentUserDetails) {
        return paymentUserDetailsRepository.save(paymentUserDetails);
    }

    @Override
    public PaymentUserDetails getPaymentUserDetailsById(Long id) {
        PaymentUserDetails lst =  paymentUserDetailsRepository.findById(id).get();
        return  lst;
    }

    @Override
    public PaymentUserDetails editPaymentUserDetail(PaymentUserDetails paymentUserDetails) {
        return null;
    }


    @Override
    public PaymentUserDetails updateClassRoom(PaymentUserDetails paymentUserDetails) {
        return null;
    }

    @Override
    public List<PaymentUserDetails> listAll(String keyword) {
        return null;
    }


}
