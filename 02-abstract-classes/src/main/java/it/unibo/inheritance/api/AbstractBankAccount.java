package it.unibo.inheritance.api;


abstract class AbstractBankAccount implements BankAccount {

    //variables
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    //constructor
    public AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }


    @Override
    void chargeManagementFees(int id){

    };

    void deposit(int id, double amount);

    void depositFromATM(int id, double amount);

    AccountHolder getAccountHolder();

    double getBalance();

    int getTransactionsCount();

    void withdraw(int id, double amount);

    void withdrawFromATM(int id, double amount);

    protected boolean isWithdrawAllowed(final double amount) {
        return getBalance() > amount;
    }
    


}
