package org.example.ahhomeservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("settings")
public class SettingController {
    @GetMapping("/settings")
    public String settings(){
        return "settings";
    }
}
