package org.example;

public class PaymentService {
  private final PaymentProcessor processor;

  public PaymentService(PaymentProcessor processor) {
    this.processor = processor;
  }

  public void pay(String account, double amount) {
    processor.processPayment(account, amount);
  }
}

