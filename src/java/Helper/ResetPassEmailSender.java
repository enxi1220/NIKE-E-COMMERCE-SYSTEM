package Helper;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;


/**
 *
 * @author vinnie chin
 */

public class ResetPassEmailSender {

    public static String sendMail(String customerEmail) throws Exception {
        
        String from = "nike.ecommerce.vclx@gmail.com";
        String pass = "Y2S3_GUI_assignment";
        String randomOTP = getRandomOTP();

        Properties properties = new Properties();
        // Configure mail server
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");

        Session mailSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(mailSession);

            // From: 
            message.setFrom(new InternetAddress(from));

            // To:
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(customerEmail));
            // subject of email
            message.setSubject("Reset Password OTP");

            // Content of email
            message.setText("Use the OTP below to reset your password ^-^\n\n" + randomOTP);

            Transport.send(message);
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
        //return to BLL caller so this OTP can be inserted to the corresponding ucstomer record
        return randomOTP;
    }
    
    public static String getRandomOTP() {
        // Generate random number
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // Convert any number sequence into 6 digits as OTP
        return String.format("%06d", number);
    }
}
