##使用 curl 命令来下载安装：

#### 进入 /usr/local
cd /usr/local

#### 下载
sudo curl -O https://fastdl.mongodb.org/osx/mongodb-osx-x86_64-3.4.2.tgz

#### 解压
sudo tar -zxvf mongodb-osx-x86_64-3.4.2.tgz

#### 重命名为 mongodb 目录

sudo mv mongodb-osx-x86_64-3.4.2 mongodb

安装完成后，我们可以把 MongoDB 的二进制命令文件目录（安装目录/bin）添加到 PATH 路径中：

export PATH=/usr/local/mongodb/bin:$PATH