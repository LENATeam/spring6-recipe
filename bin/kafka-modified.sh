#!/usr/bin/env bash

docker compose -f docker-compose-kafka-modified.yml up -d
sleep 10
docker exec kafka /opt/kafka/bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic mails
