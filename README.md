# pulsar-perf-test

Build with:
`mvn clean install`

Run it with the following arguments:
```
 java -cp ~/workspaces/pulsar-perf-test/target/uber-pulsarperftest-1.0-SNAPSHOT.jar  io.confluent.hacks.ProducerPerformance --topic perf-test --record-size 512 --throughput 60000 --num-records 54000000 --producer-props bootstrap.servers=pulsar://pulsar.platformops.dev.gcp.devel.cpdev.cloud:9092 acks=all linger.ms=10
```