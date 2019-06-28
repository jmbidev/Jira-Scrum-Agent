package application.services;

import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUserService {

    private AtlassianHostUser user;

    public void setUser(AtlassianHostUser user) {
        this.user = user;
    }

    public AtlassianHostUser getUser() {
        return user;
    }
}
