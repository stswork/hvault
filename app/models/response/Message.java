package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/20/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    public int status;
    public String comment;
    public MessageType messageType;

    public Message() {
    }

    public Message(int status, String comment, MessageType messageType) {
        this.status = status;
        this.comment = comment;
        this.messageType = messageType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public enum MessageType{
        SUCCESSFUL,
        BAD_REQUEST,
        NOT_FOUND,
        INTERNAL_SERVER_ERROR,
        UNAUTHORIZED
    }
}


