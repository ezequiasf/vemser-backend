package com.dbccompany.vemser.service;

import com.dbccompany.vemser.dto.DTO;
import com.dbccompany.vemser.dto.EnderecoDTO;
import com.dbccompany.vemser.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "ezequias.barros@dbccompany.com.br";

    @Value("${spring.mail.username}")
    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(MAIL_TO);
        message.setSubject("TESTE");
        message.setText("Teste\n minha mensagem \n\nAtt,\nEu.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(MAIL_TO);
        helper.setSubject("TESTE");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nEu.");

        File file1 = new File("imagem.jpg");

        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(DTO dto, String template) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(MAIL_TO);
            mimeMessageHelper.setSubject("TESTE");
            mimeMessageHelper.setText(geContentFromTemplate(dto, template), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(DTO dto, String templateModel) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        if (dto instanceof PessoaDTO) {
            dados.put("nome", ((PessoaDTO) dto).getNome());
            dados.put("id", ((PessoaDTO) dto).getId());
        } else if (dto instanceof EnderecoDTO) {
            dados.put("idPessoa", ((EnderecoDTO) dto).getIdPessoa());
            dados.put("logradouro", ((EnderecoDTO) dto).getLogradouro());
            dados.put("numero", ((EnderecoDTO) dto).getNumero());
        }
        dados.put("email", this.from);
        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        Template template = fmConfiguration.getTemplate(templateModel);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }
}