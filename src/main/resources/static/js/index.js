/**
 * 
 */

let currentSlide = 0;

function showSlide(n) {
	const slides = document.querySelectorAll('.slider-container.img');
	if (n >= slides.length) {
		currentSlide = 0;
	} else if (n < 0) {
		currentSlide = slides.length - 1;
	} else {
		currentSlide = n;
	}

	for (let i = 0; i < slides.length; i++) {
		slides[i].style.display = 'none';
	}

	slides[currentSlide].style.display = 'block';
}

function nextSlide() {
	showSlide(currentSlide + 1);
}

function prevSlide() {
	showSlide(currentSlide - 1);
}

// 자동으로 슬라이드 전환
function autoSlide() {
	nextSlide();
	setTimeout(autoSlide, 3000); // 3초마다 슬라이드 전환
}

autoSlide(); // 최초에 한 번 실행

$(function () {
	$(window).resize(function () {
		var ww = $(window).width();
		if (ww < 1900) {
			$(".slider-container").width(ww);
			if (ww < 1180) {
				$(".slider-container").width(1180);
			}
		} else {
			$(".slider-container").width(1900);
		}
	});
});


/////////////////////////////////////////////////////////////////////////

    
    