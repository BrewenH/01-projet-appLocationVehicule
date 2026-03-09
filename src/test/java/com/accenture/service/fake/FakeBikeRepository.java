package com.accenture.service.fake;

import com.accenture.models.Bike;
import com.accenture.repository.BikeRepository;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class FakeBikeRepository implements BikeRepository {
    public final Map<UUID, Bike> store = new HashMap<>();

    @Override
    public <S extends Bike> S save(S entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Bike> findById(UUID uuid) {
        return Optional.ofNullable(store.get(uuid));
    }

    @Override
    public List<Bike> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(UUID uuid) {
        store.remove(uuid);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return store.containsKey(uuid);
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public void delete(Bike entity) {
        if (entity != null) {
            store.remove(entity.getId());
        }
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        for (UUID id : uuids) {
            store.remove(id);
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Bike> entities) {
        for (Bike b : entities) {
            if (b != null) {
                store.remove(b.getId());
            }
        }
    }

    @Override
    public void deleteAll() {
        store.clear();
    }

    @Override
    public <S extends Bike> List<S> saveAll(Iterable<S> entities) {
        List<S> res = new ArrayList<>();
        for (S e : entities) {
            res.add(save(e));
        }
        return res;
    }

    @Override
    public List<Bike> findAllById(Iterable<UUID> uuids) {
        List<Bike> res = new ArrayList<>();
        for (UUID id : uuids) {
            Bike r = store.get(id);
            if (r != null) res.add(r);
        }
        return res;
    }

    @Override
    public List<Bike> findAll(Sort sort) {
        return new ArrayList<>(store.values());
    }

    @Override
    public Page<Bike> findAll(Pageable pageable) {
        List<Bike> list = new ArrayList<>(store.values());
        return new PageImpl<>(list, pageable, list.size());
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllInBatch(Iterable<Bike> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bike getOne(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bike getById(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Bike getReferenceById(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> long count(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Bike, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException();
    }
}
