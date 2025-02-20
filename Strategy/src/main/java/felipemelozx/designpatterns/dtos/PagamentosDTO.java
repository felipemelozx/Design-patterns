package felipemelozx.designpatterns.dtos;

public record PagamentosDTO(String metodoPagamento,
                            String valorChave,
                            double valor) { }