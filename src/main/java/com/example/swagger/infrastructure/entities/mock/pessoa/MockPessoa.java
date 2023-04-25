package com.example.swagger.infrastructure.entities.mock.pessoa;

import com.example.swagger.infrastructure.entities.Pessoa;
import com.example.swagger.infrastructure.entities.Profissao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.example.swagger.infrastructure.entities.Profissao.DEVELOPER;

public class MockPessoa {
  public static List<Pessoa> buscaPessoas() {
    return Arrays.asList(
        new Pessoa("Angelica", 30, BigDecimal.TEN, DEVELOPER),
        new Pessoa("Maria", 37, BigDecimal.TEN, DEVELOPER),
        new Pessoa("Pedro", 40, BigDecimal.ONE, Profissao.SCRUM_MASTER),
        new Pessoa("Felipe", 28, BigDecimal.ONE, Profissao.SCRUM_MASTER),
        new Pessoa("Joao", 43, BigDecimal.ONE, Profissao.PRODUCT_OWNER),
        new Pessoa("Elder", 46, BigDecimal.ONE, Profissao.PRODUCT_OWNER)
    );
  }
}
