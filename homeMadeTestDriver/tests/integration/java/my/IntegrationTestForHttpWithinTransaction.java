package my;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class IntegrationTestForHttpWithinTransaction extends IntegrationTestForHttp {

   private static final String springDefaultParentContextFile = "beanRefContext.xml";
   private static final String sharedResourcesContextName = "shared-resources-context";

   private static BeanFactory beanFactory;

   protected DataSource dataSource;
   private TransactionFacility transactionFacility;

   @Before
   public void setUp() throws Exception {
      BeanFactoryLocator singletonFactoryLocator = ContextSingletonBeanFactoryLocator.getInstance(springDefaultParentContextFile);
      beanFactory = singletonFactoryLocator.useBeanFactory(sharedResourcesContextName).getFactory();

      DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) getSharedBean("transactionManager");
      transactionFacility = new TransactionFacility(transactionManager);

      dataSource = (DataSource) getSharedBean("dataSource");
   }

   @After
   public void tearDown() {
      transactionFacility.rollback();
   }

   protected Object getSharedBean(String beanId) {
      return beanFactory.getBean(beanId);
   }

}
