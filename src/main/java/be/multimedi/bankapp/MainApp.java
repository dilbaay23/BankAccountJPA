package be.multimedi.bankapp;

import be.multimedi.bankapp.model.BankAccount;
import be.multimedi.bankapp.repository.EmfSingleton;
import be.multimedi.bankapp.service.AccountService;
import be.multimedi.bankapp.service.AccountServiceImpl;

import java.util.List;

public class MainApp {
 private static final AccountService accountService = new AccountServiceImpl();

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(1L);
        bankAccount.setIban("BE33 2222 2222 2222");
        bankAccount.setOwnerFullName("Beck Ars");
        bankAccount.setBalance(3_000_000);

       // accountService.save(bankAccount);
       // accountService.removeBankAccountById(5L);
       // accountService.removeBankAccount(bankAccount);
       // accountService.updateBalanceForDeposit(bankAccount,550);
       // accountService.updateBalanceForWithdrawal(bankAccount,1_255_000);
//        List<BankAccount> bankAccounts = accountService.retrieveAll();
//        bankAccounts.forEach(System.out::println);
        System.out.println("***************************");

        List<BankAccount> accountsMoreThanTwoMillion =  accountService.retrieveBankAccountsWithMinBalance(2000000);
        accountsMoreThanTwoMillion.forEach(System.out::println);

        EmfSingleton.close();


    }




}
