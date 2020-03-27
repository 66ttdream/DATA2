package data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalNum {
    private String terminalManufacturers;
    private String terminalNumber;
    private int terminalSum;
}
