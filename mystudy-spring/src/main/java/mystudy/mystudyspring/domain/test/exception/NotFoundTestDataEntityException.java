package mystudy.mystudyspring.domain.test.exception;

import mystudy.mystudyspring.global.exception.BaseException;

public class NotFoundTestDataEntityException extends BaseException {

    public NotFoundTestDataEntityException(){
        super("Not Found TestData Entity");
    }
}
