import com.thoughtworks.bank.CreditTransaction;
import com.thoughtworks.bank.DebitTransaction;
import com.thoughtworks.bank.Transactions;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void mustRecordDebitTransaction() {
        Date date = new Date();
        transactions.debit(date, 1000, "Other account");
        assertThat(transactions.list, hasItem(new DebitTransaction(date, 1000, "Other account")));
    }

    @Test
    public void mustRecordCreditTransaction() {
        Date date = new Date();
        transactions.credit(date, 1000, "Other account");
        assertThat(transactions.list, hasItem(new CreditTransaction(date, 1000, "Other account")));
    }

    @Test
    public void mustRecordCreditAndDebitTransactions() {
        Date dateOfCredit = new Date();
        Date dateOfDebit = new Date();
        transactions.credit(dateOfCredit, 1000, "Other account");
        transactions.debit(dateOfDebit, 500, "Other account");
        CreditTransaction credit = new CreditTransaction(dateOfCredit, 1000, "Other account");
        DebitTransaction debit = new DebitTransaction(dateOfDebit, 500, "Other account");
        assertThat(transactions.list, hasItems(credit, debit));
    }

    @Test
    public void printTransactions() throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<String> result = new ArrayList<>();
        Date dateOfCredit = new Date();
        Date dateOfDebit = new Date();
        transactions.credit(dateOfCredit, 1000, "Person 1");
        CreditTransaction credit = new CreditTransaction(dateOfCredit, 1000, "Person 1");
        transactions.debit(dateOfDebit, 500, "Person 2");
        DebitTransaction debit = new DebitTransaction(dateOfDebit, 500, "Person 2");
        PrintWriter writer;
        writer = new PrintWriter("the-file-name.txt", "UTF8"){
            @Override
            public void println(String x) {
                result.add(x);
            }
        };
        transactions.print(writer);
        writer.close();
        assertThat(result, hasItems(debit.toString(), credit.toString()));
    }

    @Test
    public void filterTransactionsByAmount() {
        Date credit1Date = new Date();
        Date debit1Date = new Date();
        Date credit2Date = new Date();
        transactions.credit(credit1Date, 1000, "Person 1");
        transactions.debit(debit1Date, 200, "Person 2");
        transactions.credit(credit2Date, 400, "Person 1");
        CreditTransaction expectedCredit1 = new CreditTransaction(credit1Date, 1000, "Person 1");
        Transactions filteredTransactions = transactions.filterByAmountGreaterThan(500);
        assertThat(filteredTransactions.list, hasItems(expectedCredit1));
    }

    @Test
    public void filterCreditTransactions() {
        Date credit1Date = new Date();
        Date debit1Date = new Date();
        Date credit2Date = new Date();
        transactions.credit(credit1Date, 2000, "Person 1");
        transactions.debit(debit1Date, 200, "Person 2");
        transactions.credit(credit2Date, 400, "Person 1");
        CreditTransaction expectedCredit1 = new CreditTransaction(credit1Date, 2000, "Person 1");
        CreditTransaction expectedCredit2 = new CreditTransaction(credit2Date, 400, "Person 1");
        Transactions filteredTransactions = transactions.filterCredit();
        assertThat(filteredTransactions.list, hasItems(expectedCredit1, expectedCredit2));
    }

    @Test
    public void filterDebitTransactions() {
        Date credit1Date = new Date();
        Date debit1Date = new Date();
        Date credit2Date = new Date();
        transactions.credit(credit1Date, 3000, "Person 1");
        transactions.debit(debit1Date, 200, "Person 2");
        transactions.credit(credit2Date, 400, "Person 1");
        DebitTransaction expectedDebit1 = new DebitTransaction(debit1Date, 200, "Person 2");
        Transactions filteredTransactions = transactions.filterDebit();
        assertThat(filteredTransactions.list, hasItems(expectedDebit1));
    }
}
