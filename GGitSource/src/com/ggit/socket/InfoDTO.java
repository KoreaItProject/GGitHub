package com.ggit.socket;

import java.io.*;

public class InfoDTO implements Serializable {
  public enum Info {
    JOIN,
    EXIT,
    SEND,
    STATE,
    PUSH,
    PULL, PULLRESULT,
    LOGIN, LOGINRESULT,
    CLONE, CLONERESULT

  }

  private Info command;
  private String message;
  private String id, pw;
  private String user;
  private String idx;
  private String token;

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

  public String getIdx() {
    return idx;
  }

  public void setIdx(String idx) {
    this.idx = idx;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}