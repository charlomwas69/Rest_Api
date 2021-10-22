package org.trustfuse.api_test;

import java.util.List;

public class Response {
    public int status;
    public String message;
    public List<Reply> reply;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Reply> getReply() {
        return reply;
    }
}
