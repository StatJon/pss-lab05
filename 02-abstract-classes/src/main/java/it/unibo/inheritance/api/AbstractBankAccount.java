package it.unibo.inheritance.api;


import it.unibo.inheritance.impl.SimpleBankAccount;

abstract class AbstractBankAccount implements BankAccount {

    //variables
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    //constructor
    public AbstractBankAccount(final AccountHolder accountHolder, final double balance) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }


    //getters-setters
    @Override
    public double getBalance() {
        return this.balance;
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    @Override
    public int getTransactionsCount() {
        return this.transactions;
    }

    protected void resetTransactions() {
        this.transactions = 0;
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    @Override
    public AccountHolder getAccountHolder() {
        return holder;
    }


    //booleans
    protected boolean isWithdrawAllowed(final double amount) {
        return getBalance() > amount;
    }

    protected boolean checkUser(final int id) {
        return this.getAccountHolder().getUserID() == id;
    }


    //methods
    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    @Override
    public void chargeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }

    @Override
    public void deposit(final int id, final double amount) {
        this.transactionOp(id, amount);
    }

    @Override
    public void depositFromATM(final int id, final double amount) {

        this.deposit(id, amount - ATM_TRANSACTION_FEE);
    }
    public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.withdraw(usrID, amount);
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        this.withdraw(id, amount + ATM_TRANSACTION_FEE);
    }





}
