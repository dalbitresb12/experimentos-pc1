package com.dalbitresb.saldos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetirarTest {
  private static final int initialBalance = 100;
  private static final String password = "abc";
  private Cuenta cuenta;

  @BeforeEach
  public void setupTest() {
    cuenta = new Cuenta(initialBalance, password);
  }

  /**
   * Añadí la función verificaContra para poder añadir mocking,
   * aunque sea sencillo por ahora, tal vez en un futuro el manejo
   * de la contraseña podría ser más complejo y podría
   * requerir mocking de un posible sistema de auth.
   * 
   * {@link com.dalbitresb.saldos.Cuenta#verificaContra(String)}
   */
  @Test
  public void noPermiteRetirarSinDineroSuficiente() {
    final int expected = -1;

    Cuenta spyCuenta = spy(cuenta);
    doReturn(true).when(spyCuenta).verificaContra(password);

    final int result = cuenta.retira(150, password);
    assertEquals(expected, result);
  }

  @Test
  public void noPermiteRetirarDineroConMocking() {
    final int expected = -2;

    Cuenta spyCuenta = spy(cuenta);
    doReturn(false).when(spyCuenta).verificaContra(anyString());

    final int result = spyCuenta.retira(50, "");
    assertEquals(expected, result);
  }

  @Test
  public void permiteRetirarDineroIntegracion() {
    final int amountToWithdraw = 50;
    final int expected = initialBalance - amountToWithdraw;

    final int result = cuenta.retira(amountToWithdraw, password);
    assertEquals(expected, result);
  }
}
