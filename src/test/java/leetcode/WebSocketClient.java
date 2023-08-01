package leetcode;

import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class WebSocketClient {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server: " + session.getId());
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Message received. Session ID: " + session.getId() + ", Message: " + message);
    }

    public void sendMsg(){
        session.getAsyncRemote().sendText("2222");
    }

    public static void main(String[] args) throws Exception {
        WebSocketContainer container = javax.websocket.ContainerProvider.getWebSocketContainer();
        String uri = "ws://192.168.0.109:8080/webSocketByTomcat/123457"; // WebSocket服务端地址
        container.connectToServer(WebSocketClient.class, URI.create(uri));
    }
}
