//package org.example.ahhomeservice.Service;
//
//
//import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import com.google.firebase.messaging.Message;
//import com.google.firebase.messaging.Notification;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.ExecutionException;
//
//@Service
//public class NotificationService {
//
//    public void sendNotification(String title, String body, String token) {
//        Notification notification = Notification.builder()
//                .setTitle(title)
//                .setBody(body)
//                .build();
//
//        Message message = Message.builder()
//                .setNotification(notification)
//                .setToken(token)
//                .build();
//
//        try {
//            String response = FirebaseMessaging.getInstance().send(message);
//            System.out.println("Notification sent successfully: " + response);
//        } catch (FirebaseMessagingException e) {
//            System.err.println("Error sending notification: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}
