public class BankAccount{

    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts;
    private static double totalAmountStored;

    public BankAccount(){
        numberOfAccounts++;
    }

    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        numberOfAccounts++;
        totalAmountStored+=(checkingBalance+savingsBalance);
    }

    public double getAccountBalance(){
        return checkingBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void depositMoney(double checkingBalanceDeposit, double savingsBalanceDeposit){
        if(checkingBalanceDeposit>0){
            this.checkingBalance+=checkingBalance;
            totalAmountStored+=checkingBalance;
            System.out.println("Checking Balance Account: "+this.checkingBalance);
            System.err.println("Total Amount Stored: "+totalAmountStored);
        }
        else if(savingsBalanceDeposit>0){
            this.savingsBalance+=savingsBalanceDeposit;
            totalAmountStored+=savingsBalanceDeposit;
            System.out.println("Savings Balance Account: "+this.savingsBalance);
            System.err.println("Total Amount Stored: "+totalAmountStored);
        }
    }

    public void withdrawMoney(double withdrawAmount){
        if(withdrawAmount<=this.checkingBalance){
            this.checkingBalance-=withdrawAmount;
            System.out.println("Amount of Money Withdrown: "+withdrawAmount);
            System.out.println("New Checking Account Balance: "+this.checkingBalance);
        }
        else{
            System.out.println("Insufficient Funds");
        }
    }

    public double getTotalBalance(){
        double total=this.checkingBalance+this.savingsBalance;
        return total;
    }

}