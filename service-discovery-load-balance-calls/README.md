## gamer-session
- running on port [**8002**:**8006**]
- exposing currently played game with its host property on **/game**

## gamer-center
- running on port **8001**
- loadbalancing question on one gamer-session instance
- logging a monitor report on which instance replied
- has a strong dependency on where is located consul
- but ! do handle dynamically gamer-session instance scaling 

## container mode
- both containers are exposed on host network

## When to use
- a dynamic number of application (A) instances exist
- an application (B) needs to reach only one application (A) from the instance pool