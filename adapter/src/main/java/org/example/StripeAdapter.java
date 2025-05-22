package org.example;

public class StripeAdapter implements PaymentProcessor {
  private final StripeApi stripeApi;

  public StripeAdapter(StripeApi stripeApi) {
    this.stripeApi = stripeApi;
  }

  @Override
  public void processPayment(String account, double amount) {
    int cents = (int) (amount * 100); // conversão para centavos
    stripeApi.makePayment(account, cents);
  }
}
