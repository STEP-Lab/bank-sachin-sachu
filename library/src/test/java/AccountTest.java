import com.thoughtworks.bank.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException, NegativeAmountException {
        Locale locale = new Locale("en", "IN");
        account = new Account(new Money(locale, 4444.0), new AccountNumber("1234-1234"));
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(), is(4444.0));
    }

    @Test
    public void checkAccountNumber() {
        assertThat(account.getAccountNumber(), is("1234-1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException, NegativeAmountException {
        Locale locale = new Locale("en", "IN");
        new Account(new Money(locale, 500), new AccountNumber("1111-1111"));
    }

    @Test(expected = NegativeAmountException.class)
    public void checkDebitForInvalidAmount() throws InvalidAccountNumberException, NegativeAmountException, MinimumBalanceException {
        Locale locale = new Locale("en", "IN");
        new Account(new Money(locale, 4444), new AccountNumber("1212-4343")).debit(5000.0, "Other account");
    }

    @Test
    public void checkDebitForValidAmount() throws MinimumBalanceException, InvalidAccountNumberException, NegativeAmountException {
        Locale locale = new Locale("en", "IN");
        Account acc = new Account(new Money(locale, 4444), new AccountNumber("1212-3434"));
        acc.debit(444.0, "Other account");
        assertThat(acc.getBalance(), is((double) 4000));
    }

    @Test
    public void checkCreditForValidAmount() throws InvalidAccountNumberException, MinimumBalanceException, NegativeAmountException {
        Locale locale = new Locale("en", "IN");
        Account acc = new Account(new Money(locale, 4000), new AccountNumber("1212-3434"));
        acc.credit(1000, "Other account");
        assertThat(acc.getBalance(), is((double) 5000));
    }
}
