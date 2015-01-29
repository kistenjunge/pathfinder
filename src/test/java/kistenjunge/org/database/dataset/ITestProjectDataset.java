package kistenjunge.org.database.dataset;

public class ITestProjectDataset extends kistenjunge.org.database.dataset.EmptyDataset
{
  
  protected void initDataSet()
  {
    table_Project
      .insertRow()
        .setTitle("alpha")
        .setDescription("description for alpha").nextId()
      ;
    table_Project
      .insertRow()
        .setTitle("beta").nextId()
      ;
  }
}
