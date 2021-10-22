package org.trustfuse.api_test;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Reply {
    public int id;
    @SerializedName("text")
    public String text;
    public int type;
    public long source;
    public long destination;
    public Date date_created;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public long getSource() {
        return source;
    }
    public long getDestination() {
        return destination;
    }

    public Date getDate_created() {
        return date_created;
    }
}
