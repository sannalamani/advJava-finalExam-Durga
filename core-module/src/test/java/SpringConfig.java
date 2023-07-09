import fr.epita.advjava.FacilityDAO;
import fr.epita.advjava.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public String testString() {
        return "test from spring!";
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Bean
    public MemberDAO memberDAO(@Autowired DataSource dataSource1){
        return new MemberDAO(dataSource1);
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

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("create-bookings.sql"));
        databasePopulator.addScript(new ClassPathResource("create-members.sql"));
        databasePopulator.addScript(new ClassPathResource("insert-members.sql"));
        databasePopulator.addScript(new ClassPathResource("create-facilities.sql"));
        databasePopulator.addScript(new ClassPathResource("insert-facilities.sql"));

        databasePopulator.addScript(new ClassPathResource("insert-bookings.sql"));

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }

    @Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactoryBean) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean.getObject());
        return transactionManager;
    }
}

