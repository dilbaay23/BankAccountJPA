package be.multimedi.bankapp.repository;

import be.multimedi.bankapp.exception.BankAccountRepositoryException;
import be.multimedi.bankapp.model.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    private static EntityManager em = EmfSingleton.em;

    @Override
    public void save(BankAccount bankAccount) {
        em.getTransaction().begin();
        em.persist(bankAccount);
        em.getTransaction().commit();
    }

    @Override
    public BankAccount findBankAccountById(Long id) {
        BankAccount retrievedBankAccount = em.find(BankAccount.class, id);
        if(retrievedBankAccount == null){
            try {
                throw new BankAccountRepositoryException("No bank account with id " + id + " found");
            } catch (BankAccountRepositoryException e) {
               // System.out.println();
            }
        } else {
            System.out.println("Bank account with id " + id + " found!");
        }
        return retrievedBankAccount;
    }
    @Override
    public void removeBankAccountById(Long id){
        BankAccount retrievedBankAccount = findBankAccountById(id);

        if(retrievedBankAccount!=null){
            em.getTransaction().begin();
            em.remove(retrievedBankAccount);
            em.getTransaction().commit();
            System.out.println("Bank account with id " + id + " deleted successfully!");
        }

    }
    @Override
    public  void removeBankAccount(BankAccount bankAccount){
        BankAccount managedBankAccount = em.merge(bankAccount);
        if(managedBankAccount != null) {
            em.getTransaction().begin();
            em.remove(managedBankAccount);
            em.getTransaction().commit();
            System.out.println("Bank account with id " + managedBankAccount.getId() + " deleted successfully!");
        }
    }

    @Override
    public void updateBalanceForDeposit(BankAccount bankAccount, double deposit) {
        BankAccount managedBankAccount = findBankAccountById(bankAccount.getId());
        BankAccount updatedBankAccount= depositFromAccount(bankAccount, deposit);
        if(managedBankAccount.getBalance()!= updatedBankAccount.getBalance()){
            em.getTransaction().begin();
            managedBankAccount.setBalance(updatedBankAccount.getBalance());
            em.getTransaction().commit();
            System.out.println("Bank account with id " + updatedBankAccount.getId() + " updated successfully!");
        }
    }

    private static BankAccount depositFromAccount(BankAccount bankAccount,double deposit) {
        bankAccount.deposit(deposit);
        return bankAccount;
    }
    @Override
    public void updateBalanceForWithdrawal(BankAccount bankAccount, double deposit) {
        BankAccount managedBankAccount = findBankAccountById(bankAccount.getId());
        BankAccount updatedBankAccount= withdrawalFromAccount(bankAccount, deposit);
        if(managedBankAccount.getBalance()!= updatedBankAccount.getBalance()){
            em.getTransaction().begin();
            managedBankAccount.setBalance(updatedBankAccount.getBalance());
            em.getTransaction().commit();
            System.out.println("Bank account with id " + updatedBankAccount.getId() + " updated successfully!");
        }
    }
    private static BankAccount withdrawalFromAccount(BankAccount bankAccount,double deposit) {
        bankAccount.withdrawal(deposit);
        return bankAccount;
    }

    @Override
    public List<BankAccount> retrieveAll() {
        TypedQuery<BankAccount> query = em.createQuery("SELECT b FROM BankAccount b", BankAccount.class);
        return query.getResultList();
    }

    @Override
    public List<BankAccount> retrieveBankAccountsWithMinBalance(double minBalance) {
        TypedQuery<BankAccount> query = em.createQuery("SELECT b FROM BankAccount b WHERE b.balance > :minBalanceValue", BankAccount.class);
        query.setParameter("minBalanceValue", minBalance);
        return query.getResultList();
    }


}
