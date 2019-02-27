import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ErrorHandling{
    private static final Logger log = Logger.getLogger(ErrorHandling.class.getName());
    public static void main(String args[])
    {
        int bankBalance,transactions;
        String accountNumber;
        Scanner sc=new Scanner(System.in);
        log.info("Enter balance,number of transactions,account number");
        bankBalance=sc.nextInt();
        transactions=sc.nextInt();
        accountNumber=sc.next();
        try
        {
            verifyBankDetails(bankBalance,transactions,accountNumber);
        }
        catch(MinimumBalanceException | MaximumTransactionsException | InvalidAccountNumberException s) {
            log.info("Exception caught");
        }
        finally{
            log.info("finally block is executed");
        }
    }
    
    static void verifyBankDetails(int bankBalance, int transactions, String accountNumber)throws MinimumBalanceException, MaximumTransactionsException, InvalidAccountNumberException
    {
        final String regex= "[0-9]{9,18}";

        if(bankBalance<3000)
        {

            throw new MinimumBalanceException();
        }
        if(transactions>5)
        {

            throw new MaximumTransactionsException();
        }
       if (!Pattern.matches(regex, accountNumber))
        {

            throw new InvalidAccountNumberException();
        }

    }
}

class MinimumBalanceException extends Exception{

    private static final Logger log = Logger.getLogger(MinimumBalanceException.class.getName());
    MinimumBalanceException()
    {
        log.info("Bank balance is less than minimum amount");
    }
}

class MaximumTransactionsException extends Exception{
    private static final Logger log = Logger.getLogger(MaximumTransactionsException.class.getName());
    MaximumTransactionsException()
    {
        log.info("No of transactions per day exceeded");
    }
}
class InvalidAccountNumberException extends Exception{
    private static final Logger log = Logger.getLogger(InvalidAccountNumberException.class.getName());
    InvalidAccountNumberException()
    {
        log.info("Account number invalid");
    }
}

