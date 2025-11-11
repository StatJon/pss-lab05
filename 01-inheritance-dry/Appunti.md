## Interface BankAccount
    withdraw
    deposit
    depositFromATM
    withdrawFromATM
    chargeManagementFees
    getBalance
    getTransactionsCount

## SimpleBankAccount
    getBalance (I)
    setBalance 
    getTransactionsCount (I)
    getid
    chargeManagementFees (I)
    deposit (I)
    depositFromATM (I)
    withdraw (I)
    withdrawFromATM (I)
    checkUser
    incrementTransactions
    resetTransactions
    transactionOp

## **StrictBankAccount vs SimpleBankAccount**

ATM_TRANSACTION_FEE
MANAGEMENT_FEE
TRANSACTION_FEE *mancante*

StrictBankAccount *sost* SimpleBankAccount
    aggiunge this.transactions

