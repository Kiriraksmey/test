package com.example.testingspringboot.validator;

import com.example.testingspringboot.entities.PaymentUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    public boolean supports(Class clazz) {
        // TODO Auto-generated method stub
        return PaymentUser.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub

        ValidationUtils.rejectIfEmpty(errors, "email", "email");
        ValidationUtils.rejectIfEmpty(errors, "password", "password");

        PaymentUser emplo = (PaymentUser) target;

        if (emplo.getEmail() != null && emplo.getEmail() == "aa") {
            errors.rejectValue("email", "email invalide ");

        }
    }
}
