package be.multimedi.bankapp.exception;

public class BankAccountRepositoryException extends RuntimeException {


    public BankAccountRepositoryException(String s) {
        super(s);
        System.out.println(s);
    }

    /*@Override
    public String getMessage() {
        return super.getMessage();
    }*/
}
