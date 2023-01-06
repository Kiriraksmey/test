package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.PaymentUser;

import java.util.List;

public interface PaymentUserService {
    void deletePaymentUser(long id);
    List<PaymentUser> getAllPaymentUser();
    PaymentUser savePaymentUser(PaymentUser paymentUser);

    //   Course getCoursebyID(long id);
    PaymentUser getPaymentUserById(Long id);


    PaymentUser editPaymentUser(PaymentUser paymentUser);
    PaymentUser updateClassRoom(PaymentUser paymentUser);

    //    Student search(Student student);
    List<PaymentUser>listAll(String keyword);
}
