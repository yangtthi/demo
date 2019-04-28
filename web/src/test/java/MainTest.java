import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @Description: TODO
 * @Author wyatt
 * @Data 2018/09/19 14:53
 */
@Slf4j
public class MainTest {

    @Test
    public void testSet(){
        Map<Long,Set<Long>> merchantIds = new HashMap<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        merchantIds.put(1L, set);
        merchantIds.get(1L).add(2L);
        log.info(JSON.toJSONString(merchantIds));
        log.info("****"+String.valueOf(Integer.valueOf("22341237")*100));

    }
}
