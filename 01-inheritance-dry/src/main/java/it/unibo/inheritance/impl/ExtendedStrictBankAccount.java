package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.BankAccount;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(int id, double balance) {
        super(id, balance);
        super.resetTransactions();
    }

    private boolean isWithdrawAllowed(final double amount) {
        return getBalance() >= amount;
    }

    //extended
    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            super.setBalance(getBalance() + amount);
            super.incrementTransactions();
        }
    }



    //extended
    @Override
    public void withdraw(final int id, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }



    //extended
    @Override
    public void chargeManagementFees(final int id) {
        final double feeAmount = MANAGEMENT_FEE + super.getTransactionsCount()  * TRANSACTION_FEE;
        if (super.checkUser(id) && this.isWithdrawAllowed(feeAmount)) {
            super.setBalance(getBalance()-feeAmount);
            super.resetTransactions();
        }
    }

}
