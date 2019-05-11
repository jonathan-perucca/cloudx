## gamer-creator
- running on port **8002**
- declaring **gamer.queue** on rabbitmq through rabbit-admin
- sending message on bus on queue **gamer.queue**

## gamer-emailer
- running on port **8001**
- logging each game creation message received on **gamer.queue**
- has a strong dependency on where is located rabbitmq
- but ! do handle message asynchronously (timely decoupled)

## container mode
- both containers are exposed on host network

## When to use
- an app (gamer-creator) needs to emit an event without knowing which app listens to it
- an app (gamer-emailer) is the only listening to this queue (if another app listens to this queue, messages will be load balanced a.k.a worker-queues)