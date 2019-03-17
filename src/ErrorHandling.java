import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ErrorHandling{
    private static final Logger log = Logger.getLogger(ErrorHandling.class.getName());
    public static void main(String args[])
    {
        int bankBalance,numOftransactions;
        String accountNumber;
        Scanner sc=new Scanner(System.in);
        log.info("Enter balance, number of transactions, account number");
        bankBalance=sc.nextInt();
        numOftransactions=sc.nextInt();
        accountNumber=sc.next();
        try
        {
            verifyBankDetails(bankBalance,numOftransactions,accountNumber);
        }
        catch(MinimumBalanceException | MaximumTransactionsException | InvalidAccountNumberException s) {
            log.info("Exception caught");
        }
        finally{
            log.info("finally block is executed");
        }
    }

    static void verifyBankDetails(int bankBalance, int numOftransactions, String accountNumber)throws MinimumBalanceException, MaximumTransactionsException, InvalidAccountNumberException
    {
        final String regex= "[0-9]{9,18}";

        if(bankBalance<3000)
        {

            throw new MinimumBalanceException();
        }
        if(numOftransactions>5)
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

/*
*-: TestCases :-
*
* TestCase:1
* Enter balance, number of transactions, account number
* 3000 4 4567234577
Mar 18, 2019 2:01:28 AM ErrorHandling main
INFO: finally block is executed

* TestCase:2
* Enter balance, number of transactions, account number
* 2000 4 4567234577
Mar 18, 2019 2:03:23 AM MinimumBalanceException <init>
INFO: Bank balance is less than minimum amount
Mar 18, 2019 2:03:23 AM ErrorHandling main
INFO: Exception caught
Mar 18, 2019 2:03:23 AM ErrorHandling main
INFO: finally block is executed
*
*TestCase:3
* Enter balance, number of transactions, account number
* 3000 6 4567234577
Mar 18, 2019 2:05:11 AM MaximumTransactionsException <init>
INFO: No of transactions per day exceeded
Mar 18, 2019 2:05:11 AM ErrorHandling main
INFO: Exception caught
Mar 18, 2019 2:05:11 AM ErrorHandling main
INFO: finally block is executed
*
* TestCase:4
* Enter balance, number of transactions, account number
* 3000 6 45672
Mar 18, 2019 2:06:31 AM InvalidAccountNumberException <init>
INFO: Account number invalid
Mar 18, 2019 2:06:31 AM ErrorHandling main
INFO: Exception caught
Mar 18, 2019 2:06:31 AM ErrorHandling main
INFO: finally block is executed
*
 */