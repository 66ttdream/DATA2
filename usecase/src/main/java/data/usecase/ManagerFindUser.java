package data.usecase;

import data.usecase.port.IUserAnalyzeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManagerFindUser {
    private IUserAnalyzeRepository iUserAnalyzeRepository;
    public int execut(){
        return iUserAnalyzeRepository.findAllUser();
    }
}
