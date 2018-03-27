import com.thoughtworks.bank.Money;
import com.thoughtworks.bank.NegativeAmountException;
import org.junit.Test;

import java.util.Locale;

public class MoneyTest {
    @Test(expected = NegativeAmountException.class)
    public void checkForNegativeAmount() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), -1000.0);
    }

    @Test
    public void checkForValidAmount() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), 2000);
    }

    @Test(expected = NegativeAmountException.class)
    public void checkInvalidDeduction() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), 2000).deduct(5000);
    }

    @Test
    public void checkValidDeduction() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), 2000).deduct(500);
    }

    @Test(expected = NegativeAmountException.class)
    public void checkInvalidAddition() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), 2000).add(-1000);
    }

    @Test
    public void checkValidAddition() throws NegativeAmountException {
        new Money(new Locale("en", "IN"), 2000).add(1000);
    }
}
