package com.macheng.messager.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Profile {
    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date createdDate;

    public Profile(long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = new Date();
    }

    public long getId() {
        return id;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
