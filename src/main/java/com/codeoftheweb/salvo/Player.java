package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private long id;

    private String userName;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    private
    List<GamePlayer> gamePlayers;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    private
    List<Score> scores;

    private String password;

    public Player () { }

    public Player(String user, String password) {
        setUserName(user);
        setPassword(password);
    }

    //Para obtener la lista de Scores (Wins, Loses, Draws)
    public float getScore(Player player) {
        return getWins(player.getScores())*1
                + getDraws(player.getScores())*((float)0.5)
                + getLoses(player.getScores())*0;
    }

    public float getWins(List<Score> scores){
        return scores
                .stream()
                .filter(score -> score.getScore() == 1)
                .count();
    }

    public float getDraws(List<Score> scores){
        return scores
                .stream()
                .filter(score -> score.getScore() == 0.5)
                .count();
    }

    public float getLoses(List<Score> scores){
        return scores
                .stream()
                .filter(score -> score.getScore() == 0)
                .count();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id; }

    public void setId(long id) {
        this.id = id;
    }

    public List<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(List<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}

