from bs4 import BeautifulSoup
import json

f = open("./yahooPlayers/yahooPlayers.html", encoding="utf-8")
soup = BeautifulSoup(f.read(), "html.parser")
players = []
_players = soup.find_all("tr")

for _player in _players:
    _rows = _player.find_all("td")
    _playerName = _rows[1].find("a", class_="Nowrap").text.replace("\n","")
    _playerTeamPos = _rows[1].find("span", class_="Fz-xxs").text.replace("\n","")
    _playerTeam = _playerTeamPos.split("-")[0].replace(" ", "").replace("\n","")
    _playerPos = _playerTeamPos.split("-")[1].replace(" ", "").replace("\n","")
    _fieldGoalsAttempted = _rows[12].find("div").text
    _fieldGoalsMade = _rows[13].find("div").text
    _freeThrowsAttempted = _rows[14].find("div").text
    _freeThrowsMade = _rows[15].find("div").text
    _threePointShotsMade = _rows[17].find("div").text
    _pointsScored = _rows[18].find("div").text
    _totalRebounds = _rows[19].find("div").text
    _assists = _rows[20].find("div").text
    _steals = _rows[21].find("div").text
    _blockedShots = _rows[22].find("div").text
    _turnovers = _rows[23].find("div").text
    players.append({"playerName": _playerName, "playerTeam": _playerTeam, "playerPos": _playerPos, 
                    "fieldGoalsAttempted": _fieldGoalsAttempted, "fieldGoalsMade": _fieldGoalsMade, 
                    "freeThrowsMade": _freeThrowsMade, "freeThrowsAttempted": _freeThrowsAttempted,
                    "threePointShotsMade": _threePointShotsMade, "pointsScored": _pointsScored, 
                    "totalRebounds": _totalRebounds, "assists": _assists, "steals": _steals, 
                    "blockedShots": _blockedShots, "turnovers": _turnovers})

file = open("./yahooPlayers/yahooPlayers.json", "w", encoding="utf-8")
json.dump(players, fp=file,indent=4,ensure_ascii=False,separators=(',',':'))
file.close()
