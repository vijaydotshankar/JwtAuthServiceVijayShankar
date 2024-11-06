package com.vijay.service.impl;

import com.vijay.entity.User;
import com.vijay.exception.ResourceNotFoundException;
import com.vijay.repository.SignupRepository;
import com.vijay.service.SignupService;
import org.springframework.stereotype.Service;


@Service
public class SignupServiceImpl implements SignupService {

    private final SignupRepository signupRepository;

    public SignupServiceImpl(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }

    @Override
    public User saveCredetials(User user) {
        if (user != null) {
            return signupRepository.save(user);
        } else {
            throw new ResourceNotFoundException("please perform signup");
        }
    }
}
