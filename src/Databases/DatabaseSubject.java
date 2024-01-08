package Databases;

public interface DatabaseSubject {
    void attach(DatabaseObserver observer);
    void detach(DatabaseObserver observer);
    void notifyObservers(DatabaseChangeEvent event);
}
