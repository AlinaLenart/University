package Databases;

public interface DatabaseObserver {
    void update(DatabaseChangeEvent event);
}
