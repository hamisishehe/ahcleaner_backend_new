package org.example.ahhomeservice.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("settingscontroller")
public class SettingsController {

    @GetMapping("/admin/settings")
    public String settings(){
        return "admin/settings";
    }
}
