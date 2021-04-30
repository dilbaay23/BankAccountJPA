package be.multimedi.bankapp.service;

import be.multimedi.bankapp.model.BankAccount;
import be.multimedi.bankapp.repository.AccountRepository;
import be.multimedi.bankapp.repository.AccountRepositoryImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService{

    private static final AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public void save(BankAccount bankAccount) {
        accountRepository.save(bankAccount);
    }

    @Override
    public BankAccount findBankAccountById(Long id) {

        return accountRepository.findBankAccountById(id);
    }

    @Override
    public void removeBankAccountById(Long id) {
        accountRepository.removeBankAccountById(id);
    }

    @Override
    public void removeBankAccount(BankAccount bankAccount) {
        accountRepository.removeBankAccount(bankAccount);
    }

    @Override
    public void updateBalanceForDeposit(BankAccount bankAccount, double deposit) {
            accountRepository.updateBalanceForDeposit(bankAccount, deposit);

    }

    @Override
    public void updateBalanceForWithdrawal(BankAccount bankAccount, double deposit) {
        accountRepository.updateBalanceForWithdrawal(bankAccount, deposit);
    }

    @Override
    public List<BankAccount> retrieveAll() {
        List<BankAccount> accounts= accountRepository.retrieveAll();
        if(accounts.size()==0){
            System.out.println("There is no Account");
        }
      return accounts;
    }

    @Override
    public List<BankAccount> retrieveBankAccountsWithMinBalance(double minBalance) {
        List<BankAccount> accounts= accountRepository.retrieveBankAccountsWithMinBalance(minBalance);
        if(accounts.size()==0){
            System.out.println("There is no Account");
        }
        return accounts;
    }


}
