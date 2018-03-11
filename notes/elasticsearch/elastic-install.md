##Elastic安装

###1.官网地址： https://www.elastic.co/

```
下载地址：https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.2.2.tar.gz
cd /usr/local
sudo wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.2.2.tar.gz
sudo tar -zxvf elasticsearch-6.2.2.tar.gz
```

```
启动：./bin/elasticsearch
后台启动  ./bin/elasticsearch -d

```

###2.按照head插件

```
github地址： https://github.com/mobz/elasticsearch-head
下载地址： https://github.com/mobz/elasticsearch-head/archive/master.zip
cd /usr/local
sudo wget https://github.com/mobz/elasticsearch-head/archive/master.zip
sudo tar -zxvf  master.zip
cd elasticsearch-head-master/
npm install
```

```启动
npm run start
```

###3.插件配置，关联elasticsearch和head插件

```
cd elasticsearch-6.2.2
vim config/elasticsearch.yml
在文档最后加入
http.cors.enabled: true
http.cors.allow-origin: "*"
保存退出
```

###4.集群配置

####复制安装
```
es_master
es_slave
    es_slave1
    es_slave2
```

####配置
vim config/elasticsearch.yml

#####master：
```
http.cors.enabled: true
http.cors.allow-origin: "*"

cluster.name: wali
node.name: master
node.master: true

network.host: 127.0.0.1

```

#####slave1:

```
cluster.name: wali
node.name: slave1

network.host: 127.0.0.1
http.port: 8200

discovery.zen.ping.unicast.hosts: ["127.0.0.1"]
```

#####slave2:

```
cluster.name: wali
node.name: slave2

network.host: 127.0.0.1
http.port: 8000

discovery.zen.ping.unicast.hosts: ["127.0.0.1"]
```