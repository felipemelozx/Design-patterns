package felipemelozx.designpatterns.Service;

import felipemelozx.designpatterns.Service.Strategy.PagamentosStrategy;
import org.springframework.stereotype.Component;

@Component
public class PagamentosContext {

  private PagamentosStrategy pagamentosStrategy;

  public PagamentosContext() {
  }

  public PagamentosContext(PagamentosStrategy pagamentosStrategy) {
    this.pagamentosStrategy = pagamentosStrategy;
  }

  public void setPagamentosStrategy(PagamentosStrategy pagamentosStrategy) {
    this.pagamentosStrategy = pagamentosStrategy;
  }

  public String efetuarPagamento(double valor)  {
      if(pagamentosStrategy == null){
        throw new IllegalArgumentException("Nenhuma forma de pagamento selecionada.");
      }
      return pagamentosStrategy.efetuarPagamento(valor);
    }
}
