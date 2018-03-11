package com.example.demo.user;

import com.example.demo.entity.test.User;

import java.util.List;

/**
 * Created by yangtthi on 18/3/11.
 */

public interface IUserService {

    /**
     * 获取所有User集合
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询User集合
     * id示例: id=5aa5453961c33ec2cdc97354
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 根据name查询User集合
     * name示例: name=tom
     * @param name
     * @return
     */
    User findByName(String name);
}
