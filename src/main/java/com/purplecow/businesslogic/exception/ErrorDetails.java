package com.purplecow.businesslogic.exception;

import java.util.Date;

public class ErrorDetails
{
    private String message = "";
    private String details = "";
    private Date timeStamp = null;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    ErrorDetails(Date timestamp, String message, String details)
    {
        super();
        this.timeStamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
