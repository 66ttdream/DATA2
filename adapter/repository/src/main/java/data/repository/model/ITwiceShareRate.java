package data.repository.model;

import data.analyzeentity.TwiceShareRate;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;


public interface ITwiceShareRate {
    @Column
    int contentId();
    @Column(value = "shareNum")
    long shareNum();
    @Column(value = "twicehareNum")
    long twicehareNum();
    public static TwiceShareRate toDomain(ITwiceShareRate iTwiceShareRate){
        return TwiceShareRate.builder()
                .shareNum((int)iTwiceShareRate.shareNum())
                .twiceShareNum((int)iTwiceShareRate.twicehareNum())
                .contentName(ContentRepository.findContentById(iTwiceShareRate.contentId()))
                .build();
    }
}
