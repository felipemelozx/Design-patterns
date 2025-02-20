package felipemelozx.designpatterns.Service.Strategy;

public class BoletoPagamento implements PagamentosStrategy{

  private String codigoBarras;

  public BoletoPagamento(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }


  @Override
  public String efetuarPagamento(double valor) {
    return "Pagamento de R$ " + valor + " efetuado no boleto com o código: " + codigoBarras;

  }
}
