package Exceptions;

public class GameOverException extends Exception {
    boolean WinningTeam;

    public GameOverException(Boolean WinningTeam){
        this.WinningTeam = WinningTeam;
    }
}
