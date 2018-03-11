package com.example.demo.common.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by yangtthi on 18/3/11.
 */
public class MongoDBJDBC{

    private static Logger LOG  = LogManager.getLogger();

    public static void main( String args[] ){

        MongoClient mongoClient = null;
        try{
            // 连接到 mongodb 服务
            mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            LOG.info("Connect to database successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }finally {
            if(mongoClient != null){
                mongoClient.close();;
            }
        }
    }
}
