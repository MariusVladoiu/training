package com.wipro.training.service.impl;

import com.wipro.training.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet() {
        return "Hello World";
    }
}
