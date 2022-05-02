package mb.equipme_rent_service.services;

import java.util.List;

public interface BaseService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
