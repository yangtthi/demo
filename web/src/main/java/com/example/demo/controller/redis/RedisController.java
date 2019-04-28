package com.example.demo.controller.redis;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.test.User;
import com.example.demo.util.SerializeUtil;
import com.example.demo.util.redis.RedisConstants;
import com.example.demo.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: RedisController
 * @Auther: zhangyingqi
 * @Date: 2018/8/29 16:15
 * @Description:
 */
@Controller
@RequestMapping(value="/redis")
public class RedisController{
    @Autowired
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 16:23 2018/8/29
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 执行redis写/读/生命周期
     */
    @RequestMapping(value = "getRedis",method = RequestMethod.POST)
    @ResponseBody
    public String getRedis(){
        redisUtil.set("test:20182018","这是一条测试数据", RedisConstants.datebase1);
        Long resExpire = redisUtil.expire("20182018", 600, RedisConstants.datebase1);//设置key过期时间
        String res = redisUtil.get("20182018", RedisConstants.datebase1);
        //测试Redis保存对象
        User u = new User();
        u.setAge(24);
        u.setName("冯绍峰");
        redisUtil.set("test:20181017", JSON.toJSONString(u),RedisConstants.datebase1);
        String userString = redisUtil.get("20181017",RedisConstants.datebase1);
        User us = JSON.parseObject(userString, User.class);
        System.out.println("user="+us.toString());
        return JSON.toJSONString(res);
    }

}
