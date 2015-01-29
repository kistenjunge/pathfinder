package kistenjunge.org.integrationtest;

import com.seitenbau.stu.database.extend.impl.MySQLAutoIncrementReset;
import com.seitenbau.stu.database.rule.DatabaseTesterRule;
import com.seitenbau.stu.database.tester.DatabaseTesterBase;
import kistenjunge.org.ITestConfiguration;
import kistenjunge.org.database.dataset.EmptyDataset;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.mssql.MsSqlDataTypeFactory;
import org.junit.Rule;

public class ITestBase
{
  @Rule
  public DatabaseTesterRule dbRule = new DatabaseTesterRule(ITestConfiguration.class)
      .addCleanAction(new MySQLAutoIncrementReset(){
        @Override public void doPrepareDatabase(DatabaseTesterBase<?> tester, IDataSet dataset)
            throws Exception
        {
          // FIXED IN STU TRUNK
          doCleanDatabase(tester, dataset);
        }
      })
      .setDefaultDataSet(new EmptyDataset());
}
