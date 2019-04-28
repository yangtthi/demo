package com.example.demo.bus.impl;

import com.example.demo.bus.IBusService;
import com.example.demo.common.util.HttpUtil;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author wyatt
 * @Data 2018/09/14 12:12
 */
@Service
public class BusServiceImpl implements IBusService {

    private static String getStopUrl = "http://shanghaicity.openservice.kankanews.com/public/bus/Getstop?stoptype=TYPE&stopid=STOPID&sid=SID";

    @Override
    public String getBusByStop(int direction, String stop, String stopSign) {
        String url = getStopUrl.replace("TYPE", String.valueOf(direction))
                .replace("STOPID", stop)
                .replace("SID", stopSign);
        byte[] b = HttpUtil.doGet(url);
        return new String(b);
    }
}
