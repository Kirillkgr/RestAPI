package com.kirillzhdanov.learningrestapi.repository;

import com.kirillzhdanov.learningrestapi.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByid(Long id);

    Goods findByname(String name);

//    private Long idTableOne;
//    private Long idTableTwo;
//    private Long idTableThree;
//    private Long idTableFour;

    Goods findByIdTableFive(Long idTableFive);

}
