package com.example.ourzone.Models;

public class MediaObject {
    String title;
    String description;
    String date;
    String user_id;

    String post_categories;
    String post_id;
    String view;
    String media_url;
    String thumbnail;
    public MediaObject() {}

    public MediaObject(String title, String description, String date, String user_id, String post_categories, String post_id, String view, String media_url, String thumbnail) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.user_id = user_id;
        this.post_categories = post_categories;
        this.post_id = post_id;
        this.view = view;
        this.media_url = media_url;
        this.thumbnail = thumbnail;
    }


}
