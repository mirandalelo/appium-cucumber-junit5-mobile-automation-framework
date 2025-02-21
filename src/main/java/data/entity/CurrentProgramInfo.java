package data.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CurrentProgramInfo {

    private String DABServiceName;
    private String title;
    private String artist;
    private String RDS_RT;

    public CurrentProgramInfo() {}

}
