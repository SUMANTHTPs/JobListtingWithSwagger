package com.sumanthtp.jobListing.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobListing")
public class Post
{
    private String profile;
    private String desc;
    private int exp;
    private String[] tech;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTech() {
        return tech;
    }

    public void setTech(String[] tech) {
        this.tech = tech;
    }

    public Post() {
    }
}
