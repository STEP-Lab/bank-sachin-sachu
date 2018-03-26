import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.AccountNumber;
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
        account = new Account(new AccountNumber("1234-1234"), 4444.0);
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
        new Account(new AccountNumber("1111-1111"), 500);
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkDebitForInvalidAmount() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1212-4343"),4444.0).debit(5000.0);
    }

    @Test
    public void checkWithdrawForValidAmount() throws MinimumBalanceException, InvalidAccountNumberException {
        Account acc = new Account(new AccountNumber("1212-3434"), 4444.0);
        acc.debit(444.0);
        assertThat(acc.getBalance(), is((double) 4000));
    }
}
