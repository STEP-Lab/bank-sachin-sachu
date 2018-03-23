import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account("1234-1234", 4444.0);
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
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1111-1111", 500);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkInvalidAccountNumber() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("111-111", 7000);
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkWithdraw() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1212-4343",4444.0).withdraw(5000.0);
    }

    @Test
    public void checkWithdrawForMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        Account acc = new Account("1212-3434", 4444.0);
        acc.withdraw(444.0);
        assertThat(acc.getBalance(), is((double) 4000));
    }
}
