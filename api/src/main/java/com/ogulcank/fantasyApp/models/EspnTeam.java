package com.ogulcank.fantasyApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ESPN_TEAM")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EspnTeam {

    @Id
    @Column(name = "TEAM_NAME")
    private String teamName;
    @Column(name = "TEAM_NAME_ABBREV")
    private String teamNameAbbrev;

    @OneToMany(mappedBy = "espnTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EspnPlayer> espnPlayerList = new ArrayList<EspnPlayer>();
}
