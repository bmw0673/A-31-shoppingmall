package com.A31.shop.adminTest;

import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.A31.shop.domain.entity.goods.GoodsEntity;
import com.A31.shop.domain.entity.goods.GoodsEntityRepository;
import com.A31.shop.domain.entity.goods.GoodsImgEntity;
import com.A31.shop.service.amdinprocess.GoodsCategoryProcess;

//@SpringBootTest
public class GoodsTest {

	@Autowired
	GoodsEntityRepository repo;

	@Autowired
	GoodsCategoryProcess service;

	/**
	 * 상품 더미테이블 생성
	 */
	public void insertDummies() {
		IntStream.range(1, 101).forEach(i -> {

			GoodsEntity en = GoodsEntity.builder()
					.name("상품명" + i)
					.price(1000 + i)
					.stockQuantity(100)
					.content("" + i)
					.build();

			System.out.println(repo.save(en));
		});
	}


	@Transactional
	//@Test
	public void test() {
		service.getMdList().forEach(System.out::println);
	}

	@Transactional
	//@Test
	public void test2() {
		service.getNewList().forEach(System.out::println);
	}
}
