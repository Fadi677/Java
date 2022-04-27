public class TestBankAccount {
    public static void main(String[] args){

        BankAccount myAccount=new BankAccount(800,1000);
        myAccount.depositMoney(200, 0);
        myAccount.withdrawMoney(100);
        myAccount.getAccountBalance();

    }
}
