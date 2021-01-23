# springboot-kafka-producer

- Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

- Start Kafka Server
bin/kafka-server-start.sh config/server.properties

- Create Kafka Topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic bday-notification-events

- Start consumer to consume messages
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning

topic-name: bday-notification-events
partitions: 1
replication-factor: 1 

WebService
http://localhost:8080/kafka/publish

message format
{
  "name": "John",
  "dob": "2010-01-01",
  "email": "john@gmail.com",
  "mobileNumber": "9122000987"
}






