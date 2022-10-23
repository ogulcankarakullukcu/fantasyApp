package com.ogulcank.fantasyApp.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class YahooPlayer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NonNull
    private String playerName;
    @NonNull
    private String playerTeam;
    @NonNull
    private String playerPos;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "espnPlayerName")
    private EspnPlayer espnPlayer;
}
