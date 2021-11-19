package com.lab3_3.lab3_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lab3_3.lab3_3.Movie;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public List<Movie> findByTitle(String title);

}
