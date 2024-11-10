package Tasks3_3;

public class BankAccount {

    private int accountNumber;
    private long balance;
    private static int totalAccounts;
    private static int nextAccountNumber = 5341;


    public BankAccount(long balance) {
        this.accountNumber = nextAccountNumber++;
        this.balance = balance;   
        totalAccounts ++;     
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            System.out.println("The amount is larger than the balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public long getBalance() {
        return balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
