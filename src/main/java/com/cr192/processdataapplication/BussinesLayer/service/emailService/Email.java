package com.cr192.processdataapplication.BussinesLayer.service.emailService;

import com.cr192.processdataapplication.DataAccesLayer.repository.DocumentRep;
import com.cr192.processdataapplication.DataAccesLayer.repository.ProductRep;
import com.cr192.processdataapplication.controller.DeliveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// wArzqm5QQJ218MExUWQ7
//myxmEq-senfyz-bixre5
@Component
public class Email {
    private final String username = "deliveryd@internet.ru";//change accordingly
    private final String password = "wArzqm5QQJ218MExUWQ7";//change accordingly
    private String from = "deliveryd@internet.ru";//change accordingly
    private String host = "smtp.mail.ru";
    private Properties props = new Properties();
    @Autowired
    private DocumentRep documentRep;
    @Autowired
    private ProductRep productRep;

    public void createMessage(int productCode) {
        String to = productRep.getReipentEmail(productCode).get();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "535");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Testing Subject");

            String text = "Good afternoon, your product is on the way, estimated delivery date is XXX."
                    + documentRep.getDataDocByIdDoc(DeliveryController.deliveryData.getIdMainDocument()).get() +
                    "To view information about your product, storage location, " +
                    "go to the site XXX and enter the code" + productCode + " or call " + productRep.getReipentPhone(productCode).get() + ". Have a good day :)";
            message.setText(text);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }
    public void send() {
        for (int i = 0; i < DeliveryController.deliveryData.getIdProducts().size(); i++) {
            createMessage(DeliveryController.deliveryData.getIdProducts().get(i));
        }
    }
}
