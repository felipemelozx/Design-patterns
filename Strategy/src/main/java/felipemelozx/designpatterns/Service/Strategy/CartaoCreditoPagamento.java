package felipemelozx.designpatterns.Service.Strategy;

public class CartaoCreditoPagamento implements PagamentosStrategy{

  private String numeroCartao;

  public CartaoCreditoPagamento(String numeroCartao) {
    this.numeroCartao = numeroCartao;
  }

  @Override
  public String efetuarPagamento(double valor) {
    return "Pagamento de R$ " + valor + " efetuado no cartão de crédito, de numero: " + numeroCartao;
  }
}
