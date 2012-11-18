package edu.integration.patterns.notify;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpNotifier implements Notifier {

    private static final Logger logger = Logger.getLogger(SmtpNotifier.class);

    private MailSender mailSender;
    private SimpleMailMessage mailMessage;

    public SmtpNotifier(MailSender mailSender, SimpleMailMessage mailMessage) {
        this.mailSender = mailSender;
        this.mailMessage = mailMessage;
    }

    /*
     * public void sendNotification(boolean status) {
     * logger.error("Error will be generated to trigger retry"); throw new
     * RuntimeException("Retry exception"); }
     */
    @Override
    public void sendNotification(boolean status) {
        logger.info("Sending email notification for status: " + status);
        SimpleMailMessage msg = new SimpleMailMessage(this.mailMessage);
        msg.setTo("dgyordanov@gmail.com");
        try {
            mailSender.send(msg);
            logger.info("Email notification sent successfully");
        } catch (MailException e) {
            logger.error("Can not send email notification", e);
            throw new RuntimeException(e);
        }

    }

}
