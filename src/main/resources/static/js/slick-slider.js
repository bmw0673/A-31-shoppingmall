/**
 * 
 */
$(document).ready(function () {
			$('.slider').slick({
				centerMode: true,
				slidesToShow: 1,
				dots: true,
				infinite: true,     //무한반복(true or false) 기본값 true
				autoplay: true,    //슬라이드 자동 시작(true or false) ▶기본값 false
				autoplaySpeed: 3000,        //슬라이드 자동 넘기기 시간(1000ms = 1초) 곧, 슬라이드 하나당 머무는 시간
				pauseOnDotsHover: true,     //네이게이션버튼 호버 시 슬라이드 멈춤 ▶기본값 false
				speed: 2000, //모션 시간 (얼마나 빠른속도로 넘어가는지)(1000ms = 1초) 곧, 슬라이드 사이에 넘어가는 속도
				variableWidth: true, 
				prevArrow: $('.slick-prev'),
				nextArrow: $('.slick-next')
			});
		});