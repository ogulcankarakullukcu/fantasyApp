package com.ogulcank.fantasyApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EspnPlayer {

    @Id
    private String playerName;
    private String playerTeam;
    private String playerPosition;
    private String matchupNo;

    @ManyToOne
    @JoinColumn(name = "teamName")
    private EspnTeam espnTeam;

    @OneToMany(mappedBy = "espnPlayer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Stat> statList = new ArrayList<Stat>();


}
