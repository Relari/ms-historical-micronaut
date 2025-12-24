package pe.francovargas.dao.impl;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.TransactionDao;
import pe.francovargas.dao.db.repository.TransactionRepository;
import pe.francovargas.dao.mapper.TransactionMapper;
import pe.francovargas.model.domain.Transaction;


@Singleton
@AllArgsConstructor
public class TransactionDaoImpl implements TransactionDao {

    private final TransactionRepository transactionRepository;

    @Override
    public Completable save(Transaction transaction) {
        return Single.fromCallable(() -> TransactionMapper.mapAccountEntity(transaction))
                .map(transactionRepository::save)
                .subscribeOn(Schedulers.io())
                .ignoreElement();
    }

}
