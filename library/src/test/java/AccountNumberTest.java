import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AccountNumberTest {
    @Test
    public void checkForValidNumber() throws InvalidAccountNumberException {
        new AccountNumber("1212-1212");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void checkForInvalidAccountNumber() throws InvalidAccountNumberException {
        new AccountNumber("12-1");
    }

    @Test
    public void checkAccountNumber() throws InvalidAccountNumberException {
        assertThat(new AccountNumber("1212-3434").getAccNumber(), is("1212-3434"));
    }
}
