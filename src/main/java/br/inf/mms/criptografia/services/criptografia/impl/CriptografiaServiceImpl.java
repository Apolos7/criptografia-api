package br.inf.mms.criptografia.services.criptografia.impl;

import br.inf.mms.criptografia.services.criptografia.CriptografiaService;
import lombok.RequiredArgsConstructor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriptografiaServiceImpl implements CriptografiaService {

    private final AES256TextEncryptor aes256TextEncryptor;

    public String criptografarDados(String dados) {
        return aes256TextEncryptor.encrypt(dados);
    }
    public String descriptografarDados(String dadosCriptografados) {
        return aes256TextEncryptor.decrypt(dadosCriptografados);
    }
}
