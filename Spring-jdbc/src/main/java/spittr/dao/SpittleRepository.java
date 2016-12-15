package spittr.dao;

import spittr.entity.Spittle;

import java.util.List;

/**
 * Author LPJ
 * Date 2016/12/15
 */
public interface SpittleRepository {
    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterId);

    void delete(long id);
}
