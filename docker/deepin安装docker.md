## 安装
[deepin安装docker](https://wiki.deepin.org/wiki/Docker)

## 基础使用
### 1.创建使用一个Linux容器
```docker
docker run ubuntu:15.10 /bin/echo "Hello world"

//run 如果本地存在ubuntu:15.10  则直接运行该镜像，如果没有则从镜像仓库 Docker Hub 远程拉取镜像到本地后，使用镜像的/bin/echo命令，显示Hello world
```

### 2.使用Linux容器交互
//CTRL+D或exit退出

```docker
docker run -i -t ubuntu:15.10 /bin/bash

// -t 启动镜像终端
// -i 允许对镜像输入
```

### 3.容器
//容器 = 镜像 + 可读层   [docker镜像与容器的区别](https://www.cnblogs.com/bethal/p/5942369.html)
//简单来说，镜像就是一个不可变系统，容器是镜像基础上可读可写的系统 --个人观点

### 4.后台启动一个容器
```docker
docker run -d ubuntu:15.10 /bin/sh -c "while true; do echo hello world; sleep 1; done"

// -d 后台运行容器并返回容器id
// sh -c 执行字符串里的命令
```

### 5. 查看运行状态的容器
```docker
docker ps
```

### 6. 停止容器
```docker
docker stop 容器id/容器name
```

### 7. 使用 docker 构建一个 web 应用程序
```docker 
docker pull training/webapp
docker run -d -P training/webapp python app.py

//此时查看容器会发现容器tcp端口分配给了本地32768
```

### 8. 使用web应用程序
```docker
浏览器打开http://localhost:32768/
显示Hello world!
```

### 9.直接查看容器映射的端口
```docker
docker port 容器id/name
```

### 10.重启web容器
```docker
docker restart 容器id/name
```

### 11.移除web容器
```docker
docker rm 容器id/name
```

### 12.获取一个新的镜像
```docker
docker pull 镜像名:对应tag
```

### 13.查找镜像
```docker
docker search 
```

### 14.制作镜像(在已有的镜像基础上)
```docker
docker run -t -i ubuntu:15.10 /bin/bash
apt-get update
docker commit -m="has update" -a="shafish" e218edb10161 shafish/ubuntu:v2
docker images

//启动容器进行交互
//修改（更新操作）
//提交镜像
// -m 描述信息
// -a 作者
容器id
目标镜像名
```

### 15.制作镜像（从零构建）
Dockerfile
```docker
FROM    centos:6.7
MAINTAINER      Fisher "fisher@sudops.com"

RUN     /bin/echo 'root:123456' |chpasswd
RUN     useradd runoob
RUN     /bin/echo 'runoob:123456' |chpasswd
RUN     /bin/echo -e "LANG=\"en_US.UTF-8\"" >/etc/default/local
EXPOSE  22
EXPOSE  80
CMD     /usr/sbin/sshd -D

//from 指定镜像源
//run 在镜像内执行的命令
```
生成镜像
```docker
docker build -t shafish/centos:6.7 .

// -t 创建的镜像名
// .  Dockerfile路径
```

### 16.使用新建的镜像
```docker
docker run -t -i shafish/ubuntu:v2 /bin/bash     
docker run -t -i shafish/centos:6.7  /bin/bash
```

### 17.为镜像添加一个新的标签
```docker
docker tag 容器id shafish/centos:dev

//用户名称、镜像源名(repository name)和新的标签名(tag)。
```

## 实战环节
### 1.Docker安装nginx
```docker

```