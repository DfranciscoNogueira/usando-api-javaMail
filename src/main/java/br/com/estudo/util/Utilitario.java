package br.com.estudo.util;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Utilitario {

    private static Utilitario instance;
    private Properties props;

    private Utilitario() {
        this.props = new Properties();
    }

    public static Utilitario getInstance() {
        if (instance == null) {
            instance = new Utilitario();
        }
        return instance;
    }

    // Parâmetros de conexão com servidor Gmail
    public Properties getProperties() {
        this.props.put("mail.smtp.host", "smtp.gmail.com");
        this.props.put("mail.smtp.socketFactory.port", "465");
        this.props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        this.props.put("mail.smtp.auth", "true");
        this.props.put("mail.smtp.port", "465");
        return props;
    }

    public Session getSession(Properties propriedades, String seuEmail, String suaSenha) {
        Session session = Session.getDefaultInstance(propriedades, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(seuEmail, suaSenha);
            }
        });
        session.setDebug(true);
        return session;
    }

}
