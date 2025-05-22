package org.example;

public class InternalPaymentService implements PaymentProcessor {
  @Override
  public void processPayment(String account, double amount) {
    System.out.println("Pagamento interno de " + amount + " para " + account);
  }
}

