import com.thoughtworks.bank.Account;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void checkBalance() {
        Account account = new Account("1212-1212", 4444);
        assertThat(account.getBalance(), is(4444));
    }

}
