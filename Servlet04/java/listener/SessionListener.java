package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    
    int counter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Http Session Created...");
        System.out.println("Total Sessions Rigth Now : " + ++counter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Http Session Deleted...");
        System.out.println("Total Sessions Rigth Now : " + --counter);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Name : " + event.getName() + " Value : " + event.getValue() + " Added...");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Name : " + event.getName() + " Value : " + event.getValue() + " Removed...");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Name : " + event.getName() + " Value : " + event.getValue() + " Replaced...");
    }
}
