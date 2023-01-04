package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.PaymentUserDetails;

import java.util.List;

public interface PaymentUserDetailService {
    void deletePaymentUserDetail(long id);
    List<PaymentUserDetails> getAllPaymentUserDetail();
    PaymentUserDetails savePaymentUserDetails(PaymentUserDetails paymentUserDetails);

    //   Course getCoursebyID(long id);
    PaymentUserDetails getPaymentUserDetailsById(Long id);


    PaymentUserDetails editPaymentUserDetail(PaymentUserDetails paymentUserDetails);
    PaymentUserDetails updateClassRoom(PaymentUserDetails paymentUserDetails);

    //    Student search(Student student);
    List<PaymentUserDetails>listAll(String keyword);
}
