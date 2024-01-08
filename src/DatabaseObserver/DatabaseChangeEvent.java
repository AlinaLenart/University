package DatabaseObserver;

public class DatabaseChangeEvent {

    public enum EventType {ADD, DELETE}
    private EventType eventType;
    private Object changedData;

    public DatabaseChangeEvent(EventType eventType, Object changedData){

        this.eventType = eventType;
        this.changedData = changedData;
    }

    public EventType getEventType(){
        return eventType;
    }

    public Object getChangedData(){
        return changedData;
    }

}
