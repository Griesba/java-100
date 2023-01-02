package com.griesba.bank.domain.repository;

import com.griesba.bank.domain.AccountStatement;

import java.util.Set;

public interface AccountHistoryRepository {
    Set<AccountStatement> findAll();

    void save(AccountStatement accountStatement);
}
