package Databases;

public interface Database {

    public void addRecord(Object ob);
//    public void deleteRecord();
//    public void editRecord();
    public void displayDatabase(Class<?> displayType);
    public void results(int found);
    public void saveDatabaseToFile(String filePath);
    public void loadDatabaseFromFile(String filePath);


}
