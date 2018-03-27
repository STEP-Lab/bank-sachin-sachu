import com.thoughtworks.bank.CreditTransaction;
import com.thoughtworks.bank.DebitTransaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void shouldCreateDebitTransaction() {
        Date date = new Date();
        DebitTransaction debit = new DebitTransaction(date, 1212, "other account");
        assertThat(debit.getDate(), is(date));
    }

    @Test
    public void shouldCreateCreditTransaction() {
        Date date = new Date();
        CreditTransaction credit = new CreditTransaction(date, 1212, "other account");
        assertThat(credit.getDate(), is(date));
    }
}
