package com.ogulcank.fantasyApp.models;

public class EspnPlayerRequest {
    private String playerName;
    private String playerTeam;
    private String playerPos;
    private String teamNameAbbrev;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public String getTeamNameAbbrev() {
        return teamNameAbbrev;
    }

    public void setTeamNameAbbrev(String teamNameAbbrev) {
        this.teamNameAbbrev = teamNameAbbrev;
    }
}
