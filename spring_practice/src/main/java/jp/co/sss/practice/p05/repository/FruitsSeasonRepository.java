package jp.co.sss.practice.p05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.practice.p05.entity.FruitsSeason;

public interface FruitsSeasonRepository extends JpaRepository<FruitsSeason, Integer>{

//	season_month列で昇順に並べ替え(p5-02)
	List<FruitsSeason> findAllByOrderBySeasonMonth();
	
//	fruit_id 列で昇順に並べ替え(p5-03)
	List<FruitsSeason> findAllByOrderByFruitId();
	
//	season_month列で絞込検索してfruit_id 列で昇順に並べ替え(p5-04)
	List<FruitsSeason> findBySeasonMonthOrderByFruitId(Integer season);
	
}
