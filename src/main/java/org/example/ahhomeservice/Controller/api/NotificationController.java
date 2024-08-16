//package org.example.ahhomeservice.Controller.api;
//
//
//import com.google.api.client.util.Data;
//import org.example.ahhomeservice.Service.NotificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class NotificationController {
//
//
//    @Autowired
//    private NotificationService notificationService;
//
//    @PostMapping("/insertData")
//    public String insertData(@RequestBody Data data) {
//        // Insert data logic here
//
//        // After data is inserted, send notification
//        String token = "target-device-token"; // You should fetch the actual token from the database or request
//        notificationService.sendNotification("New Data Inserted", "Data has been successfully inserted.", token);
//
//        return "Data inserted";
//    }
//}
