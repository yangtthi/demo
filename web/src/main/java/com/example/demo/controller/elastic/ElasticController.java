package com.example.demo.controller.elastic;

import com.example.demo.common.util.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangtthi on 18/3/11.
 */
@RestController
public class ElasticController {

    private static Logger LOG  = LogManager.getLogger();

    @Autowired
    private TransportClient client;

    @RequestMapping(value = "/accounts/person", method = RequestMethod.GET)
    public String get(@RequestParam(name = "id", defaultValue = "") String id ) {
        if(id.isEmpty()){
            return ResponseUtil.fail("param is null");
        }
        GetResponse result = client.prepareGet("accounts", "person", id).get();
        LOG.info("{} , {}" , result.getIndex(), result.getSource());
        return ResponseUtil.success(result.getSource());
    }
}
