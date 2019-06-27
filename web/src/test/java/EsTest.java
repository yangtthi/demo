import com.alibaba.fastjson.JSON;
import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description: TODO
 * @Author wyatt
 * @Data 2019/04/30 15:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
@Slf4j
public class EsTest {

    @Autowired
    private TransportClient client;

    @Test
    public void testGet(){

        GetResponse result = client.prepareGet("music", "songs", "1").get();
        log.info(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(result));

        int page = 1;
        int size = 10;
        SearchRequestBuilder requestBuilder = client.prepareSearch("music").setTypes("songs");
        requestBuilder.setQuery(QueryBuilders.termsQuery("_id",Arrays.asList("1","2")));
        requestBuilder.setFrom((page - 1) * size).setSize(size);
        SearchResponse searchResponse = requestBuilder.execute().actionGet();
        log.info(JSON.toJSONString(searchResponse));
        System.out.println(JSON.toJSONString(searchResponse));

        SearchHits hits = searchResponse.getHits();
        System.out.println((int)hits.getTotalHits());
        for (SearchHit searchHit : hits) {
            Map source = searchHit.getSource();
            System.out.println(source);
        }

    }
}
