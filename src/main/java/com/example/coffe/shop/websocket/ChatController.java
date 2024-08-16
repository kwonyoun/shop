package com.example.coffe.shop.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/chat/{userId}")
public class ChatController extends Socket {
    private static final List<Session> session = new ArrayList<>();

    @GetMapping("/chatroom")
    public String index(Model model){
        return "chatroom";
    }

    @OnOpen
    public void open(Session newUser, @PathParam(value="userId") String userId){
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
        System.out.println(userId);
        for(int i = 0; i< session.size(); i++){
            try{
                session.get(i).getBasicRemote().sendText(userId + "님이 입장하였습니다");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg, @PathParam(value="userId") String userId){
        for(int i = 0; i< session.size(); i++){
            if(!recieveSession.getId().equals(session.get(i).getId())){
                try{
                    session.get(i).getBasicRemote().sendText(userId +" : "+msg);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }else{
                try{
                    session.get(i).getBasicRemote().sendText(userId +" : "+msg);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @OnClose
    public void onClose(Session recieveSession , @PathParam(value="userId") String userId){
        session.remove(recieveSession);

        for(int i = 0; i< session.size(); i++){
            try{
                session.get(i).getBasicRemote().sendText(userId + "님이 채팅방을 나갔습니다");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
