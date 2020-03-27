package data.repository.model;

import data.entity.TerminalNum;
import org.davidmoten.rx.jdbc.annotations.Column;

public interface ITerminalNum{
    @Column(value = "terminalManufacturers")
    String terminalManufacturers();
    @Column(value = "terminalNumber")
    String terminalNumber();
    @Column(value = "terminalSum")
    long terminalSum();
    public static TerminalNum toDomain(ITerminalNum iTerminalNum){
        return TerminalNum.builder()
                .terminalManufacturers(iTerminalNum.terminalManufacturers())
                .terminalSum((int)iTerminalNum.terminalSum())
                .terminalNumber(iTerminalNum.terminalNumber())
                .build();
    }
}
