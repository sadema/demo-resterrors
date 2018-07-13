package nl.kristalsoftware.resterrortest.demoresterrors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Getter
@Configuration
@PropertySource("icons.properties")
public class IconConfiguration {

    @Value("#{${icons.zeza}}")
    private Map<String,String> icons = new HashMap<>();

//    public Map<String,String> getIcons() {
//        return icons;
//    }

    @Value("${icons.default}")
    void setDefaultIcon(String defaultIcon) {
        System.out.println("Setting default icon: " + defaultIcon);
    }

}
