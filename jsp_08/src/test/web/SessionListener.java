package test.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    public static int activeSession;
    
        public void sessionCreated(HttpSessionEvent se)  { 
            System.out.println("sessionCreated ...");
            activeSession++;
        }

        public void sessionDestroyed(HttpSessionEvent se)  { 
            System.out.println("sessionDestroyed ...");
            activeSession--;
        }
}