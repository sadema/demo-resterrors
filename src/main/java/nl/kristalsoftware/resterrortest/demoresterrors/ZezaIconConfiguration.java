package nl.kristalsoftware.resterrortest.demoresterrors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

//@Configuration
@PropertySource("icons.properties")
@ConfigurationProperties("icons.zeza")
public class ZezaIconConfiguration {

    private final HashMap<String,String> zezaIcons = new HashMap<>();

    public Map<String,String> getZezaIcons() {
        return zezaIcons;
    }

//    @Value("${icons.zeza}")
//    void setZezaIcons(Map<String,String> zezaIcons) {
//        System.out.println("Aantal zeza icons: " + zezaIcons.size());
//    }
}
