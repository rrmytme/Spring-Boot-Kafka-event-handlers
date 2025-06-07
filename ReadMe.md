This project will demonstrate how springboot services acted as producers/consumers and interact with kafka cluster and post/consume messages from relevant topic

Step1: Install Kafka from https://kafka.apache.org/downloads --> one of the Binary file
Step2: Add Spring for Kafka dependency
Step3: Start your spring app
Step4: Start kafka - zookeeper --> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Step5: Start kafka server --> .\bin\windows\kafka-server-start.bat .\config\server.properties
Step6: create kafka topic if require --> .\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
To list topics: .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
Step7: Start kafka producer if req --> .\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092
Step8: Start kafka consumer if req --> .\bin\windows\kafka-console-consumer.bat --topic test-topic --from-beginning --bootstrap-server localhost:9092
