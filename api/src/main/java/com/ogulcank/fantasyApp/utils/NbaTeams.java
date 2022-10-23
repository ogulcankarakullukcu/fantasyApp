package com.ogulcank.fantasyApp.utils;

import java.util.HashMap;
import java.util.Map;

public enum NbaTeams {
    ATL("ATL", "Atl"),
    BKN("BKN", "Bkn"),
    BOS("BOS", "Bos"),
    CHA("CHA", "Cha"),
    CHI("CHI", "Chi"),
    CLE("CLE", "Cle"),
    DAL("DAL", "Dal"),
    DEN("DEN", "Den"),
    DET("DET", "Det"),
    GSW("GSW", "GS"),
    HOU("HOU", "Hou"),
    IND("IND", "Ind"),
    LAC("LAC", "LAC"),
    LAL("LAL", "LAL"),
    MEM("MEM", "Mem"),
    MIA("MIA", "Mia"),
    MIL("MIL", "Mil"),
    MIN("MIN", "Min"),
    NOP("NOP", "NO"),
    NYK("NYK", "NY"),
    OKC("OKC", "OKC"),
    ORL("ORL", "Orl"),
    PHI("PHI", "Phi"),
    PHX("PHX", "Phx"),
    POR("POR", "Por"),
    SAC("SAC", "Sac"),
    SAS("SAS", "SA"),
    TOR("TOR", "Tor"),
    UTA("UTA", "Utah"),
    WAS("WAS", "Wsh");

    private final String yahooProTeamName;
    private final String espnProTeamName;

    NbaTeams(String yahooProTeamName, String espnProTeamName) {
        this.yahooProTeamName = yahooProTeamName;
        this.espnProTeamName = espnProTeamName;
    }

    public String getYahooProTeamName(){
        return this.yahooProTeamName;
    }

    public String getEspnProTeamName(){
        return this.espnProTeamName;
    }

    public static String valueOfYahooProTeamName(String yahooProTeamName){
        return NbaTeams.valueOf(yahooProTeamName).getEspnProTeamName();
    }

}
