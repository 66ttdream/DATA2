package data.usecase.port;

import data.entity.SynParameter;
import data.usecase.exception.AccessTokenException;

public interface AccessTokenGet {
    public String get(SynParameter sp)throws AccessTokenException;
}
