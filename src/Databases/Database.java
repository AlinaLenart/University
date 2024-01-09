package Databases;

public interface Database {

    public void addRecord(Object ob);
    public void displayDatabase(Class<?> displayType);
    public void saveDatabaseToFile(String filePath);
    public void loadDatabaseFromFile(String filePath);


}
