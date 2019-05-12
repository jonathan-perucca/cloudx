## TLDR;

Use this example when you want to broadcast message towards many apps (a.k.a **pub-sub**) 

## gamer-creator-pub-sub
- running on port **8002**
- declaring **gamer.fanout** on rabbitmq through rabbit-admin
- sending message on bus on exchange **gamer.fanout**

## gamer-emailer-pub-sub
- running on port **8001**
- logging each game creation message received on auto-delete queue **gamer.emailer.queue**
- declaring binding between fanout **gamer.fanout** and queue **gamer.emailer.queue**
- has a strong dependency on where is located rabbitmq
- but ! do handle message asynchronously (timely decoupled)

## gamer-logevent-pub-sub
- running on port **8003**
- logging each game creation message received on auto-delete queue **gamer.logevent.queue**
- declaring binding between fanout **gamer.fanout** and queue **gamer.logevent.queue**
- has a strong dependency on where is located rabbitmq
- but ! do handle message asynchronously (timely decoupled)

## container mode
- both containers are exposed on host network

## When to use
- an app (gamer-creator) needs to broadcast an event without knowing which app listens to it
- each apps (gamer-emailer & gamer-logevent) need to listen to messages from **gamer.fanout** exchange