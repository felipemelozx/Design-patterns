package felipemelozx.factory.service.Impl;

import felipemelozx.factory.service.PagamentoService;
import org.springframework.stereotype.Service;

@Service
public class GooglePagamentoServiceImpl implements PagamentoService {

  @Override
  public String processarPagamento() {
    return "Pagamento processado pelo Google.";
  }
}
