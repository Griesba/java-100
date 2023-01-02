package com.griesba.bank.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class AccountStatement {
    private final String operation;
    private final Instant date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public AccountStatement(String operation, Instant date, BigDecimal amount, BigDecimal balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatement that = (AccountStatement) o;
        return Objects.equals(operation, that.operation)
                && Objects.equals(LocalDate.ofInstant(date, ZoneId.systemDefault()), LocalDate.ofInstant(that.date, ZoneId.systemDefault()))
                && Objects.equals(amount, that.amount) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, date, amount, balance);
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "operation='" + operation + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
