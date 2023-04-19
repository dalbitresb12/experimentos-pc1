package com.dalbitresb.saldos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositarTest {
  private static final int initialBalance = 100;
  private Cuenta cuenta;

  @BeforeEach
  public void setupTest() {
    cuenta = new Cuenta(initialBalance, "");
  }

  @Test
  public void depositarAumentaDinero() {
    final int amountToDeposit = 50;
    final int expected = initialBalance + amountToDeposit;

    final int result = cuenta.deposita(amountToDeposit);
    assertEquals(expected, result);
  }
}
