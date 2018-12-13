package de.fhws.app.business.chat.boundary;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import de.fhws.app.business.news.boundary.NewLogin;

@Singleton
@ServerEndpoint("/chat")
public class ChatBox {

	private final Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

	@OnMessage
	public void incomingMsg(String message, Session session) throws IOException {
		System.out.println("incoming message " + session.getId() + " message: " + message);
		String sendMessage = "Sender: " + session.getId() + " -> " + message;
		broadCastMessage(sendMessage);
	}

	void broadCastMessage(String message) throws IOException {
		for (Session s : clients) {
			s.getBasicRemote().sendText(message);
		}
	}

	@OnOpen
	public void open(Session session) {
		System.out.println("new WebSocket session " + session.getId());
		clients.add(session);
	}

	@OnClose
	public void close(Session session) {
		System.out.println("remove WebSocket session " + session.getId());		
		clients.remove(session);
	}

	
	public void newLoginMessage(@Observes @NewLogin String message) throws IOException {
		broadCastMessage(message);
	}
}
