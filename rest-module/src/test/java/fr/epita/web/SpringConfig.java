package fr.epita.web;

import fr.epita.advjava.FacilityDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringConfig {

    @Bean
    public DataSource mainDatasource(){
        return new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa","sa");
    }

    @Bean
    public FacilityDAO facilityDAO(@Autowired DataSource dataSource) {
        return new FacilityDAO(dataSource);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource ds){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(ds);
        localSessionFactoryBean.setPackagesToScan("fr.epita.advjava.datamodel");
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }



}
