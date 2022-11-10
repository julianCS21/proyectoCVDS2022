package biblioteca.service;

import org.springframework.stereotype.Service;
import biblioteca.domain.App;

/**
 * .
 *
 * @author DevMasters
 */
@Service
public class AppService {
    public App getApp(String appName) {
        App app = new App();
        app.setAppName("App");

        return app;
    }
}