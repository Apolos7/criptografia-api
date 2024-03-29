package br.inf.mms.criptografia.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Entity
@Table(name = "operacoes")
public class OperacaoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacoes_seq")
    @SequenceGenerator(name = "operacoes_seq", sequenceName = "operacoes_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotAudited
    @Column(name = "documento_usuario", columnDefinition = "TEXT", nullable = false)
    private String documentoUsuario;
    @NotAudited
    @Column(name = "cartao_credito_token", columnDefinition = "TEXT", nullable = false)
    private String cartaoCreditoToken;
    @Column(name = "operacao_valor", columnDefinition = "NUMERIC(18,2)", nullable = false)
    private Double operacaoValor;
    @Version
    private long versao;
}
