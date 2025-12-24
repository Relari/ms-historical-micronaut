package pe.francovargas.dao.mapper;

import pe.francovargas.dao.db.entity.TransactionEntity;
import pe.francovargas.model.domain.Currency;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.model.domain.TransactionType;

public class TransactionMapper {

    private TransactionMapper() {}

    public static TransactionEntity mapAccountEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .idAccount(transaction.getIdAccount())
                .amount(transaction.getAmount())
                .currency(Currency.valueOf(transaction.getCurrency()))
                .type(TransactionType.valueOf(transaction.getType()))
                .creationDate(transaction.getCreationDate())
                .build();
    }

}
