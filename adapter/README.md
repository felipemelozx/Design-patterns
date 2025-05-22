### Cenário realista: Integração com sistema de pagamento

**Problema:**

- Sua aplicação usa um serviço interno `InternalPaymentService`, com uma interface simples.

- Agora, você precisa integrar um **novo provedor externo**, por exemplo o **Stripe** ou **PayPal**, que tem uma API completamente diferente.

- Você não quer reescrever seu código. Então, você usa o **[[Adapter]]** para que o novo serviço se comporte como o antigo.


---

### Objetivo:

Fazer com que o novo `StripeApi` seja compatível com a interface `PaymentProcessor` da aplicação.

---

### Estrutura

- **Target (Interface esperada)**: `PaymentProcessor`

- **Adaptee (API externa)**: `StripeApi`

- **Adapter**: `StripeAdapter`

- **Client (sistema interno)**: `PaymentService`

### Código

1. Interface `PaymentProcessor` (Target)

```java
public interface PaymentProcessor {
    void processPayment(String account, double amount);
}
```

2. Serviço legado (implementação original, opcional)

```java
public class InternalPaymentService implements PaymentProcessor {
    @Override
    public void processPayment(String account, double amount) {
        System.out.println("Pagamento interno de " + amount + " para " + account);
    }
}
```

3. Stripe API simulada (Adaptee)
```java
public class StripeApi {
    public void makePayment(String email, int cents) {
        System.out.println("Stripe: Pagando " + cents + " centavos para " + email);
    }
}
```

4. Adapter: `StripeAdapter`
```java
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
```

5. Cliente: `PaymentService`
```java
public class PaymentService {
    private final PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void pay(String account, double amount) {
        processor.processPayment(account, amount);
    }
}

```

6. Main (testando o adapter)
```java
public class Main {
    public static void main(String[] args) {
        // Cenário 1: pagamento interno
        PaymentProcessor internal = new InternalPaymentService();
        PaymentService service1 = new PaymentService(internal);
        service1.pay("cliente@dominio.com", 100.0);

        // Cenário 2: pagamento via Stripe com Adapter
        StripeApi stripeApi = new StripeApi();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeApi);
        PaymentService service2 = new PaymentService(stripeAdapter);
        service2.pay("cliente@dominio.com", 250.5);
    }
}

```

```scss
Pagamento interno de 100.0 para cliente@dominio.com
Stripe: Pagando 25050 centavos para cliente@dominio.com
```
### Possíveis expansões:

- Integrar mais de um adaptador (ex: PayPalAdapter, MercadoPagoAdapter).

- Usar injeção de dependência (Spring) para carregar o adaptador correto.

- Criar testes com mocks usando JUnit e Mockito.