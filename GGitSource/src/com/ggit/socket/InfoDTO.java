package com.ggit.socket;

import java.io.*;

public class InfoDTO implements Serializable {
  public enum Info {
    JOIN,
    EXIT,
    SEND,
    STATE,
    PUSH,
    LOGIN, LOGINRESULT,
    CLONE, CLONERESULT

  }

  private String message;
  private Info command;
  private String id, pw;
  private String user;
  private int idx;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Info getCommand() {
    return command;
  }

  public void setCommand(Info command) {
    this.command = command;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public int getIdx() {
    return idx;
  }

  public void setIdx(int idx) {
    this.idx = idx;
  }

}