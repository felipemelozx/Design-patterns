package felipemelozx.factory.controller;

import felipemelozx.factory.factory.PagamentoFactory;
import felipemelozx.factory.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

  @PostMapping("/{metodoPagamento}")
  public ResponseEntity<String> processarPagamento(@PathVariable("metodoPagamento") String metodoPagamento) {
    try {
      PagamentoService pagamentoService = PagamentoFactory.getPagamento(metodoPagamento);
      return ResponseEntity.ok(pagamentoService.processarPagamento());
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
