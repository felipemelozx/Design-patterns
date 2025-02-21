package felipemelozx.factory.factory;

import felipemelozx.factory.service.Impl.ApplePagamentoServiceImpl;
import felipemelozx.factory.service.Impl.GooglePagamentoServiceImpl;
import felipemelozx.factory.service.Impl.PaypalPagamentoServiceImpl;
import felipemelozx.factory.service.PagamentoService;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PagamentoFactory {

  public static PagamentoService getPagamento(String metodoPagamento) {
    switch (metodoPagamento.toUpperCase(Locale.ROOT)) {
      case "PAYPAL":
        return new PaypalPagamentoServiceImpl();
      case "GOOGLE":
        return new GooglePagamentoServiceImpl();
      case "APPLE":
        return new ApplePagamentoServiceImpl();
      default:
        throw new IllegalArgumentException("Método de pagamento não configurado.");
    }
  }

}
