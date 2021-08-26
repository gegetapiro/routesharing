package org.route.model.batchjob;

import javax.mail.*;
import javax.mail.internet.*;

import org.route.model.Togetdb;

import java.util.*;

public class Listusermailing {
	public static void sendMail(String dest, String mitt, String oggetto, String[][] testoEmail) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", Togetdb.authcostant);
		props.put("mail.smtp.host", Togetdb.smtpconstant);
		props.put("mail.smtp.starttls.enable", Togetdb.startlsenable);
		props.put("mail.smtp.port", Togetdb.cheport);
		final String username = Togetdb.cheuser;
		final String password = Togetdb.chepassword;

		javax.mail.Authenticator auth = new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

				return new javax.mail.PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);

		// Creazione del messaggio da inviare
		MimeMessage message = new MimeMessage(session);
		message.setSubject(oggetto);
		// System.out.println("testoEmail.length " + testoEmail.length);
		String chapatut = null;
		for (int w = 0; w < testoEmail.length; w++) {
			chapatut += testoEmail[w][0] + " indirizzo mail: <a href='mailto:" + testoEmail[w][1] + "'>" + testoEmail[w][1] + "</a>" + testoEmail[w][2] + testoEmail[w][3] + testoEmail[w][4]
					+ testoEmail[w][5] + testoEmail[w][6] + "<br /><br />";
		}
		message.setContent(chapatut, "text/html");
		// message.setContent(testoEmail[0][0] +
		// " indirizzo mail: <a href='mailto:" + testoEmail[0][1] + "'>" +
		// testoEmail[0][1] + "</a>" + testoEmail[0][2] + testoEmail[0][3] +
		// testoEmail[0][4]
		// + testoEmail[0][5] + testoEmail[0][6] + "<br /><br />", "text/html");

		// Aggiunta degli indirizzi del mittente e del destinatario
		InternetAddress fromAddress = new InternetAddress(mitt);
		InternetAddress toAddress = new InternetAddress(dest);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		// Invio del messaggio
		Transport.send(message);
	}
}