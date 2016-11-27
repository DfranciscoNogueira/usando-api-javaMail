package br.com.estudo.mainTeste;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.estudo.util.Utilitario;

public class MainTeste {

    // e-mail do remetente 
    private static String remetente = "";
    // senha do remetente utilizada para a autenticação do envio do e-mail
    private static String senhaRementente = "";
    // e-mail do destinarios para enviar para mais de um email basta inserir os e-mails separados por virgula (,) EXEMPLO ("teste1@gmail.com , teste2@gmail.com")
    private static String destinatario = "";

    public static void main(String[] args) {
        try {

            Properties properties = Utilitario.getInstance().getProperties();

            Session session = Utilitario.getInstance().getSession(properties, remetente, senhaRementente);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));

            Address[] toUser = InternetAddress.parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            // Assunto do e-mail
            message.setSubject("Enviando email com JavaMail");
            // Mensagem do e-mail
            message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Feito!!!");
        }
    }
}
