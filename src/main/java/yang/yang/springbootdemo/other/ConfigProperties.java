package yang.yang.springbootdemo.other;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyan on 2017/07/19.
 */
@ConfigurationProperties("appbase")
public class ConfigProperties {


    private boolean enable = true;
    private List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {

        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
