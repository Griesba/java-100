package com.griesba.bank.usecases;

import com.griesba.bank.domain.Account;
import com.griesba.bank.domain.AccountStatement;
import com.griesba.bank.domain.repository.AccountHistoryRepository;
import com.griesba.bank.domain.repository.BankAccountRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.NoSuchElementException;

public class BankServices {
    private final BankAccountRepository bankAccountRepository;
    private final AccountHistoryRepository accountHistoryRepository;

    public BankServices(BankAccountRepository bankAccountRepository, AccountHistoryRepository accountHistoryRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountHistoryRepository = accountHistoryRepository;
    }

    public void deposit(String accountId, BigDecimal amount) {
        Account account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("No account found with id : " + accountId))
                .deposit(amount);
        AccountStatement accountStatement = new AccountStatement("DEPOSIT", Instant.now(), amount, account.getBalance());
        accountHistoryRepository.save(accountStatement);
    }

    public void withdraw(String accountId, BigDecimal amount) {
        Account account = bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("No account found with id : " + accountId))
                .withdraw(amount);
        AccountStatement accountStatement = new AccountStatement("WITHDRAW", Instant.now(), amount, account.getBalance());
        accountHistoryRepository.save(accountStatement);
    }
}
