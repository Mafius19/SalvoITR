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

    public Player () { }

    public Player(String user) {
        setUserName(user);
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}

