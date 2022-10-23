from bs4 import BeautifulSoup

f = open("members.html",encoding="utf-8")
soup = BeautifulSoup(f.read(), "html.parser")

dataFile = open("src/main/resources/data.sql","w",encoding="utf-8")
_members = soup.find_all("tr")
for member in _members:
    teamName = member.find("span",class_="teamName").text
    teamNameAbbrev = member.find("span", class_="teamAbbrev").text
    dataFile.write("INSERT INTO ESPN_TEAM (TEAM_NAME, TEAM_NAME_ABBREV) VALUES (\'" + teamName + "\',\'" + teamNameAbbrev + "\');\n")

dataFile.close()