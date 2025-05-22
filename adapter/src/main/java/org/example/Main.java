package org.example;

public class Main {
  public static void main(String[] args) {
    PaymentProcessor internal = new InternalPaymentService();
    PaymentService service1 = new PaymentService(internal);
    service1.pay("cliente@dominio.com", 100.0);

    StripeApi stripeApi = new StripeApi();
    PaymentProcessor stripeAdapter = new StripeAdapter(stripeApi);
    PaymentService service2 = new PaymentService(stripeAdapter);
    service2.pay("cliente@dominio.com", 250.5);
  }
}