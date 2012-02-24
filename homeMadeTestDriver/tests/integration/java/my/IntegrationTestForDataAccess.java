package my;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class IntegrationTestForDataAccess {

   private ClassPathXmlApplicationContext applicationContext;
   private TransactionFacility transactionFacility;

   protected DataSource dataSource;

   @Before
   public void setUp() throws Exception {
      applicationContext = new ClassPathXmlApplicationContext(new String[] { "classpath:datasources.xml", "classpath:datasources-test.xml" });
      dataSource = (DataSource) applicationContext.getBean("dataSource");

      DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) applicationContext.getBean("transactionManager");
      transactionFacility = new TransactionFacility(transactionManager);
   }

   @After
   public void tearDown() {
      transactionFacility.rollback();
      applicationContext.close();
   }

}