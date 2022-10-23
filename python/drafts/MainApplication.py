from bs4 import BeautifulSoup
import json

page = open("page.txt", "r")

def trimText(text):
    return text.replace('\n',' ').replace(' ','')

soup = BeautifulSoup(page.read(),"html.parser")

players = soup.find_all("tr", class_="Table__TR")


_players = []
for player in players:
    if len(_players) == 182:
        break
    _stats = {}
    _player = trimText(player.find("a").text)
    _playerTeam = trimText(player.find("span",class_="playerinfo__playerteam").text)
    _playerPos = trimText(player.find("span",class_ = "playerinfo__playerpos").text)
    stats = player.find_all('td',class_="stat-column")
    for stat in stats:
        _title = stat.find("div")["title"]
        _stat = trimText(stat.find("div").text)
        _stats[_title] = float(_stat)
    _players.append({"player" : _player,"team": _playerTeam, "position": _playerPos ,"stats" : _stats })

f = open("players.json","w")
f.write(json.dumps({"data" : _players},ensure_ascii=False,indent=4,separators=(',',': ')))
f.close()
