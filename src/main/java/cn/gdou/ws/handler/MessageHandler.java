package cn.gdou.ws.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

//也可以不继承AbstractWebSocketHandler而继承TextWebSocketHandler或BinaryWebSocketHandler
public class MessageHandler extends AbstractWebSocketHandler {
    private static final Logger log=LoggerFactory.getLogger(MessageHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("Received message: "+message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("I got your message"));
    }
}
