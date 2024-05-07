package com.dodo.tutorials.my_kafka.broker;

public class Message {
    private String data;
    private int offset;


    public Message(int offset, String data){
        this.offset = offset;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
