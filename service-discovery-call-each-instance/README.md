## gamer-session
- running on port [**8002**:**8006**]
- exposing currently played game on **/game**
- changing its currently played game every 8 seconds

## gamer-center
- running on port **8001**
- asking all existing gamer-session instance for each game played
- logging a monitor report on how many instance are playing each game
- has a strong dependency on where is located consul
- but ! do handle dynamically gamer-session instance scaling 

## container mode
- both containers are exposed on host network

## When to use
- a dynamic number of application (A) instances exist
- an application (B) needs to reach every application (A) instance endpoint 