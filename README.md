# pulsar-perf-test

Run it with the following arguments:
```
--topic perf-test --record-size 512 --throughput 60000 --num-records 54000000 --producer-props acks=all linger.ms=10
```
Change this line:
```
props.put("bootstrap.servers", "pulsar://localhost:6650");
```
if you want to connect to different Pulsar server.