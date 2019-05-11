## gamer-creator
- running on port **8002**
- declaring **gamer.queue** on rabbitmq through rabbit-admin
- sending message on bus on queue **gamer.queue**

## gamer-emailer
- running on port **8001** & **8003**
- logging each game creation message received on **gamer.queue**
- each instance consume messages from queue with a round-robin dispatch
- has a strong dependency on where is located rabbitmq
- but ! do handle message asynchronously (timely decoupled)
- and ! distribute workload on all queue consumer

## container mode
- both containers are exposed on host network

## When to use
- an app (gamer-creator) needs to emit an event without knowing which app listens to it
- app instances (gamer-emailer) need to have distributed workload