# pulsar-perf-test

Build with:
`mvn clean install`

Run it with the following arguments:
```
 java -cp target/uber-pulsarperftest-1.0-SNAPSHOT.jar  io.confluent.hacks.ProducerPerformance --topic persistent://public/default/test2 --record-size 512 --throughput 60000 --num-records 54000000 --producer-props bootstrap.servers=pulsar://pulsar.platformops.dev.gcp.devel.cpdev.cloud:9092 acks=all linger.ms=10
```
