# monitor
monitor is a jvm watch ，one machine only need one

## 原项目路径 
https://github.com/ystcode/JavaMonitor

感谢作者对于开源项目贡献，本项目是基于此二次开发
## 安装环境
>+ jdk版本：jdk8+
>+ maven版本：3.5.4+
>+ 需要机器中有JDK，不仅仅是JRE，配置好java path，程序中依靠ExcuteCmd找寻jdk基本命令
>+ 一个操作系统中有一个java程序引入该包就可以
## spring boot 引入
     <dependency>
            <groupId>com.github.xk4848123</groupId>
            <artifactId>monitor-spring-boot-starter</artifactId>
            <version>2.3.1</version>
     </dependency>
     maven仓库发布中.....   
## spring boot 配置
>+ 若配置文件为 application.properties
>+ monitor.path=monitor（决定访问路径,可以自行定义）
>+ monitor.enable=true（决定是否启动监控客户端）

## api
>+ http://ip:port/monitor/system 获取操作系统相关信息
>+ http://ip:port/monitor/version 获取java版本相关信息
>+ http://ip:port/monitor/jps 获取java进程号
>+ http://ip:port/monitor/info?id=pid
>+ http://ip:port/monitor/jstack?id=pid
>+ http://ip:port/monitor/jstatclass?id=pid
>+ http://ip:port/monitor/jstatgc?id=pid
>+ http://ip:port/monitor/jstatutil?id=pid
>+ http://ip:port/monitor/heap?id=pid 下载对应进程堆dump
>+ http://ip:port/monitor/thread?id=pid 下载对应进程线程栈

## 堆栈信息相关
请求heap、thread api时程序是讲堆栈信息通过命令保存到本地文件存储（存储于项目路径下的dump目录下，需保证启动程序用户具有该项目目录的修改权限），然后引导浏览器下载
Spring boot中开启@EnableScheduling可定时清理dump目录文件（目前该程序是每小时执行一次）



