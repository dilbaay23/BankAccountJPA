package be.multimedi.bankapp.repository;

import be.multimedi.bankapp.exception.BankAccountRepositoryException;
import be.multimedi.bankapp.model.BankAccount;

import java.util.List;

public interface AccountRepository {

    void save(BankAccount bankAccount);

    BankAccount findBankAccountById(Long id);

    void removeBankAccountById(Long id);

    void removeBankAccount(BankAccount bankAccount);

    void updateBalanceForDeposit(BankAccount bankAccount, double deposit);

    void updateBalanceForWithdrawal(BankAccount bankAccount, double deposit);

    List<BankAccount> retrieveAll();

    List<BankAccount> retrieveBankAccountsWithMinBalance(double minBalance);
}
