package cn.gdou.DAO.ds;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBCPDatasorceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String mysqlUrl;
    @Value("${spring.datasource.username}")
    private String mysqlusername;
    @Value("${spring.datasource.password}")
    private String mysqlpassword;
    @Value("${spring.datasource.dbcp2.initial-size}")
    private Integer initSize;
    @Value("${spring.datasource.dbcp2.max-wait-millis}")
    private Integer maxWait;
    @Value("${spring.datasource.dbcp2.max-total}")
    private Integer maxTotal;
    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName(driverName);
        ds.setUrl(mysqlUrl);
        ds.setUsername(mysqlusername);
        ds.setPassword(mysqlpassword);
        ds.setInitialSize(initSize);
        ds.setMaxWaitMillis(maxWait);
        ds.setMaxTotal(maxTotal);
        return ds;
    }
}
