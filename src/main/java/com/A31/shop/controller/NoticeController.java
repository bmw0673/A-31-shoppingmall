/*
 * package com.A31.shop.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.A31.shop.domain.dto.NoticeDTO; import
 * com.A31.shop.domain.dto.NoticeResponse; import
 * com.A31.shop.domain.dto.UpdateNoticeRequest; import
 * com.A31.shop.domain.entity.Notice; import com.A31.shop.service.NoticeService;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RestController
 * 
 * @RequiredArgsConstructor public class NoticeController {
 * 
 * private final NoticeService noticeService;
 * 
 * @PostMapping("/admin/notices") // 공지사항 등록(관리자용) public ResponseEntity<Notice>
 * addNotice(@RequestBody NoticeDTO dto) { Notice
 * savedNotice=noticeService.save(dto); return
 * ResponseEntity.status(HttpStatus.CREATED) .body(savedNotice); }
 * 
 * @GetMapping("/admin/notices") // 공지사항 전체조회 (관리자용) public
 * ResponseEntity<List<NoticeResponse>> findAllNotices() { List<NoticeResponse>
 * notices=noticeService.findAll() .stream() .map(NoticeResponse::new)
 * .toList();
 * 
 * return ResponseEntity.ok() .body(notices); }
 * 
 * @GetMapping("/admin/notices/{no}") //공지사항 한개 찾기 public
 * ResponseEntity<NoticeResponse> findNotice(@PathVariable long no) { Notice
 * notice = noticeService.findById(no);
 * 
 * return ResponseEntity.ok() .body(new NoticeResponse(notice)); }
 * 
 * @DeleteMapping("/admin/notices/{no}") public ResponseEntity<Void>
 * deleteNotice(@PathVariable long no){ noticeService.delete(no);
 * 
 * return ResponseEntity.ok() .build(); }
 * 
 * @PutMapping("/admin/notices/{aa}") public ResponseEntity<Notice>
 * updateNotice(@PathVariable(name = "aa") long no, @RequestBody
 * UpdateNoticeRequest request) { Notice updatedNotice =
 * noticeService.update(no, request);
 * 
 * return ResponseEntity.ok() .body(updatedNotice); } }
 */