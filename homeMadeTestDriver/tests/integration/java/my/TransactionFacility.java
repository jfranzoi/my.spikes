package my;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionFacility {

   private DataSourceTransactionManager transactionManager;
   private TransactionStatus transactionStatus;

   public TransactionFacility(DataSourceTransactionManager aTransactionManager) {
      transactionManager = aTransactionManager;
      transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
   }

   public void rollback() {
      if (transactionManager != null && transactionStatus != null) {
         transactionManager.rollback(transactionStatus);
      }
   }

}
