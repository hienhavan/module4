package org.example.springmvc.model.minitest2;

public class ResponseObject {
    private String message;
    private Object data;
    private String status;
    public ResponseObject(String message, Object data, String status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public ResponseObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
