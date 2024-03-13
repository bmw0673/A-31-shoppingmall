package com.A31.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.A31.shop.domain.entity.Notice;
public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
