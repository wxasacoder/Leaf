package com.sankuai.inf.leaf.common;

import java.util.Objects;

public class IdResult {
    private long id;
    private Status status;
    private String message;

    public IdResult() {

    }
    public IdResult(long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public IdResult(long id, Status status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IdResult idResult = (IdResult) o;
        return id == idResult.id && status == idResult.status && Objects.equals(message, idResult.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, message);
    }

    @Override
    public String toString() {
        return "IdResult{" +
                "id=" + id +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
