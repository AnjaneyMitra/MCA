public class BankAcc {
    private String accountNumber;
    private double balance;

    // Constructor for BankAcc
    public BankAcc(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Instance Inner Class
    public class AccountDetails {
        public void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    // Static Inner Class (for loan calculations)
    public static class LoanCalculator {
        private static final double INTEREST_RATE = 0.05; // 5%

        public static double calculateLoan(double principal, int years) {
            return principal * Math.pow(1 + INTEREST_RATE, years);
        }
    }

    // Local Inner Class inside a method for handling transactions
    public void performTransaction(String transactionType, double amount) {
        // Local Inner Class
        class Transaction {
            void deposit() {
                balance += amount;
                System.out.println("Deposited $" + amount + ". New balance: $" + balance);
            }

            void withdraw() {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
                } else {
                    System.out.println("Insufficient funds!");
                }
            }
        }

        // Instantiate and use the local inner class based on transaction type
        Transaction transaction = new Transaction();
        if (transactionType.equalsIgnoreCase("deposit")) {
            transaction.deposit();
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            transaction.withdraw();
        } else {
            System.out.println("Invalid transaction type");
        }
    }

    // Anonymous Inner Class to generate a one-time statement
    public void generateStatement() {
        Runnable statementGenerator = new Runnable() {
            @Override
            public void run() {
                System.out.println("Generating statement for account: " + accountNumber);
                System.out.println("Current balance: $" + balance);
            }
        };
        statementGenerator.run();
    }

    public static void main(String[] args) {
        // Create a bank account
        BankAcc account = new BankAcc("123456789", 500.0);

        // Accessing the instance inner class
        BankAcc.AccountDetails details = account.new AccountDetails();
        details.displayAccountInfo();

        // Using the static inner class for loan calculation
        double loanAmount = BankAcc.LoanCalculator.calculateLoan(10000, 5);
        System.out.println("Loan amount after 5 years: $" + loanAmount);

        // Performing transactions with the local inner class
        account.performTransaction("deposit", 200.0);
        account.performTransaction("withdraw", 100.0);

        // Generating a statement with an anonymous inner class
        account.generateStatement();
    }
}