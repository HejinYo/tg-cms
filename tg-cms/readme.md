项目：图灵谷cms
版权：图灵谷（北京）科技有限公司
部署配置流程：
1、安装jdk。版本1.8及以上。
2、安装tomcat。版本8.0及以上。
3、安装postgresql。版本9.4及以上。
4、安装redis。版本3.0及以上。
5、修改license文件。
6、application.properties中修改数据库配置。数据库url，用户名，数据库连接密码加密处理。
7、application.properties中修改redis配置。数据库ip，密码，默认数据库。
8、application.properties中修改文件上传路径。system.baseStoragePath。
9、application.properties中开启thymeleaf缓存以便提高效率。thymeleaf.cacheable=true。
10、log4j2.xml中修改系统日志级别为INFO，其它第三方库文件的日志级别为WARN。


