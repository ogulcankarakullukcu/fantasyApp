package com.ogulcank.fantasyApp.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Stat {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Double fieldGoalsMade;
    private Double fieldGoalsAttempted;
    private Double freeThrowsMade;
    private Double freeThrowsAttempted;
    private Double threePointShotsMade;
    private Double pointsScored;
    private Double totalRebounds;
    private Double assists;
    private Double steals;
    private Double blockedShots;
    private Double turnovers;
    private String matchupNo;

    @ManyToOne
    @JoinColumn(name = "espnPlayer")
    private EspnPlayer espnPlayer;
}
