package data.repository.model;

import data.analyzeentity.HeatworkOfUser;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IHeadwork {
    @Column
    int userid();
    @Column(value = "pv")
    long pv();
    public static HeatworkOfUser toDomain(IHeadwork iHeadwork){
        return HeatworkOfUser.builder()
                .contentName(ContentRepository.findContentById(iHeadwork.userid()))
                .pageView((int)iHeadwork.pv())
                .build();
    }
}
