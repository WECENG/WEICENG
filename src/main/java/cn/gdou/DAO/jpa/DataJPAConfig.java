package cn.gdou.DAO.jpa;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("cn.gdou.DAO.repository")
public class DataJPAConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            JpaVendorAdapter adapter, DataSource dataSource){
        LocalContainerEntityManagerFactoryBean emf=
                new LocalContainerEntityManagerFactoryBean();
        emf.setJpaVendorAdapter(adapter);
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("cn.gdou.DAO.domain");
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public JpaVendorAdapter adapter(){
        HibernateJpaVendorAdapter adapter=
                new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57InnoDBDialect");
        adapter.setGenerateDdl(true);
        adapter.setShowSql(true);
        adapter.setDatabase(Database.MYSQL);
        return adapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager();
    }

    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
