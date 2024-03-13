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
 * import com.A31.shop.domain.dto.QnaDTO; import
 * com.A31.shop.domain.dto.QnaResponse; import
 * com.A31.shop.domain.dto.UpdateNoticeRequest; import
 * com.A31.shop.domain.entity.Qna; import com.A31.shop.service.QnaService;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RestController
 * 
 * @RequiredArgsConstructor public class QnaController {
 * 
 * private final QnaService qnaService;
 * 
 * 
 * @PostMapping("/admin/qna/{qnaNO}") public ResponseEntity<Qna>
 * addQna(@RequestBody QnaDTO dto) { Qna savedQna=qnaService.save(dto); return
 * ResponseEntity.status(HttpStatus.CREATED) .body(savedQna); }
 * 
 * @GetMapping("/admin/qna") // 문의사항 전체조회 (관리자용) public
 * ResponseEntity<List<QnaResponse>> findAllQna() { List<QnaResponse>
 * qna=qnaService.findAll() .stream() .map(QnaResponse::new) .toList();
 * 
 * return ResponseEntity.ok() .body(qna); }
 * 
 * @GetMapping("/admin/qna/{no}") //문의사항 한개 찾기 public
 * ResponseEntity<QnaResponse> findQna(@PathVariable long no) { Qna qna =
 * qnaService.findById(no);
 * 
 * return ResponseEntity.ok() .body(new QnaResponse(qna)); }
 * 
 * // @DeleteMapping("/admin/qna/{qnaNo}") // public ResponseEntity<Void>
 * deleteQna(@PathVariable(name = "qnaNo") long no){ // qnaService.delete(no);
 * // // return ResponseEntity.ok() // .build(); // } // // //
 * // @PutMapping("/admin/qna/{qnaNo}") // public ResponseEntity<Qna>
 * updateQna(@PathVariable(name = "qnaNo") long no, @RequestBody
 * UpdateNoticeRequest request) { // Qna updatedQna = qnaService.update(no,
 * request); // // return ResponseEntity.ok() // .body(updatedQna); // } }
 */