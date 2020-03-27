package data.vo.id;

import lombok.Getter;

@Getter
public class AppId implements Id {
    private String appId;

    public String toString() {
        return this.appId;
    }

    public AppId(final String appId) {
        this.appId = appId;
    }
}
