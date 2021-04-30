package be.multimedi.bankapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Jpa_bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 19, nullable = false, unique = true)
    private String iban;

    @Column(name = "owner_full_name", length = 90, nullable = false)
    private String ownerFullName;

    @Column(columnDefinition="Decimal(19,2) default '10.00'")
    private double balance;

    public BankAccount(String iban, String ownerFullName, double balance) {
        this.iban = iban;
        this.ownerFullName = ownerFullName;
        this.balance = balance;
    }

    public double withdrawal(double withdrawal){
        if(withdrawal > this.balance){
            System.out.printf("Unable to transfer €%.2f. Balance is insufficient.\n",withdrawal);
            return -1;
        }else if(withdrawal <= 0){
            System.out.println("Transfer amount must be greater than zero. Transfer failed.");
            return -1;
        }else{
            this.balance -= withdrawal;
            System.out.printf("Transfer of €%.2f successful. Your new balance is €%.2f.\n",withdrawal,this.balance);
            return balance;
        }
    }

    public double deposit(double deposit){
        if(deposit <= 0){
            System.out.println("Amount deposited must be greater than zero.");
            return -1;
        }else {
            this.balance += deposit;
            System.out.printf("Deposit of €%.2f successful. Your new balance is €%.2f.\n",deposit,this.balance);
            return balance;
        }
    }


}
