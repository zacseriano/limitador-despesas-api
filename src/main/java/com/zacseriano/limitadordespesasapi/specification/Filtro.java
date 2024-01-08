package com.zacseriano.limitadordespesasapi.specification;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filtro {
    private String chave;
    private Object valor;
    private List<?> valores;
    private QueryOperator operador;
}
