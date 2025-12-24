package pe.francovargas.kafka.consumer;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Flowable;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.TransactionDao;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.util.JsonConverter;

@KafkaListener(
        clientId = "ms-deposit-micronaut-consumer",
        groupId = "external-group"
//        batch = true
)
@AllArgsConstructor
public class ExternalConsumer {

//    @Topic("external-topic")
//    void receive(String dataJson) {
//        System.out.println("Received transaction in external consumer: " + dataJson);
//    }

    private final TransactionDao transactionDao;

    @Topic("external-topic")
    void receive(Flowable<String> dataJson) {
        dataJson.map(json -> JsonConverter.fromJson(json, Transaction.class))
                .flatMapCompletable(transactionDao::save)
                .subscribe();
    }

}
