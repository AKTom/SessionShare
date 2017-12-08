package top.yuyufeng.sessionshare.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import top.yuyufeng.sessionshare.util.JedisUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 初始化
 *
 * @author yuyufeng
 * @date 2017/12/8
 */
@WebListener("initListener")
public class InitListener implements ServletContextListener {

    private final static String CONFIG_PATH = "/ssc-config.properties";
    private final static String REDIS_HOST = "redis.host";
    private final static String REDIS_PORT = "redis.port";
    private final static String REDIS_PASSWORD = "redis.password";

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载配置文件
        Properties pro = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(this.getClass().getResource(CONFIG_PATH).getFile());
            pro.load(in);
            in.close();

            //redis初始化
            Jedis jedis = new Jedis(pro.get(REDIS_HOST).toString(), Integer.valueOf(pro.get(REDIS_PORT).toString()));
            jedis.auth(pro.get(REDIS_PASSWORD).toString());
            JedisUtil.init(jedis);

        } catch (Exception e) {
            LOG.error("session-share 初始化失败 " + e.getMessage());
        }
        LOG.info("redis ping:" + JedisUtil.getJedis().ping());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
