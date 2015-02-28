var word_class_name = 'W_W_T';

var canon = function(word) {
	return word.toLowerCase();
};

var normal_text = function(text) {
	var words = text.split(/\s+/);
	for (i = 0; i < words.length; ++i)
    {
		if (words[i] === '')
			continue;
     	var word_to_add = $('<div class="normal">'+words[i]+'</div>');
        $('#out-text').append(word_to_add);
    }
};

var translatify = function(text) {
	$('#out-text').empty();
	var regex = /\[(\w+)\|([\u0590-\u05ff]+)\]/g;
	var src_text = text;

	var sections = src_text.split(regex); //regex.exec(src_text);

	var i = 0;
	while (i < sections.length)
	{
		normal_text(sections[i]);
		if (i % 3 === 0)
		{
			i+=1;
		}
		else
		{
			var word = sections[i];
			var tran = sections[i+1];
			var trans_div = $('<div class="' + word_class_name +'">('+ tran+')</div>');
			trans_div.addClass(canon(word));
			$('#out-text').append(trans_div);
			i+=2;
		}
	}			
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
