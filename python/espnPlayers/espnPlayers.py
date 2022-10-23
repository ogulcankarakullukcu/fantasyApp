from bs4 import BeautifulSoup
import json

f = open("./espnPlayers/espnPlayers.html",encoding="utf-8")
soup = BeautifulSoup(f.read(), "html.parser")

_players = soup.find_all("tr")
players = []
for _player in _players:
    playerName = _player.find("div")['title']
    playerTeam = _player.find("span",class_="playerinfo__playerteam").text
    playerPos = _player.find("span", class_="playerinfo__playerpos").text.replace("\n","").replace(" ","")
    teamNameAbbrev = _player.find("span", class_="teamAbbrev").text
    players.append({"playerName": playerName, "playerTeam": playerTeam, "playerPos": playerPos,"teamNameAbbrev": teamNameAbbrev})


espnPlayersFile = open("./espnPlayers/espnPlayers.json","w",encoding="utf-8")
json.dump(players,fp= espnPlayersFile ,ensure_ascii=False,indent=4,separators=(',',': '))
espnPlayersFile.close()