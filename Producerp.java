
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;

public class Producerp {
        public static  void main(String args[])
        {
            KafkaProducer producer;
            String broker ="localhost:9092";
            String topic ="newEven";
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,broker);
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
            producer = new KafkaProducer(props);
            Random rand = new Random();
            while (true)
                try {
                    int dataTosend = rand.nextInt(0, 1000);
                    String val = String.valueOf(dataTosend);
                    producer.send(new ProducerRecord(topic, val));
                    Thread.sleep(1000);
                }
            catch(Exception e){
                    System.out.println(e);
            }

        }
    }


