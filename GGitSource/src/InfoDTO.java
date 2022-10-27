
import java.io.*;

public class InfoDTO implements Serializable {

  public enum Info {
    JOIN,
    EXIT,
    SEND,
    STATE,
    STATELOSE,
    PUSH
  }

  private String nickName;
  private String message;
  private Info command;
  private int step;
  private int moveX;
  private int skill;
  private int seed;
  private String roomId;
  private int charIdx;
  private String winlose;
  private int skillCount;
  private int comboMaxCount;
  private int mydeath;
  private boolean ingame;

  public boolean isIngame() {
    return this.ingame;
  }

  public void setIngame(boolean ingame) {
    this.ingame = ingame;
  }

  public int getMydeath() {
    return this.mydeath;
  }

  public void setMydeath(int mydeath) {
    this.mydeath = mydeath;
  }

  public int getSkillCount() {
    return this.skillCount;
  }

  public void setSkillCount(int skillCount) {
    this.skillCount = skillCount;
  }

  public int getComboCount() {
    return this.comboMaxCount;
  }

  public void setComboCount(int comboMaxCount) {
    this.comboMaxCount = comboMaxCount;
  }

  public String getWinlose() {
    return this.winlose;
  }

  public void setWinlose(String winlose) {
    this.winlose = winlose;
  }

  public String getNickName() {
    return nickName;
  }

  public int getSkill() {
    return skill;
  }

  public void setSkill(int skill) {
    this.skill = skill;
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public Info getCommand() {
    return command;
  }

  public String getMessage() {
    return message;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setCommand(Info command) {
    this.command = command;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStep() {
    return step;
  }

  public void setStep(int step) {
    this.step = step;
  }

  public int getMoveX() {
    return moveX;
  }

  public void setMoveX(int moveX) {
    this.moveX = moveX;
  }

  public int getSeed() {
    return seed;
  }

  public void setSeed(int seed) {
    this.seed = seed;
  }

  public int getCharIdx() {
    return charIdx;
  }

  public void setCharIdx(int charIdx) {
    this.charIdx = charIdx;
  }
}
