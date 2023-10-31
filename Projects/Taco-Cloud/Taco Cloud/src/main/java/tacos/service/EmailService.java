package tacos.service;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//import tacos.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendConfirmationEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Order Confirmation");
        message.setText("Your customized Taco order for " + name + " has been confirmed."
                + "\nWe hope that you enjoy your taco to the fullest!!! Visit Again😊"
                + "\n\nTaco Store - Made by Raghav Kavimandan");
        javaMailSender.send(message);
    }
}
