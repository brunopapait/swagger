package com.example.swagger.business;

import com.example.swagger.infrastructure.entities.Pessoa;
import com.example.swagger.infrastructure.entities.Profissao;
import com.example.swagger.infrastructure.entities.mock.pessoa.MockPessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
@Component
public class SwaggerService {
  private String path = "/home/brunopapait/Documentos";

  public ResponseEntity<String> uploadDocument(MultipartFile file) {
    try {
      notNull(file, "arquivo é obrigatório!");

      var rootFile = path + "/" + file.getOriginalFilename();
      var newDocument = new File(rootFile);
      var fileOutputStream = new FileOutputStream(newDocument, true);

      file.getInputStream().transferTo(fileOutputStream);
      return ResponseEntity.ok("Arquivo carregado " + file.getName());
    } catch (Exception e) {
      throw new RuntimeException("Erro ao carregar arquivo");
    }
  }

  public List<Pessoa> buscaPessoasPor(Profissao profissao, Integer idade) {
    var pessoas = MockPessoa.buscaPessoas();

    return pessoas.stream()
        .filter(Objects::nonNull)
        .filter(pessoa -> pessoa.profissao().equals(profissao))
        .filter(pessoa -> Objects.equals(pessoa.idade(), idade))
        .collect(Collectors.toList());
  }
}
