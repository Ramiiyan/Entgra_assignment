package com.engratcp.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class ServoRequestService {

    public void writeServoAngle(String request) {
        System.out.println("Angle :" + request);
    }
}
