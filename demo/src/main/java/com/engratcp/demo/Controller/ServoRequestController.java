package com.engratcp.demo.Controller;

import com.engratcp.demo.Exception.ResourceNotFoundException;
import com.engratcp.demo.Model.ServoRequest;
import com.engratcp.demo.Repository.RequestRepository;

import com.engratcp.demo.Service.ServoRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServoRequestController {

    private ServoRequestService servoRequestService;

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/test")
    public String Test(){
        System.out.println("Testing...");
        return "Testing.";
    }
//    get all requests
    @GetMapping("/servoRequests")
    public List<ServoRequest> servoRequests(){
        System.out.println("get all servo Requests");

        return requestRepository.findAll();
    }
    // create a new ServoRequest
    @PostMapping("/servoRequest")
    public ServoRequest createServoRequest(@RequestBody ServoRequest servoRequest){

//      requestRepository.save(servoRequest);
        System.out.println(servoRequest.toString());
        System.out.println("servo Request created");
        servoRequestService.writeServoAngle(servoRequest.getRequest());
        return requestRepository.save(servoRequest);
    }
    @GetMapping("/servoRequests/{id}")
    public ServoRequest getServoReqById(@PathVariable(value = "id") Long reqId) {
        return requestRepository.findById(reqId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", reqId));
    }
}
