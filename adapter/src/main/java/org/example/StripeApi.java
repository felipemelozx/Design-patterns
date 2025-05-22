package org.example;

public class StripeApi {
  public void makePayment(String email, int cents) {
    System.out.println("Stripe: Pagando " + cents + " centavos para " + email);
  }
}