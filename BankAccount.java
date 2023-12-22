package Assignment4;

import java.util.InputMismatchException;

public class BankAccount {
    private final String name; // your name
    private double balance; // current amount of money you save in the bank account
    private final static double depositLimit = 500;
    private final static double withdrawLimit = 500;

    /** constructor */
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    /** constructor */
    public BankAccount(String name) {
        this(name,0);
    }

    /** return balance */
    public double getBalance() {
        return balance;
    }

    /** return name */
    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + " , " + "balance: " + balance ;
    }

    /** deposit money into the account */
    public void deposit(double depositAmount) throws InvalidAmountException, DepositLimitException{
            if (depositAmount < 0) {
                throw new InvalidAmountException();
            } else if (depositAmount > depositLimit){
                throw new DepositLimitException();
            } else {
                balance += depositAmount;
                System.out.println(name + " deposit " + depositAmount + " , new balance: " + balance);
            }
    }
    /** withdraw money from the account */
    public void withdraw(double withdrawAmount){
        try{
            if (withdrawAmount < 0) {
                throw new InvalidAmountException();
            } else if (withdrawAmount > withdrawLimit){
                throw new WithdrawLimitException();
            } else if ((balance - withdrawAmount) < 0){
                throw new NotEnoughBalanceException();
            } else {
                balance -= withdrawAmount;
                System.out.println(name + " withdraw " + withdrawAmount + " , new balance: " + balance);
            }
        }catch (InvalidAmountException e){
            System.out.println(e.getMessage());
        }catch (WithdrawLimitException e){
            System.out.println(e.getMessage());
        }catch (NotEnoughBalanceException e){
            System.out.println(e.getMessage());
        }

    }
}
 class BankAccountException extends Exception{
    public BankAccountException(){
        super("BankAccount does not exist");
    }

    public BankAccountException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
 class InvalidAmountException extends BankAccountException{
    public InvalidAmountException(){
        super("Amount is invalid.");
    }

    public InvalidAmountException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}

 class NotEnoughBalanceException extends BankAccountException{
    public NotEnoughBalanceException(){
        super("Balance is not enough.");
    }

    public NotEnoughBalanceException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}

 class WithdrawLimitException extends BankAccountException{
    public WithdrawLimitException(){
        super("Withdraw amount exceeds the limit.");
    }

    public WithdrawLimitException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}

 class DepositLimitException extends BankAccountException {
    public DepositLimitException() {
        super("Deposit amount exceeds the limit.");
    }

    public DepositLimitException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}

