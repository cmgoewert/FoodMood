package foodMood.control;

import foodMood.model.Food;
import foodMood.model.FoodList;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public final class ExportController {

    private static FoodList foodList;


    public static void share(String email, FoodList foodToWrite){
        foodList = foodToWrite;
        writeToCSV();
        sendEmail(email);
    }

    private static void writeToCSV() {
        try {
            PrintWriter pw = new PrintWriter(new File("user-data.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("FoodName,ID,Calories,AssociatedMood");
            sb.append(System.getProperty("line.separator"));

            ArrayList<Food> foods = foodList.getListOfFood();

            for (int i = 0; i < foods.size(); i++) {
                Food tempFood = foods.get(i);
                sb.append(tempFood.getFoodName() + ",");
                sb.append(tempFood.getID() + ",");
                sb.append(tempFood.getCalories() + ",");
                sb.append(tempFood.getMoodForThisFood());
                sb.append(System.getProperty("line.separator"));
            }

            pw.write(sb.toString());
            pw.close();
            System.out.println("wrote to file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendEmail(String sendTo) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("cmgoewert@gmail.com", "Chandler12");
                    }
                });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("cmgoewert@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, sendTo);
            msg.setSubject("FoodMood data shared with you!");
            msg.setSentDate(new Date());

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            String textContent = "Please find the Attachment.";
            textPart.setText(textContent);
            multipart.addBodyPart(textPart);

            MimeBodyPart attachementPart = new MimeBodyPart();
            attachementPart.attachFile(new File("user-data.csv"));
            multipart.addBodyPart(attachementPart);

            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("---Done---");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
