package data.repository.model;

import data.analyzeentity.ShareNum;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IShareNum {
    @Column
    int contentid();
    @Column(value = "times")
    long sharTime();
    public static ShareNum toDomain(IShareNum iShareNum){
        return ShareNum.builder()
                .contentName(ContentRepository.findContentById(iShareNum.contentid()))
                .shareTime((int)iShareNum.sharTime())
                .build();
    }
}
