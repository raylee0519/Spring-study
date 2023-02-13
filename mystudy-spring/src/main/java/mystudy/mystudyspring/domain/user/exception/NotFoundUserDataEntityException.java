package mystudy.mystudyspring.domain.user.exception;

import mystudy.mystudyspring.global.exception.BaseException;

public class NotFoundUserDataEntityException extends BaseException {

    public NotFoundUserDataEntityException(){
        super("Not Found UserData Entity");
    }
}
