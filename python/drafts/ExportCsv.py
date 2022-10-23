from bs4 import BeautifulSoup
import pandas as pd

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
    _stats["name"] = _player
    _stats["team"] = _playerTeam
    _stats["position"] = _playerPos
    stats = player.find_all('td',class_="stat-column")
    for stat in stats:
        _title = stat.find("div")["title"]
        _stat = float(trimText(stat.find("div").text))
        _stats[_title] = _stat
    _players.append(_stats)

fieldGoalPercentageAVG = df['Field Goal Percentage'].mean()
freeThrowPercentageAVG = df['Free Throw Percentage'].mean()
threePointersPerGameAVG = df['Three Pointers Per Game'].mean()
reboundsPerGameAVG = df['Rebounds Per Game'].mean()
assistsPerGameAVD = df['Assists Per Game'].mean()
stealsPerGameAVG = df['Steals Per Game'].mean()
blocksPerGameAVG = df['Blocks Per Game'].mean()
turnoverPerGameAVG = df['Turnovers Per Game'].mean()
pointsPerGameAVG = df['Points Per Game'].mean()

for r in _players:
    r['Field Goal Percentage'] = 'Yes' if r['Field Goal Percentage'] >= fieldGoalPercentageAVG else 'No'
    r['Free Throw Percentage'] = 'Yes' if r['Free Throw Percentage'] >= freeThrowPercentageAVG else 'No'
    r['Three Pointers Per Game'] = 'Yes' if r['Three Pointers Per Game'] >= threePointersPerGameAVG else 'No'
    r['Rebounds Per Game'] = 'Yes' if r['Rebounds Per Game'] >= reboundsPerGameAVG else 'No'
    r['Assists Per Game'] = 'Yes' if r['Assists Per Game'] >= assistsPerGameAVD else 'No'
    r['Steals Per Game'] = 'Yes' if r['Steals Per Game'] >= stealsPerGameAVG else 'No'
    r['Blocks Per Game'] = 'Yes' if r['Blocks Per Game'] >= blocksPerGameAVG else 'No'
    r['Turnovers Per Game'] = 'Yes' if r['Turnovers Per Game'] >= turnoverPerGameAVG else 'No'
    r['Points Per Game'] = 'Yes' if r['Points Per Game'] >= pointsPerGameAVG else 'No'

df = pd.DataFrame(_players)
df.to_csv('myFile.csv')