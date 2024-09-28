# spring-boot-cli
    Spring Boot 项目脚手架

## 简介
    由于每次项目构建时 Spring Boot 都需要整合一些公共的组件，本项目主要提供一种公用的整合方案，以方便快速开发。
### 基础组件
    1. 日志组件：整合logback，并输出json格式日志
    2. 数据库组件：整合mysql，使用mybatis
    3. 统一的返回结果：统一返回结果，方便前端处理

## 快速开始
### 下载/clone项目
    git clone https://github.com/weihongyu1/spring-boot-cli.git
### 生成脚手架项目

在项目目录下执行

    mvn archetype:create-from-project
### 安装到本地Maven仓库
**进入如下目录**

```
cd ./target/generated-sources/archetype
```

**安装到本地仓库**

```
mvn install
```

### 使用

**使用命令创建项目**

```
mvn archetype:generate -DgroupId=com.example -DartifactId=demo -DarchetypeGroupId=com.example -DarchetypeArtifactId=spring-boot-cli -DarchetypeVersion=1.0-SNAPSHOT -DinteractiveMode=false
```

**IDEA创建项目**

![](https://github.com/weihongyu1/spring-boot-cli/blob/dev/data/img/%E4%BD%BF%E7%94%A8.png?raw=true)

设置Maven仓库为本地仓库

![](https://github.com/weihongyu1/spring-boot-cli/blob/dev/data/img/%E8%AE%BE%E7%BD%AEMaven.png?raw=true)

## 其他

### 访问Druid监控

http://127.0.0.1/cli/druid/sql.html

- 端口为项目端口
- 路由uri需要加上Spring Boot设置的统一的前缀