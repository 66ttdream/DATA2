package data.repository.model;

import data.entity.AppointmentNum;
import data.repository.dataanalyze.ContentRepository;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IAppointmentNum {
    @Column
    int contentId();
    @Column
    int AppointmentNum();
    public static AppointmentNum toDomain(IAppointmentNum iAppointmentNum) {
        return AppointmentNum.builder()
                .contentName(ContentRepository.findContentById(iAppointmentNum.contentId()))
                .AppointmentNum(iAppointmentNum.AppointmentNum())
                .build();
    }

}
