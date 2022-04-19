package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.EmailDto;
import com.dbccompany.vemser.repository.EnderecoRepository;
import com.dbccompany.vemser.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepo;
    private final EnderecoRepository enderecoRepository;
    private final KafkaService kafkaService;
    private final ObjectMapper objectMapper;


    @Scheduled(cron = "0 0 0 1 * *")
    public void envioPromocional() {
        pessoaRepo.listarPessoas()
                .forEach(pessoa -> {
                    EmailDto email = EmailDto.builder()
                            .destinatario(pessoa.getEmail())
                            .assunto(String.format("""
                                    Olá  %s,%n
                                    Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa
                                    plataforma especialmente para você:

                                    - Na compra de 1 CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico.
                                    - Na locação de um filme em VHS, a outra locação é grátis
                                    - Fita de Super Nintendo com 50 de desconto.

                                    Aproveite!
                                    Magazine OldSchool.

                                    «VEM SER
                                    DBC""", pessoa.getNome()))
                            .assunto("Promoção magazine!!")
                            .build();
                    try {
                        kafkaService.sendMessage(objectMapper.writeValueAsString(email));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
    }


    @Scheduled(cron = "0 0 8 * * *")
    public void envioParabens() {
        LocalDate dataAgora = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");

        pessoaRepo.listarPessoas().stream().filter(pessoa -> pessoa.getNascimento().getMonth().equals(dataAgora.getMonth())
                        && pessoa.getNascimento().getDayOfMonth() == dataAgora.getDayOfMonth())
                .forEach(pessoa -> {
                    EmailDto email = EmailDto.builder()
                            .destinatario(pessoa.getEmail())
                            .mensagem(String.format("""
                                            Olá, %s%n
                                            Essa data de %s também é especial para nós do
                                            Vem Ser. Estamos comemorando junto com você. lo/

                                            Desejamos um feliz aniversário, que sejam %d de muitos. Sucesso, alegria,
                                            felicidade e muitas realizações.

                                            Forte abraço,
                                            VemSerDBC!""", pessoa.getNome(), formatter.format(dataAgora),
                                    Period.between(pessoa.getNascimento(), dataAgora).getYears()))
                            .assunto("Aniversário")
                            .build();
                    try {
                        kafkaService.sendMessage(objectMapper.writeValueAsString(email));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Scheduled(cron = "0 0 8,20 * * *")
    public void verificarPessoaTemEndereco() {
        pessoaRepo.listarPessoas().stream().filter(pessoa -> enderecoRepository
                        .listarEnderecos().stream()
                        .noneMatch(endereco ->
                                Objects.equals(endereco.getIdPessoa(), pessoa.getId())))
                .forEach(pessoa -> {
                    EmailDto emailDto = EmailDto.builder()
                            .assunto("Endereço")
                            .destinatario(pessoa.getEmail())
                            .mensagem(String.format("""
                                    Olá %s,

                                    Estamos muito felizes que você está em nosso sistema.
                                    Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.

                                    Muito obrigado,
                                    Sistema de Pessoas.
                                    """, pessoa.getNome()))
                            .build();
                    try {
                        kafkaService.sendMessage(objectMapper.writeValueAsString(emailDto));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
    }


}
