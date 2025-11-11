package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.BankAccount;

public class ExtendedStrictBankAccount extends SimpleBankAccount{

    private static final double TRANSACTION_FEE = 0.1;

    private int transactions;

    public ExtendedStrictBankAccount(int id, double balance) {
        super(id, balance);
        this.transactions = 0;
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
    public void withdraw(final int id, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }
    

    /**
    simple withdraw
    public void withdraw(final int id, final double amount) {

         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde

        this.transactionOp(id, -amount);
    }

    //strict withdraw
    public void withdraw(final int id, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }
     */







}
