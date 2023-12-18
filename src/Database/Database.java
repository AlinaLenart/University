package Database;

import Student.Course;

public interface Database {

    public void addRecord(Object ob);
//    public void deleteRecord();
//    public void editRecord();
    public void displayDatabase();
    public void results(int found);

}
