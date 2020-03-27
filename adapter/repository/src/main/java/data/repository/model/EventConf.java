package data.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventConf {
    /*("1","RESOURCELOAD"),
    SHAREPAGE("2","SHAREPAGE"),
    COLLECTIONPAGE("3","COLLECTIONPAGE"),
    OPENAPP("4","OPENAPP"),
    FORWARDINGAPP("5","FORWARDINGAPP"),
    ASTERISKAPP("6","ASTERISKAPP"),
    APPOINTMENT("7","APPOINTMENT");
    private String eventId;
    private String tableName;
    EventConf(String tableName){
        this.eventId=eventId;
        this.tableName=tableName;
    }
    public String getEventId() {
        return eventId;
    }
    public String getTableName() {
        return tableName;
    }*/
    RESOURCELOAD(1),
    SHAREPAGE(2),
    COSMETOLOGIST(3),
    OPENAPP(4),
    FORWARDINGAPP(5),
    ASTERISKAPP(6),
    APPOINTMENT(7);
    private int evevtId;

}
