package com.dbccompany.vemser.service;

import com.dbccompany.vemser.repository.EnderecoRepository;
import com.dbccompany.vemser.repository.PessoaRepository;
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
    private final EmailService emailService;

    @Scheduled(cron = "0 0 0 1 * *")
    public void envioMensal() {
        log.info("executou");
        pessoaRepo.listarPessoas()
                .forEach(pessoa ->
                        emailService.sendSimpleMessage(pessoa.getEmail(), "Olá " + pessoa.getNome() + ",\n" +
                                "\n" +
                                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa\n" +
                                "plataforma especialmente para você:\n" +
                                "\n" +
                                "- Na compra de 1 CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico.\n" +
                                "- Na locação de um filme em VHS, a outra locação é grátis\n" +
                                "- Fita de Super Nintendo com 50% de desconto.\n" +
                                "\n" +
                                "Aproveite!\n" +
                                "Magazine OldSchool.\n" +
                                "\n" +
                                "«VEM SER\n" +
                                "DBC"));
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void envioParabens() {
        LocalDate dataAgora = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        pessoaRepo.listarPessoas().stream().filter(pessoa -> pessoa.getNascimento().getMonth().equals(dataAgora.getMonth())
                        && pessoa.getNascimento().getDayOfMonth() == dataAgora.getDayOfMonth())
                .forEach(pessoa -> emailService.sendSimpleMessage(pessoa.getEmail(), "Olá," + pessoa.getNome() + "\n" +
                        "\n" +
                        "Essa data de " + formatter.format(dataAgora) + " também é especial para nós do\n" +
                        "Vem Ser. Estamos comemorando junto com você. lo/\n" +
                        "\n" +
                        "Desejamos um feliz aniversário, que sejam " + Period.between(pessoa.getNascimento(),
                        dataAgora).getYears() + " de muitos. Sucesso, alegria,\n" +
                        "felicidade e muitas realizações.\n" +
                        "\n" +
                        "Forte abraço,\n" +
                        "VemSerDBC!"));
    }

    @Scheduled(cron = "0 0 8,20 * * *")
    public void verificarPessoaTemEndereco() {
        pessoaRepo.listarPessoas().stream().filter(pessoa -> enderecoRepository
                        .listarEnderecos().stream()
                        .noneMatch(endereco ->
                                Objects.equals(endereco.getIdPessoa(), pessoa.getId())))
                .forEach(pessoa -> emailService.sendSimpleMessage(pessoa.getEmail(), String.format("""
                        Olá %s,

                        Estamos muito felizes que você está em nosso sistema.
                        Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.

                        Muito obrigado,
                        Sistema de Pessoas.
                        """, pessoa.getNome())));
    }


}
