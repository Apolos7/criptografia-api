package br.inf.mms.criptografia.repositories;

import br.inf.mms.criptografia.models.OperacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoRepository extends JpaRepository<OperacaoEntidade, Long> {
}
