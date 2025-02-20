package felipemelozx.designpatterns.Service.Strategy;

public class PixPagamento implements PagamentosStrategy {

  private String chavePix;

  public PixPagamento(String chavePix) {
    this.chavePix = chavePix;
  }


  @Override
  public String efetuarPagamento(double valor) {
    return "Pagamento PIX de R$ " + valor + " efetuado com sucesso. na chave PIX: " + chavePix;
  }
}
