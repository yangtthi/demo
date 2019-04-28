package com.example.demo.controller.hello;

import com.example.demo.bus.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangtthi on 18/3/10.
 */
@RestController
public class HelloController {

    @Autowired
    private IBusService busService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }


    @RequestMapping(value = "/getBus", method = RequestMethod.GET)
    public String getBus(@RequestParam("direction") int direction
            ,@RequestParam("stop") String stop
            ,@RequestParam("stopSign") String stopSign){
        return busService.getBusByStop(direction, stop, stopSign);
    }
}
