package com.abdullah.auth.repository;

import java.util.Map;

import com.abdullah.auth.model.Movie;

public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<Object, Object> findAllMovies();

    /**
     * Add key-value pair to Redis.
     */
    void add(Movie movie);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);
    
    /**
     * find a movie
     */
    Movie findMovie(String id);
    
}
