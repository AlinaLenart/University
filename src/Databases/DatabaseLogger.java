package Databases;

public class DatabaseLogger implements DatabaseObserver{
    @Override
    public void update(DatabaseChangeEvent event){
        switch(event.getEventType()){
            case ADD:
                System.out.println("Dodano: " + event.getChangedData());
                break;
            case DELETE:
                System.out.println("Usunieto: " + event.getChangedData());
                break;
        }
    }
}
