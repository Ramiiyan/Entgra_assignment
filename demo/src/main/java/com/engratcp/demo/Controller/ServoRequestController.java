package com.engratcp.demo.Controller;

import com.engratcp.demo.Exception.ResourceNotFoundException;
import com.engratcp.demo.Model.ServoRequest;
import com.engratcp.demo.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/")
public class ServoRequestController {

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("test")
    public String Test(){
        System.out.println("Testing...");
        return "Testing.";
    }
//    get all requests
    @GetMapping("servoRequests")
    public List<ServoRequest> servoRequests(){
        System.out.println("get all servo Requests");

        return requestRepository.findAll();
    }
    // create a new ServoRequest
    @PostMapping("servoRequest")
    public ServoRequest createServoRequest(@Validated @RequestBody ServoRequest servoRequest){

        System.out.println("servo Request created");
        return requestRepository.save(servoRequest);
    }
    @GetMapping("/servoRequests/{id}")
    public ServoRequest getServoReqById(@PathVariable(value = "id") Long reqId) {
        return requestRepository.findById(reqId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", reqId));
    }
}
