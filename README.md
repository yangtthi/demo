###需求分析：

```
   1.SpringBoot Maven
   2.RestfulAPI Controller Service
   3.Elasticsearch  MongoDB Mysql 数据存储、操作
   4.JSON数据处理
   5.多线程操作
```

###模块介绍

```
notes: 学习笔记 
```

###接口

####1./hello

```
get http://localhost:8080/hello

Hello World!
```

####2./accounts/person?id=1

```
get http://localhost:8080/accounts/person?id=1

{
    "code":200,
    "data":{
        "title":"工程师",
        "user":"李四",
        "age":20,
        "desc":"数据库管理，软件开发2"
    },
    "message":""
}
```

####3./mongo/userList

```
get http://localhost:8080/mongo/userList

{
    "code":200,
    "data":[
        {
            "age":21,
            "id":"5aa5453961c33ec2cdc97354",
            "name":"tom"
        }
    ],
    "message":""
}
```

####4./mongo/user?id=5aa5453961c33ec2cdc97354

```
get http://localhost:8080/mongo/user?id=5aa5453961c33ec2cdc97354

{
    "code":200,
    "data":{
        "age":21,
        "id":"5aa5453961c33ec2cdc97354",
        "name":"tom"
    },
    "message":""
}
```

####5./book/list

```
get http://localhost:8080/book/list

{
    "code":200,
    "message":""
}
```