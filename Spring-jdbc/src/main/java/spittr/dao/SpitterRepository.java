package spittr.dao;

import spittr.entity.Spitter;

import java.util.List;

/**
 * Author LPJ
 * Date 2016/12/15
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
