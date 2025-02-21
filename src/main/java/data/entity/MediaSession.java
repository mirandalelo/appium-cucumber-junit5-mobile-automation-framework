package data.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaSession {

    String packageName;
    Integer userId;
    boolean active;
    String state;
    String metadataDescription;

    public MediaSession() {}

    public MediaSession(String packageName, Integer userId, boolean active, String state, String metadataDescription) {

        this.packageName = packageName;
        this.userId = userId;
        this.active = active;
        this.state = state;
        this.metadataDescription = metadataDescription;

    }


}
