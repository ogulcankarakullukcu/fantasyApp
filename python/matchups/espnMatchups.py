from bs4 import BeautifulSoup
import json

f = open("./matchups/espnMatchups.html")
soup = BeautifulSoup(f.read(), "html.parser")

matchups = []
_matchups = soup.find_all("tr",class_="Table__TR")
id = 1
for _matchup in _matchups:
    matchupId = id
    matchupName = _matchup.find("div").text
    teamName = _matchup.find("span",class_="teamName")['title']
    matchups.append({"id": id, "matchupName" : matchupName, "teamName": teamName})
    print("INSERT INTO ogulcank.MATCHUP VALUES ('" + str(id) + "','" + matchupName + "','" + teamName + "');")
    id += 1

f = open("./matchups/espnMatchups.json","w")
f.write(json.dumps(matchups,ensure_ascii=False,indent=4,separators=(',',': ')))
f.close()

