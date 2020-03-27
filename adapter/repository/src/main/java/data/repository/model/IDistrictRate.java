package data.repository.model;

import data.entity.DistrictRate;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface IDistrictRate {
    @Column(value = "district")
    String district();
    @Column(value = "num")
    long num();
    public static DistrictRate toDomain(IDistrictRate iDistrictRate){
        return DistrictRate.builder()
                .district(iDistrictRate.district())
                .number((int)iDistrictRate.num())
                .build();
    }
}
