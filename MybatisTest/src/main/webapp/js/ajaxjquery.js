/**
 * 	ajaxjquery.js
 */
console.log('ajaxjquery');

$(function() {
	//도서목록 json 타입 -> 화면에 출력.
	$.ajax({
		url: '',
		method: 'get',
		success: function(result) {
			console.log(result);
		},
		error: function(error) {
			console.log(error);
		}
	});
});