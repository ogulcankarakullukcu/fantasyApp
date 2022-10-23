package com.ogulcank.fantasyApp.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StatRequest {
    private String playerName;
    private String playerTeam;
    private String playerPos;
    private String fieldGoalsMade;
    private String fieldGoalsAttempted;
    private String freeThrowsMade;
    private String freeThrowsAttempted;
    private String threePointShotsMade;
    private String pointsScored;
    private String totalRebounds;
    private String assists;
    private String steals;
    private String blockedShots;
    private String turnovers;

}
