package com.example.demo.controller.mongo;

import com.example.demo.common.util.ResponseUtil;
import com.example.demo.user.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangtthi on 18/3/11.
 */

@RestController
public class MongoController {

    private static Logger LOG  = LogManager.getLogger();

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/mongo/user", method = RequestMethod.GET)
    public String get(@RequestParam(value = "id", defaultValue = "") String id){
        return ResponseUtil.success(userService.findById(id));
    }

    @RequestMapping(value = "/mongo/userList", method = RequestMethod.GET)
    public String userList(){
        return ResponseUtil.success(userService.findAll());
    }

}
