package be.multimedi.bankapp.service;

import be.multimedi.bankapp.model.BankAccount;

import java.util.List;

public interface AccountService {

    void save(BankAccount bankAccount);

    BankAccount findBankAccountById(Long id);

    void removeBankAccountById(Long id);

    void removeBankAccount(BankAccount bankAccount);

    void updateBalanceForDeposit(BankAccount bankAccount, double deposit);

    void updateBalanceForWithdrawal(BankAccount bankAccount, double withdrawal);

    List<BankAccount> retrieveAll();

    List<BankAccount> retrieveBankAccountsWithMinBalance(double minBalance);
}
