package application.components;

import application.services.RestService;
import com.atlassian.connect.spring.AddonInstalledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class EventsListeners {
    @Autowired
    RestService rs;

    @EventListener
    public void addonInstalled(AddonInstalledEvent event) {
        System.out.println(event.toString());
        rs.requestUsers(event.getHost().getBaseUrl());
    }
}
