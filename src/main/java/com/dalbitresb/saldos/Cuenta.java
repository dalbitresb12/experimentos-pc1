package com.dalbitresb.saldos;

public class Cuenta {
  private int saldo;
  private String contra;

  // Constructor
  public Cuenta(int saldoini, String cc) {
    saldo = saldoini;
    contra = cc;
  }

  // Receptor de dinero
  public int deposita(int monto) {
    saldo += monto;
    return saldo;
  }

  // Retira si la contraseña coincide y hay fondos
  public int retira(int monto, String cc) {
    if (verificaContra(cc)) {
      if (saldo >= monto) {
        return monto;
      } else {
        return -1;
      }
    } else {
      return -2;
    }
  }

  // Esto lo añadí para poder añadir mocking, aunque sea
  // sencillo por ahora, tal vez en un futuro el manejo
  // de la contraseña podría ser más complejo y podría
  // requerir mocking de un posible sistema de auth.
  public boolean verificaContra(String cc) {
    return contra.equals(cc);
  }

  // Verifica saldo
  public int dimeSaldo() {
    return saldo;
  }

  // Verifica contraseña
  public String dimeContra() {
    return contra;
  }
}
