package com.example.demo.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by yangtthi on 18/3/10.
 */
public class LogUtil {

    private static Logger LOG  = LogManager.getLogger();

    public static void main(String[] args) {

         System.out.println("This is println message.");

        // 记录debug级别的信息
        LOG.debug("This is debug message.");
        // 记录info级别的信息
        LOG.info("This is info message.");
        // 记录error级别的信息
        LOG.error("This is error message.");
    }

}

