package br.inf.mms.criptografia.services.operacao;

import br.inf.mms.criptografia.services.operacao.dto.OperacaoDto;
import br.inf.mms.criptografia.services.operacao.forms.OperacaoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OperacaoService {
    OperacaoDto cadastro(OperacaoForm form);
    OperacaoDto buscarPorId(Long id);
    Page<OperacaoDto> listar(Pageable pageable);
    void deletarPorId(Long id);
    OperacaoDto atualizar(Long id, OperacaoForm form);
}
