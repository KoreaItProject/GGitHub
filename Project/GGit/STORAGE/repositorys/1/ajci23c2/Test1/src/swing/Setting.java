package swing;

public class Setting {
    private String imgPath = "Test1/src/img/"; // img까지 경로
    private String soundPath = "Test1/src/sound/"; // img까지 경로
    private int blockCount = 250; // 생성할 블록 갯수
    private int hp[] = { 5, 6, 10 }; // hp
    private int gameTime = 100;// 게임 진행시간

    private String host = "leetaehyeon.shop";

    private int comlvl[][] = { { 700, 360, 290, 230, 190, 160, 130 }, // 쓰레드 속도
            { 5, 4, 3, 2, 2, 1, 1 }, // 틀릴확률
            { 300, 240, 180, 160, 140, 130, 110 }// 머뭇거림시간
    };

    private String charName[] = { "snowChar", "ghostChar", "miraChar" };
    private int charW[] = { 180, 130, 100 }, charH[] = { 180, 130, 100 }, charX[] = { 410, 430, 460 },
            charY[] = { 330, 375, 410 };

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getImgPath() {
        return imgPath;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int[] getHp() {
        return hp;
    }

    public String[] getCharName() {
        return charName;
    }

    public void setCharName(String[] charName) {
        this.charName = charName;
    }

    public void setHp(int[] hp) {
        this.hp = hp;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public int[] getCharW() {
        return charW;
    }

    public void setCharW(int[] charW) {
        this.charW = charW;
    }

    public int[] getCharH() {
        return charH;
    }

    public void setCharH(int[] charH) {
        this.charH = charH;
    }

    public int[] getCharX() {
        return charX;
    }

    public void setCharX(int[] charX) {
        this.charX = charX;
    }

    public int[] getCharY() {
        return charY;
    }

    public void setCharY(int[] charY) {
        this.charY = charY;
    }

    public int[][] getComlvl() {
        return comlvl;
    }

    public void setComlvl(int[][] comlvl) {
        this.comlvl = comlvl;
    }

}
