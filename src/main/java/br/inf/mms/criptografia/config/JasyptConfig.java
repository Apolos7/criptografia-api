package br.inf.mms.criptografia.config;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
    @Value(value = "${text.encryptor.key}")
    private String chave;

    @Bean
    public AES256TextEncryptor aes256TextEncryptor() {
        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword(chave);
        return textEncryptor;
    }
}
