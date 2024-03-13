/**
 * 
 */
$(document).ready(function () {
	
				var hiddenBestItems = $('.best_item_list li.hidden');
					for (let i = 0; i < 4; i++) {
					$(hiddenBestItems[i]).removeClass('hidden');
				}
				
				var hiddenNewItems = $('.new_item_list li.hidden');
					for (let i = 0; i < 4; i++) {
					$(hiddenNewItems[i]).removeClass('hidden');
				}
			$('#bestMoreBtn').on('click', function () {
				// hidden 클래스를 가진 상품들을 찾아서 보이도록 변경
				hiddenBestItems = $('.best_item_list li.hidden');
				for (let i = 0; i < 4; i++) {
					$(hiddenBestItems[i]).removeClass('hidden');
				}
				// 모든 상품이 보이면 더보기 버튼을 숨김
				if (hiddenBestItems.length <= 4) {
					$(this).hide();
				}
			});
		});
		$(document).ready(function () {
			$('#newMoreBtn').on('click', function () {
				// hidden 클래스를 가진 상품들을 찾아서 보이도록 변경
				hiddenNewItems = $('.new_item_list li.hidden');
				for (let i = 0; i < 4 && i < hiddenNewItems.length; i++) {
					$(hiddenNewItems[i]).removeClass('hidden');
				}
				// 모든 상품이 보이면 더보기 버튼을 숨김
				if (hiddenNewItems.length <= 4) {
					$(this).hide();
				}
			});
		});