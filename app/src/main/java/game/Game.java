package game;

/**
 * Created by madooding on 8/24/16 AD.
 */
public class Game {

    public int showNum;
    private int secretNum;

    public Game(){
        this.reset();
    }

    public void reset(){
        this.secretNum = (int) (Math.random() * 9) + 1;
        this.showNum = (int) (Math.random() * 9) + 1;
    }

    public boolean isEqual(){
        boolean result = this.getSecretNum() == this.showNum;
        this.reset();
        return result;
    }

    public boolean isGreater(){
        boolean result = this.showNum > this.getSecretNum();
        this.reset();
        return result;
    }

    public boolean isLess(){
        boolean result = this.showNum < this.getSecretNum();
        this.reset();
        return result;
    }

    public int getSecretNum() {
        return secretNum;
    }

}
