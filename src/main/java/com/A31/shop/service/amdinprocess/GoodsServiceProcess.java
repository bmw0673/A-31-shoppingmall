package com.A31.shop.service.amdinprocess;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.A31.shop.domain.dto.GoodsCategorySaveDTO;
import com.A31.shop.domain.dto.GoodsImgSaveDTO;
import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.dto.GoodsSaveDTO;
import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.domain.dto.PageResultDTO;
import com.A31.shop.domain.entity.goods.CateEntityRepository;
import com.A31.shop.domain.entity.goods.CategoryEntity;
import com.A31.shop.domain.entity.goods.GoodsCategory;
import com.A31.shop.domain.entity.goods.GoodsCategoryRepogitory;
import com.A31.shop.domain.entity.goods.GoodsEntity;
import com.A31.shop.domain.entity.goods.GoodsEntityRepository;
import com.A31.shop.domain.entity.goods.GoodsImgEntity;
import com.A31.shop.domain.entity.goods.GoodsImgEntityRepository;
import com.A31.shop.service.admin.GoodsService;
import com.amazonaws.services.s3.AmazonS3Client;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class GoodsServiceProcess implements GoodsService {
	
	@Value("${cloud.aws.s3.bucket}")
	private String bucketName;
	@Value("${cloud.aws.s3.upload-temp}")
	private String tempPath;
	@Value("${cloud.aws.s3.upload-path}")
	private String uploadPath;
	
	private final AmazonS3Client client;
	
	private final GoodsEntityRepository goodsRepo;
	
	private final GoodsImgEntityRepository imgRepo;
	
	private final FileUplodUtil fileUplodUtil;
	
	private final CateEntityRepository categoryRepo;
	
	private final GoodsCategoryRepogitory goodscateRepo;
	@Override
	public Map<String, String> s3fileUploadPrecess(MultipartFile goodsImg) {
		return fileUplodUtil.s3Upload(client, bucketName, tempPath, goodsImg);
	}
	

	@Override
	public void saveProcess(GoodsSaveDTO goods, GoodsImgSaveDTO goodsImg, GoodsCategorySaveDTO goodsCate) {
		//1.상품저장
		GoodsEntity goodsEntity = goodsRepo.save(goods.toEntity());
		
		goodscateRepo.save(GoodsCategory.builder()
					.category(categoryRepo.findById(goodsCate.getCategoryId()).get())
					.goods(goodsEntity)
					.build());
		
		int size=goodsImg.getOrgName().length;
		
		
		for(int i=0; i<size; i++) {
			//2.s3이동
			String uploadKey=fileUplodUtil.fromTempToImages(client, bucketName, uploadPath, goodsImg.getTempKey()[i], goodsImg.getOrgName()[i]);
			//3.이미지저장
			if(i==0) {
				imgRepo.save(GoodsImgEntity.builder()
						.orgName(goodsImg.getOrgName()[i]).bucketKey(uploadKey)
						.goods(goodsEntity).thumbnail(true)
						.build());
			}else {
				imgRepo.save(GoodsImgEntity.builder()
						.orgName(goodsImg.getOrgName()[i]).bucketKey(uploadKey)
						.goods(goodsEntity).thumbnail(false)
						.build());
			}
		}
		
		
		
	}


	/**
	 * 상품조회
	 */
	@Override
	public PageResultDTO<GoodsListDTO, GoodsEntity> getList(PageRequestDTO requestDTO) {
		
		Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());
		
		Page<GoodsEntity> result = goodsRepo.findAll(pageable);
		
		Function<GoodsEntity, GoodsListDTO> fn = entity -> entity.toListDTO();
		
		return new PageResultDTO<>(result, fn);
	}

	/**
	 * 상품등록화면 이동 시 카테고리 불러오기 
	 */
	@Override
	public List<CategoryEntity> getCategoty() {
		List<CategoryEntity> categories = null;
		categories = categoryRepo.findAll();
		return categories;
	}

	/**
	 * 상품상세페이지 데이터 불러오기 
	 */
	@Override
	public void readGoods(Long goodsId, Model model) {
		GoodsListDTO goods = goodsRepo.findById(goodsId).orElseThrow().toDetailDTO();
		model.addAttribute("goods", goods);
	}

}
