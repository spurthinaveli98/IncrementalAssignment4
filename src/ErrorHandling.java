import java.util.Scanner;


class MinimumBalanceException extends Exception{
    MinimumBalanceException()
    {
        System.out.println("Bank balance is less than minimum amount");
    }
}
class MaximumTransactionsException extends Exception{
    MaximumTransactionsException()
    {
        System.out.println("No of transactions per day exceeded");
    }
}
class InvalidAccountNumberException extends Exception{
    InvalidAccountNumberException()
    {
        System.out.println("Account number invalid");
    }
}

public class ErrorHandling{
    static void verify(int bankbalance, int transactions, String accountnumber)throws MinimumBalanceException, MaximumTransactionsException, InvalidAccountNumberException
    {
        if(bankbalance<3000)
        {

            throw new MinimumBalanceException();
        }
        if(transactions>5)
        {

            throw new MaximumTransactionsException();
        }
        if(accountnumber.length()!=8)
        {

            throw new InvalidAccountNumberException();
        }

    }
    public static void main(String args[]){
        int bal,tran;
        String acc;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter balance, number of transactions, account nuumber");
        bal=sc.nextInt();
        tran=sc.nextInt();
        acc=sc.next();
        try
        {
            verify(bal,tran,acc);
        }
        catch(MinimumBalanceException | MaximumTransactionsException | InvalidAccountNumberException s) {
            System.out.println("Exception caught");
        }
        finally{
            System.out.println("finally block is executed");
        }
    }
}
