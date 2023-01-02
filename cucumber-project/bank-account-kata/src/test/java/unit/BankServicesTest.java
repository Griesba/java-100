package unit;

import com.griesba.bank.adapter.AccountHistoryRepositoryImpl;
import com.griesba.bank.adapter.BankAccountRepositoryImpl;
import com.griesba.bank.domain.Account;
import com.griesba.bank.domain.AccountStatement;
import com.griesba.bank.domain.Client;
import com.griesba.bank.domain.repository.AccountHistoryRepository;
import com.griesba.bank.domain.repository.BankAccountRepository;
import com.griesba.bank.usecases.BankServices;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;


public class BankServicesTest {

    private final BankAccountRepository bankAccountRepository = new BankAccountRepositoryImpl();
    private final Client clientPaul = new Client("abc", "Paul", "Thomas");
    private final AccountHistoryRepository accountHistoryRepository = new AccountHistoryRepositoryImpl();

    @Test
    void shouldSaveClientMoney() {
        Account accountPaul = initClientAccount(clientPaul, "123");
        new BankServices(bankAccountRepository, accountHistoryRepository).deposit(accountPaul.getId(), new BigDecimal(1000));
        assertThat(bankAccountRepository.findAll(), hasItem(new Account(accountPaul.getId(), accountPaul.getUserId(), new BigDecimal(1000))));
    }


    @Test
    void shouldRetrievePartOfClientMoney() {
        Account accountPaul = initClientAccount(clientPaul, "123");
        new BankServices(bankAccountRepository, accountHistoryRepository).deposit(accountPaul.getId(), new BigDecimal(1000));
        new BankServices(bankAccountRepository, accountHistoryRepository).withdraw(accountPaul.getId(), new BigDecimal(100));
        assertThat(bankAccountRepository.findAll(),
                hasItem(new Account(accountPaul.getId(), accountPaul.getUserId(), new BigDecimal(900))));
    }




    @Nested
    @DisplayName("Statement printing")
    class StatementPrinting {
        @Test
        void shouldListOperationHistory() {
            Account accountPaul = initClientAccount(clientPaul, "123");
            new BankServices(bankAccountRepository, accountHistoryRepository).deposit(accountPaul.getId(), new BigDecimal(1000));
            new BankServices(bankAccountRepository, accountHistoryRepository).withdraw(accountPaul.getId(), new BigDecimal(100));
            new BankServices(bankAccountRepository, accountHistoryRepository).withdraw(accountPaul.getId(), new BigDecimal(600));
            assertThat(accountHistoryRepository.findAll(), hasSize(3));
            assertThat(accountHistoryRepository.findAll(),
                    hasItem(new AccountStatement("WITHDRAW", Instant.now(), new BigDecimal(600), new BigDecimal(300))));
        }
    }

    private Account initClientAccount(Client client, String accountId) {
        Account accountPaul = new Account(accountId, client.getId(), new BigDecimal(0));
        bankAccountRepository.save(accountPaul);
        return accountPaul;
    }

}
