package top.yuyufeng.sessionshare.listener;

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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载配置文件
        Properties pro = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(this.getClass().getResource(CONFIG_PATH).getFile());
            pro.load(in);
            in.close();
            for (Object o : pro.keySet()) {
                System.out.println(pro.get(o));
            }
            Jedis jedis = new Jedis(pro.get(REDIS_HOST).toString(), Integer.valueOf(pro.get(REDIS_PORT).toString()));
            JedisUtil.init(jedis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
