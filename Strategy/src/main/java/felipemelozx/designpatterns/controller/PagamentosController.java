package felipemelozx.designpatterns.controller;

import felipemelozx.designpatterns.Service.PagamentosContext;
import felipemelozx.designpatterns.Service.Strategy.BoletoPagamento;
import felipemelozx.designpatterns.Service.Strategy.CartaoCreditoPagamento;
import felipemelozx.designpatterns.Service.Strategy.PixPagamento;
import felipemelozx.designpatterns.dtos.PagamentosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

  @PostMapping
  public ResponseEntity<String> efetuarPagamento(@RequestBody PagamentosDTO pagamentoDTO) {

    PagamentosContext pagamentosContext = new PagamentosContext();

    try {

      switch (pagamentoDTO.metodoPagamento()){
        case "PIX":
          pagamentosContext.setPagamentosStrategy(new PixPagamento(pagamentoDTO.valorChave()));
          return  ResponseEntity.ok(pagamentosContext.efetuarPagamento(pagamentoDTO.valor()));
        case "BOLETO":
          pagamentosContext.setPagamentosStrategy(new BoletoPagamento(pagamentoDTO.valorChave()));
          return  ResponseEntity.ok(pagamentosContext.efetuarPagamento(pagamentoDTO.valor()));
        case "CARTAO":
          pagamentosContext.setPagamentosStrategy(new CartaoCreditoPagamento(pagamentoDTO.valorChave()));
          return  ResponseEntity.ok(pagamentosContext.efetuarPagamento(pagamentoDTO.valor()));
      }

      return ResponseEntity.status(404).body("Nenhum método de pagamento encontrado.");

    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(401).body(e.getMessage());
    }
  }


}
