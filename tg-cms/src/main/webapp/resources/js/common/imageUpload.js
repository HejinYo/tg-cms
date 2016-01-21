function createImageUploader(container, fileUploadUrl, isMulti, filedName) {
	// .thelist 列表
	// .ctlBtn 上传按钮
	// .picker 选择按钮
	// 当domReady的时候开始初始化
	var $ = jQuery, $list = container.find('.thelist'), $btn = container
			.find('.ctlBtn'), state = 'pending', $picker = container
			.find('.picker'), uploader;
	// 优化retina, 在retina下这个值是2
	var ratio = window.devicePixelRatio || 1,
	// 缩略图大小
	thumbnailWidth = 100 * ratio, thumbnailHeight = 100 * ratio,
	acceptExtensions = 'png,jpg,jpeg,gif,bmp';
	
	uploader = WebUploader.create({
		 		auto: !isMulti,
				// 不压缩image
				resize : false,
				duplicate:true,
				threads:1,
				swf: BASE_URL + '/resources/vendor/webuploader/Uploader.swf',
				// 文件接收服务端。
				server : fileUploadUrl,
				// 选择文件的按钮。可选。
				// 内部根据当前运行是创建，可能是input元素，也可能是flash.
				pick : container.find('.picker'),
				accept : { // 上传类型限制
					title : 'Images',
					extensions : acceptExtensions,
					mimeTypes : 'image/*'
				}
			});
	uploader.customFieQueued = function(file,custom){
		if (!isMulti) {
			$list.html("");
		}
		var $li = $('<div style="width:120px;height:140px;" id="' + file.id + '" class="file-item thumbnail col-xs-2">' + '<img>' + '<span class="state pull-left">等待上传</span><a class="pull-right delBtn" style="cursor: pointer;">删除</a>'+ '</div>'), $img = $li.find('img');
        $li.append($('<input type="hidden" class="fileNameInput" name="'+filedName+'">'));
        $list.append($li);
        if(custom){
        	 $img.attr('src', file.src);
        	 $('#' + file.id).find('input.fileNameInput').val(file.id);
        	 $img.width(thumbnailWidth);
        	 $img.height(thumbnailHeight);
        	 $('#' + file.id).find('span.state').text(' ')
        }else{
        	// 创建缩略图
	        uploader.makeThumb(file, function(error, src) {
	            if (error) {
	                $img.replaceWith('<span>不能预览</span>');
	                return;
	            }
	            $img.attr('src', src).width(110).height(110);;
	        }, thumbnailWidth, thumbnailHeight);
        }
        
        $li.find('.delBtn').on('click',function(){
        	$li.remove();
        });
	}
	// 当有文件添加进来的时候
	uploader.on('fileQueued', function(file) {
		uploader.customFieQueued(file, false);
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
				var $li = $('#' + file.id);
				$li.find('span.state').text('上传中' + (percentage * 100) + '%');
			});

	uploader.on('uploadSuccess', function(file) {
				$('#' + file.id).find('span.state').text('已上传').addClass('text-success');
			});

	uploader.on('uploadError', function(file) {
				$('#' + file.id).find('span.state').text('上传出错').addClass('text-danger');;
			});

	uploader.on('uploadComplete', function(file) {
				// $('#' + file.id).find('.progress').fadeOut();
			});
	
	uploader.on('uploadAccept', function(file, response) {
				if (response.success) {
					$('#' + file.file.id).find('input.fileNameInput').val(response.obj);
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
	if (isMulti) {
		$btn.on('click', function() {
					if (state === 'uploading') {
						uploader.stop();
					} else {
						uploader.upload();
					}
				});
	}
	return uploader;
}