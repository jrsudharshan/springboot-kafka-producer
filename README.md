# Springboot-kafka-producer

- Start Zookeeper <br />
bin/zookeeper-server-start.sh config/zookeeper.properties <br /><br />

- Start Kafka Server <br />
bin/kafka-server-start.sh config/server.properties <br /><br />

- Create Kafka Topic <br />
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic bday-notification-events <br /><br />

- Start consumer to consume messages<br />
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning<br /><br />

topic-name: bday-notification-events<br />
partitions: 1<br />
replication-factor: 1 <br /><br />

WebService<br />
http://localhost:8080/kafka/publish<br /><br />

message format: <br />
<pre> 
{<br />
   "name": "John",<br />
   "dob": "2010-01-01",<br />
   "email": "john@gmail.com",<br />
   "mobileNumber": "9122000987"<br />
}
<pre> 





