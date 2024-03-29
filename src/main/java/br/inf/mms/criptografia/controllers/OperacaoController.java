package br.inf.mms.criptografia.controllers;

import br.inf.mms.criptografia.services.operacao.OperacaoService;
import br.inf.mms.criptografia.services.operacao.dto.OperacaoDto;
import br.inf.mms.criptografia.services.operacao.forms.OperacaoForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "v1/operacoes")
@Tag(name = "Operações", description = "Serviços para o gerenciamento de operações")
@RequiredArgsConstructor
public class OperacaoController {

    private final OperacaoService operacaoService;

    @PostMapping()
    @Operation(summary = "Cadastro", description = "Endpoint para realizar o cadastro de uma operação.")
    public ResponseEntity<OperacaoDto> cadastro(@RequestBody @Valid OperacaoForm form, UriComponentsBuilder uriComponentsBuilder) {
        var operacaoDto = this.operacaoService.cadastro(form);
        var uri = uriComponentsBuilder.path("/v1/operacoes/{id}").buildAndExpand(operacaoDto.id()).toUri();
        return ResponseEntity.created(uri).body(operacaoDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca por id", description = "Endpoint para buscar uma operação com base em seu id (identificador).")
    public ResponseEntity<OperacaoDto> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.operacaoService.buscarPorId(id));
    }

    @GetMapping()
    @Operation(summary = "Listagem paginada", description = "Endpoint para realizar a listagem paginada das operações.")
    public ResponseEntity<Page<OperacaoDto>> listagem(@PageableDefault(size = 15) Pageable pageable) {
        return ResponseEntity.ok(this.operacaoService.listar(pageable));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleção", description = "Endpoint para deletar uma operação.")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.operacaoService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualização", description = "Endpoint para atualizar os dadosd de uma operação.")
    public ResponseEntity<OperacaoDto> deletar(@PathVariable Long id, @RequestBody @Valid OperacaoForm form) {
        var operacaoDto = this.operacaoService.atualizar(id, form);
        return ResponseEntity.ok(operacaoDto);
    }
}
