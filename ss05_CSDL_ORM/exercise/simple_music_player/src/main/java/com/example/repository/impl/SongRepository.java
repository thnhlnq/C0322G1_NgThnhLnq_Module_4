package com.example.repository.impl;

import com.example.model.Song;
import com.example.repository.ConnectionUtil;
import com.example.repository.ISongRepository;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SongRepository implements ISongRepository {

    @Override
    public List<Song> findAll() {
//        Session session = null;
//        List<Song> songs = null;
//
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            songs = session.createQuery("from Song").getResultList();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return songs;
        TypedQuery<Song> query = ConnectionUtil.entityManager.createQuery("select s from Song as s", Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
//        Transaction transaction = null;
//        Session session = null;
//
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//
//            session.save(song);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }

        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        return ConnectionUtil.entityManager.find(Song.class, id);
    }

    @Override
    public void edit(int id, Song song) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void delete(Song song) {
        EntityTransaction entityTransaction = ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(findById(song.getId()));
        entityTransaction.commit();
    }
}
