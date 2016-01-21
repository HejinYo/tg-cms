function createFileUpload(container, fileUploadUrl, isMulti, filedName, accept) {
	// 当domReady的时候开始初始化
	var $ = jQuery, $list = container.find('.thelist'), $btn = container
			.find('.ctlBtn'), state = 'pending', uploader;

	uploader = WebUploader.create({
				// auto: !isMulti,
				// 不压缩image
				resize : false,
				duplicate : true,
				threads : 1,
				swf : BASE_URL + '/resources/vendor/webuploader/Uploader.swf',
				// 文件接收服务端。
				server : fileUploadUrl,
				// 选择文件的按钮。可选。
				// 内部根据当前运行是创建，可能是input元素，也可能是flash.
				pick : container.find('.picker'),
				accept : accept
			});

	uploader.customFieQueued = function(file, custom) {
		var col = 'col-md-4';
		if (!isMulti) {
			$list.html("");
			col = "";
		}
		var $li = $('<div id="'
				+ file.id
				+ '" class="item '
				+ col
				+ '">'
				+ '<h4 class="info">'
				+ file.name
				+ '</h4>'
				+ '<span class="state pull-left">等待上传...</span><a class="pull-right delBtn">删除</a>'
				+ '</div>');
		$li.append($('<input type="hidden" class="fileNameInput" name="'
				+ filedName + '">'));
		$list.append($li);
		if (custom) {
			$('#' + file.id).find('input.fileNameInput').val(file.id);
			$('#' + file.id).find('span.state').text('')
		}

		$li.find('.delBtn').on('click', function() {
					$li.remove();
				});
	}

	// 当有文件添加进来的时候
	uploader.on('fileQueued', function(file) {
				uploader.customFieQueued(file);
			});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		var $li = $('#' + file.id), $percent = $li
				.find('.progress .progress-bar');

		// 避免重复创建
		if (!$percent.length) {
			$percent = $('<div class="progress progress-striped active">'
					+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
					+ '</div>' + '</div>').appendTo($li).find('.progress-bar');
		}

		$li.find('span.state').text('上传中');

		$percent.css('width', percentage * 100 + '%');
	});

	uploader.on('uploadSuccess', function(file) {
				$('#' + file.id).find('span.state').text('已上传');
			});

	uploader.on('uploadError', function(file) {
				$('#' + file.id).find('span.state').text('上传出错');
			});

	uploader.on('uploadComplete', function(file) {
				$('#' + file.id).find('.progress').fadeOut();
			});
	uploader.on('uploadAccept', function(file, response) {
		if (response.success) {
			$('#' + file.file.id).find('input.fileNameInput').val(response.msg);
		} else {
			return false;
		}
	});
	uploader.on('all', function(type) {
				if (type === 'startUpload') {
					state = 'uploading';
				} else if (type === 'stopUpload') {
					state = 'paused';
				} else if (type === 'uploadFinished') {
					state = 'done';
				}

				if (state === 'uploading') {
					$btn.text('暂停上传');
				} else {
					$btn.text('开始上传');
				}
			});
	uploader.gi_uploaderBtnClick=function() {
		if (state === 'uploading') {
			uploader.stop();
		} else {
			uploader.upload();
		}
	}
	if (isMulti) {
		$btn.on('click', function() {
					uploader.gi_uploaderBtnClick();
				});
	}
	return uploader;
}