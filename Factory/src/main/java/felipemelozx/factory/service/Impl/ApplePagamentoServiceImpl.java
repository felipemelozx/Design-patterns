package felipemelozx.factory.service.Impl;

import felipemelozx.factory.service.PagamentoService;
import org.springframework.stereotype.Service;

@Service
public class ApplePagamentoServiceImpl implements PagamentoService {
  @Override
  public String processarPagamento() {
    return "Pagamento processado pela Apple.";
  }
}
