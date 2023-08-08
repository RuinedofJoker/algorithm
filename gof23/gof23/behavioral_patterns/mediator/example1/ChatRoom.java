package gof23.behavioral_patterns.mediator.example1;

import java.util.Date;

public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date() + " [" + user.getName() +"] : " + message);
    }
}
