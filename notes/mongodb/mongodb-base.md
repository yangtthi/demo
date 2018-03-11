###运行 MongoDB

1、首先我们创建一个数据库存储目录 /data/db：

sudo mkdir -p /data/db

启动 mongodb，默认数据库目录即为 /data/db：

sudo mongod

###### 如果没有创建全局路径 PATH，需要进入以下目录
cd /usr/local/mongodb/bin
sudo ./mongod

再打开一个终端进入执行以下命令：

$ cd /usr/local/mongodb/bin 
$ ./mongo
MongoDB shell version v3.4.2
connecting to: mongodb://127.0.0.1:27017
MongoDB server version: 3.4.2
Welcome to the MongoDB shell.
……
> 1 + 1
2
> 

    注意：如果你的数据库目录不是/data/db，可以通过 --dbpath 来指定。