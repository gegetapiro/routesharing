package org.route.model;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Mailutility {
	public static void sendMail(String dest, String mitt, String oggetto, String testoEmail) throws MessagingException {

		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		final String username = "jerrysimona.trimarco532@gmail.com";
//		final String password = "chiarettinabellina";
//		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", Togetdb.smtpconstant);
		props.put("mail.smtp.auth", Togetdb.authcostant);
		props.put("mail.smtp.starttls.enable", Togetdb.startlsenable);
		final String username = Togetdb.cheuser;
		final String password = Togetdb.chepassword;
		props.put("mail.smtp.port", Togetdb.cheport);

		javax.mail.Authenticator auth = new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

				return new javax.mail.PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);

		// Creazione del messaggio da inviare
		MimeMessage message = new MimeMessage(session);
		message.setSubject(oggetto);
		message.setText(testoEmail);

		// Aggiunta degli indirizzi del mittente e del destinatario
		InternetAddress fromAddress = new InternetAddress(mitt);
		InternetAddress toAddress = new InternetAddress(dest);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		// Invio del messaggio
		Transport.send(message);
	}
}