var word_class_name = 'W_W_T';

var canon = function(word) {
	return word.toLowerCase();
};

var translatify = function(text) {
	$('#out-text').empty();
	var regex = /\[(\w+)\|([\u0590-\u05ff]+)\]/;
	var src_text = text.replace(/(\n|\n\r){2}/g,'<br>');

	var sections = src_text.split(regex);

	var i = 0;
	var out_html = '';
	while (i < sections.length)
	{
		out_html += sections[i];
		if (i % 3 === 0)
		{
			i+=1;
		}
		else
		{
			var word = sections[i];
			var tran = sections[i+1];
			var trans_span = '<span class="' + word_class_name + ' ' + canon(word) +'">('+ tran + ')</span>';
			out_html += trans_span;
			i+=2;
		}
	}

	$('#out-text').append(out_html);	
};

$(document).ready(function() {
	translatify($('#src-text').val());
	$('#src-text').bind('input propertychange', function() {
		translatify($('#src-text').val());
	});

	$(document).on('click','.' + word_class_name, function() {
		var class_name = $(this).attr('class').split(' ')[1];
		$('.'+class_name).fadeOut('slow');
		$('#known-words').append('<li>' + class_name + '</li>');
	});

	$(document).on('click','#known-words li', function() {
		var class_name = $(this).text();
		$('.'+class_name).fadeIn('slow');
		$(this).remove();	
	});
});
