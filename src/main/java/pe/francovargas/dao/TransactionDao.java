package pe.francovargas.dao;

import io.reactivex.Completable;
import pe.francovargas.model.domain.Transaction;

public interface TransactionDao {

    Completable save(Transaction transaction);

}
