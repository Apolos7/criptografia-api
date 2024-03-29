package br.inf.mms.criptografia.services.operacao.impl;

import br.inf.mms.criptografia.services.criptografia.CriptografiaService;
import br.inf.mms.criptografia.services.exceptions.RecursoNaoEncontradoException;
import br.inf.mms.criptografia.services.operacao.OperacaoService;
import br.inf.mms.criptografia.services.operacao.dto.OperacaoDto;
import br.inf.mms.criptografia.models.OperacaoEntidade;
import br.inf.mms.criptografia.repositories.OperacaoRepository;
import br.inf.mms.criptografia.services.operacao.forms.OperacaoForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperacaoServiceImpl implements OperacaoService {

    private final OperacaoRepository operacaoRepository;
    private final CriptografiaService criptografiaService;

    public OperacaoDto cadastro(OperacaoForm form) {
        var documentoCriptografado = this.criptografiaService.criptografarDados(form.documentoUsuario());
        var tokenCartaoCriptografado = this.criptografiaService.criptografarDados(form.tokenCartaoCredito());
        var operacaoEntidade = OperacaoEntidade.builder()
                .documentoUsuario(documentoCriptografado)
                .cartaoCreditoToken(tokenCartaoCriptografado)
                .operacaoValor(form.valorOperacao())
                .build();
        this.operacaoRepository.save(operacaoEntidade);
        return new OperacaoDto(operacaoEntidade.getId(), form.documentoUsuario(), form.tokenCartaoCredito(), form.valorOperacao());
    }

    @Override
    public OperacaoDto buscarPorId(Long id) {
        var operacaoEntidade = this.operacaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Operação", id));
        var documentoDescriptografado = this.criptografiaService.descriptografarDados(operacaoEntidade.getDocumentoUsuario());
        var tokenCartaoDescriptografado = this.criptografiaService.descriptografarDados(operacaoEntidade.getCartaoCreditoToken());
        return new OperacaoDto(operacaoEntidade.getId(), documentoDescriptografado, tokenCartaoDescriptografado, operacaoEntidade.getOperacaoValor());
    }

    @Override
    public Page<OperacaoDto> listar(Pageable pageable) {
        return this.operacaoRepository.findAll(pageable)
                .map(entidade -> {
                    var documentoDescriptografado = this.criptografiaService.descriptografarDados(entidade.getDocumentoUsuario());
                    var tokenCartaoDescriptografado = this.criptografiaService.descriptografarDados(entidade.getCartaoCreditoToken());
                    return new OperacaoDto(entidade.getId(), documentoDescriptografado, tokenCartaoDescriptografado, entidade.getOperacaoValor());
                });
    }

    @Override
    public void deletarPorId(Long id) {
        this.operacaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("operação", id));
        this.operacaoRepository.deleteById(id);
    }

    @Override
    public OperacaoDto atualizar(Long id, OperacaoForm form) {
        var operacaoEntidade = this.operacaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("operação", id));

        operacaoEntidade.setOperacaoValor(form.valorOperacao());
        var documentoCriptografado = this.criptografiaService.criptografarDados(form.documentoUsuario());
        var tokenCartaoCriptografado = this.criptografiaService.criptografarDados(form.tokenCartaoCredito());
        operacaoEntidade.setDocumentoUsuario(documentoCriptografado);
        operacaoEntidade.setCartaoCreditoToken(tokenCartaoCriptografado);
        this.operacaoRepository.save(operacaoEntidade);
        return new OperacaoDto(operacaoEntidade.getId(), form.documentoUsuario(), form.tokenCartaoCredito(), form.valorOperacao());
    }
}
