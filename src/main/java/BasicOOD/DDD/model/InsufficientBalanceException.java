package BasicOOD.DDD.model;

/**
 * TODO
 *
 * @author Wendong Lei
 * @version 1.0
 * @since 6/9/2021
 **/
public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String error) {
        super(error);
    }
}
