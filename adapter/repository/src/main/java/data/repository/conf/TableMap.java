package data.repository.conf;

public enum  TableMap {
    RESOURCELOAD(1),
    SHAREPAGE(2),
    COSMETOLOGIST(3),
    OPENAPP(4),
    FORWARDINGAPP(5),
    ASTERISKAPP(6),
    APPOINTMENT(7);
    private int eventid;

    TableMap(int eventid) {
        this.eventid = eventid;
    }

    public int getStatus() {
        return eventid;
    }
}
