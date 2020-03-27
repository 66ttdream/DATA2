package data.repository.model;

import data.analyzeentity.ShareRate;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IShareRate {
    @Column
    int contentId();
    @Column(value = "viewNum")
    long viewNum();
    @Column(value = "shareNum")
    long shareNum();
    public static ShareRate toDomain(IShareRate iShareRate){
        return ShareRate.builder()
                .shareNum((int)iShareRate.shareNum())
                .viewNum((int)iShareRate.viewNum())
                .contentName(ContentRepository.findContentById(iShareRate.contentId()))
                .build();
    }
}
