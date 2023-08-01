package BankingApp;

import java.util.LinkedList;
import java.util.List;

public class BankingAccountApp {
    public static void main(String[] args) {
        String file = "C:\\Users\\Cloud\\BankingApp\\src\\BankingApp\\NewBankAccounts.csv";
        List<Account> accounts = new LinkedList<Account>();

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equalsIgnoreCase("Savings")) {
                accounts.add(new Savings(name,sSN,initDeposit));
            }
            else if (accountType.equalsIgnoreCase("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts) {
            System.out.println("\n******************");
            acc.showInfo();
        }
    }
    }
