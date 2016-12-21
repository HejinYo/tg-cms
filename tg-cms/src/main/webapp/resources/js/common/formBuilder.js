// 文本框
function createTextField(record) {
	var input = $('<input />').addClass('layui-input').attr('name',
			record.fieldName);
	input.attr('placeholder', '请输入' + record.fieldLabel);
	input.val(record.innerType == 1
			? record.valueStr
			: record._result[record.fieldName]);
	return input;
}

// 文本域
function createTextarea(record) {
	var input = $('<textarea></textarea>').addClass('form-control input-sm')
			.attr('name', record.fieldName).attr('rows', 4);
	input.val(record.innerType == 1
			? record.valueStr
			: record._result[record.fieldName]);
	return input;
}
// 日期框
function createDateField(record) {
	var inputGroup = $('<div></div>').addClass('input-group date');
	var input = $('<input />').addClass('form-control input-sm').attr('name',
			record.fieldName);
	inputGroup.append($('<span></span>').addClass('input-group-addon')
			.append($('<i></i>').addClass('fa fa-calendar')));
	inputGroup.append(input);
	input.attr('placeholder', record.dateFormat);
	input.val(record.innerType == 1
			? record.valueForDate
			: record._result[record.fieldName]);
	return inputGroup;
}

// 单选下拉
function createSingleCombobox(record) {
	var container = $('<div></div>');
	if (record.checkboxOptions != null && record.checkboxOptions != "") {
		var options = record.checkboxOptions.split('\n');
		for (var i = 0; i < options.length; i++) {
			var optionValues = options[i].split("=");
			var optionValue = optionValues[0];
			var optionText = optionValues.length == 1
					? optionValues[0]
					: optionValues[1];
			container.append($("<label></label>").addClass('radio-inline')
					.append($('<input />').attr('type', 'radio').attr('name',
							record.fieldName).attr('value', optionValue))
					.append(optionText));
		}
		var valueStr = record.innerType == 1
				? record.valueStr
				: record._result[record.fieldName];
		if (valueStr != null && valueStr != '') {
			var values = valueStr.split(',');
			for (var j = 0; j < values.length; j++) {
				container.find('input[value="' + values[j] + '"]').attr(
						'checked', 'checked');
			}
		}

	}
	return container;
}

// 多选下拉
function createMultiCombobox(record) {
	var container = $('<div></div>');
	if (record.checkboxOptions != null && record.checkboxOptions != "") {
		var options = record.checkboxOptions.split('\n');
		for (var i = 0; i < options.length; i++) {
			var optionValues = options[i].split("=");
			var optionValue = optionValues[0];
			var optionText = optionValues.length == 1
					? optionValues[0]
					: optionValues[1];
			container.append($("<label></label>").addClass('checkbox-inline')
					.append($('<input />').attr('type', 'checkbox').attr(
							'name', record.fieldName).val(optionValue))
					.append(optionText));
		}
		var valueStr = record.innerType == 1
				? record.valueStr
				: record._result[record.fieldName];
		if (valueStr != null && valueStr != '') {
			var values = valueStr.split(',');
			for (var j = 0; j < values.length; j++) {
				container.find('input[value="' + values[j] + '"]').attr(
						'checked', 'checked');
			}
		}
	}
	return container;
}
// 创建htmleditor
function createHtmlEditor(record) {
	var editor = $('<div class="ibox">');
	var value = record.innerType == 1
			? record.valueForLongText
			: record._result[record.fieldName];
	var editorContainer = $('<script id="' + record.editorId + '" name="'
			+ record.fieldName + '" type="text/plain">' + (value ? value : '')
			+ '</script>');
	editor.append(editorContainer);
	return editor;
}
// 创建附件上传
function createAttchmentUpload(record) {
	var fileUploadUrl = BASE_URL
			+ 'admin/m/base/file/fileUpload.gsp?fieldName='
			+ record.fieldName;
	var fileGetUrl = BASE_URL + 'admin/m/base/file/findByIds.gsp';
	var fileIcon = 'fa fa-file';
	var upBtnText = '上传文件';
	if (record.type == 9) {
		fileUploadUrl = BASE_URL
				+ 'admin/m/base/video/fileUpload.gsp?fieldName='
				+ record.fieldName;
		fileGetUrl = BASE_URL + 'admin/m/base/video/findByIds.gsp';
		upBtnText = '上传视频';
		fileIcon = 'fa fa-film';
	} else if (record.type == 11) {
		fileUploadUrl = BASE_URL
				+ 'admin/m/base/doc/fileUpload.gsp?fieldName='
				+ record.fieldName;
		fileGetUrl = BASE_URL + 'admin/m/base/doc/findByIds.gsp';
		upBtnText = '上传文档';
		fileIcon = 'fa fa-file-text-o';
	}

	var params = "?type=" + record.type + "&fieldName=" + record.fieldName;
	var container = $('<div>');
	container
			.append($('<a href="'
					+ fileUploadUrl
					+ '" data-target="#uploaderWin" class="btn btn-primary btn-xs" type="button" data-toggle="modal"><i class="fa fa-plus"></i>&nbsp;'
					+ (record.fieldLabel == null
							? upBtnText
							: record.fieldLabel) + '</a>'));
	container.append($('<div style="padding-left:0px;" id="' + record.fieldName
			+ '" class="col-md-12 uploader-list">'));

	var fileIds = record.innerType == 1
			? record.valueStr
			: record._result[record.fieldName];
	if (fileIds != null && fileIds != '') {
		tg_simpleAjaxPost(fileGetUrl, {
					ids : fileIds
				}, function(d) {
					var result = $.parseJSON(d);
					if (result.obj != null && result.obj.length > 0) {
						var id = result.obj[0].id;
						var fileName = null;
						if (record.type == 9) {
							fileName = result.obj[0].videoName;
						} else if (record.type == 10) {
							fileName = result.obj[0].fileName;
						} else if (record.type == 11) {
							fileName = result.obj[0].docName;
						}
						var divId = new Date().getTime();
						var $li = $('<div style="width:160px;" class="file pull-left" id="'
								+ divId
								+ '"><div class="icon"><i class="img-responsive '
								+ fileIcon
								+ '"></i></div><div class="file-name">'
								+ fileName
								+ '</div><a class="pull-right delBtn">删除</a></div>');
						$li.append($('<input type="hidden" name="'
								+ record.fieldName + '" value="' + id + '">'));
						$('#' + record.fieldName).append($li);
					}
					$('#' + record.fieldName).on('click', '.delBtn',
							function() {
								$(this).parent().remove();
							});
				});
	}

	return container;
}

// 用于图片上传的图片初始化
function initImage(ids, filedName) {
	var findByIdsUrl = BASE_URL + 'admin/m/base/image/findByIds';
	var showImageId = '#' + filedName;
	if (ids != null && ids != '') {
		tg_simpleAjaxPost(findByIdsUrl, {
					ids : ids
				}, function(d) {
					var result = $.parseJSON(d);
					if (result.obj != null && result.obj.length > 0) {
						for (var i = 0; i < result.obj.length; i++) {
							var src = result.obj[i].imgPath;
							var id = result.obj[i].id;
							var fileName = result.obj[i].imgName;
							var divId = new Date().getTime() + i;
							
							var $li = $('<div style="width:120px; height:140px;"  class="file-item thumbnail col-xs-2" id="'+divId+'">' + '<img><a class="pull-right delBtn" style="cursor: pointer;">删除</a></div>');
                        	$li.append($('<input type="hidden" name="'+filedName+'" value="'+id+'">'));
                        	$li.find('img').attr('src', src).width(110).height(110);
							$(showImageId).append($li);
						}
						$(showImageId).on('click', '.delBtn', function() {
									$(this).parent().remove();
								});
					}
				});
	}
}

// 创建图片集上传
function createManyImagsUpload(record) {
	var params = "?type=multi&fieldName=" + record.fieldName;
	var container = $('<div>');
	container
			.append($('<a href="'
					+ BASE_URL
					+ 'admin/m/base/image/imageUpload2.gsp'
					+ params
					+ '" data-target="#uploaderWin" class="btn btn-primary btn-xs" type="button" data-toggle="modal"><i class="fa fa-plus"></i>&nbsp;上传图片集</a>'));
	container.append($('<div style="padding-left:0px;" id="' + record.fieldName
			+ '" class="col-md-12 uploader-list">'));
	var imageIds = record.innerType == 1
			? record.valueStr
			: record._result[record.fieldName];
	initImage(imageIds, record.fieldName);
	return container;
}

// 图片上传
function createImagUpload(record) {
	var params = "?type=single&fieldName=" + record.fieldName;
	var container = $('<div>');
	container
			.append($('<a href="'
					+ BASE_URL
					+ 'admin/m/base/image/imageUpload2.gsp'
					+ params
					+ '" data-target="#uploaderWin" class="btn btn-primary btn-xs" type="button" data-toggle="modal"><i class="fa fa-plus"></i>&nbsp;'
					+ (record.fieldLabel == null ? '上传图片' : record.fieldLabel)
					+ '</a>'));
	container.append($('<div style="padding-left:0px;" id="' + record.fieldName
			+ '" class="col-md-12 uploader-list">'));
	var imageId = record.innerType == 1
			? record.valueStr
			: record._result[record.fieldName];
	initImage(imageId, record.fieldName);
	return container;
}

// 属性
function createAttr(record) {
	var container = $('<div></div>');
	tg_simpleAjaxPost(BASE_URL + 'admin/m/base/attr/findByInfoId.gsp', {
				id : record._result['id'] == null ? '' : record._result['id']
			}, function(d) {
				var rs = $.parseJSON(d);
				if (rs.obj != null && rs.obj.length > 0) {
					for (var i = 0; i < rs.obj.length; i++) {
						var checkbox = $('<input />').attr('type', 'checkbox')
								.attr('name', record.fieldName)
								.val(rs.obj[i].id);
						if (rs.obj[i].infoId != null) {
							checkbox.attr('checked', 'checked');
						}
						container.append($("<label></label>")
								.addClass('checkbox-inline').append(checkbox)
								.append(rs.obj[i].attName));
					}
				}
			});
	return container;
}
function formBuilder(options, result, sucFun) {
	var url = BASE_URL
			+ 'admin/m/base/customField/findFieldAndValueByModel.gsp';
	tg_simpleAjaxPost(url, options, function(d) {
		var rs = $.parseJSON(d);
		$("#formBuilderDiv").html("");
		var records = rs.obj;
		var ueditors = $('<div>');
		var ueditorIds = [];

		var singleFiles = $('<div class="layui-form-item"><div class="layui-inline">');
		singleFiles.append($('<label class="col-md-2 control-label"></label>'));
		singleFiles.append($('<div class="col-md-10"></div>'));
		singleFiles.append($('<div class="clearfix"></div>'));
		for (var i = 0; i < records.length; i++) {
			var record = records[i];
			var field = null;
			record._result = result == null ? {} : result;
			if (record.type == 1) { // 文本输入框
				field = createTextField(record);
			} else if (record.type == 2) { // 日期框
				field = createDateField(record);
			} else if (record.type == 3) { // 单选下拉
				field = createSingleCombobox(record);
			} else if (record.type == 4) { // 多选下拉
				field = createMultiCombobox(record);
			} else if (record.type == 5) { // 文本域
				field = createTextarea(record);
			} else if (record.type == 6) { // 文本编辑器
				var editorId = new Date().getTime() + record.fieldName;
				ueditorIds.push(editorId);
				record.editorId = editorId;
				field = createHtmlEditor(record);
			} else if (record.type == 7) { // 图片上传
				field = createImagUpload(record);
			} else if (record.type == 8) { // 图片集上传
				field = createManyImagsUpload(record);
			} else if (record.type == 9) { // 视频上传
				field = createAttchmentUpload(record);
			} else if (record.type == 10) { // 附件上传
				field = createAttchmentUpload(record);
			} else if (record.type == 11) { // 文档上传
				field = createAttchmentUpload(record);
			} else if (record.type == 12) {
				field = createAttr(record);
			}
			var formGroup = $('<div></div></div>').addClass('layui-form-item');
			var label = $("<label></label>").addClass('layui-form-label')
					.html(record.fieldLabel + "：");
			var inputDiv = $('<div></div></div>').addClass('layui-input-block');
			inputDiv.append(field);
			formGroup.append(label);
			formGroup.append(inputDiv);

			if (record.type == 6) {
				ueditors.append(formGroup);
			} else if (record.type == 7 || record.type == 9
					|| record.type == 10 || record.type == 11) {
				inputDiv.removeClass('col-md-10').addClass('pull-left').css(
						'width', 200);
				singleFiles.find('.col-md-10').append(inputDiv);
			} else {
				$("#formBuilderDiv").append(formGroup);
			}
		}
		$("#formBuilderDiv").append(singleFiles);

		if (ueditorIds.length > 0) {
			$("#formBuilderDiv").append($('<div class="clearfix"></div>'));
			$("#formBuilderDiv").append(ueditors);
			for (var i = 0; i < ueditorIds.length; i++) {
				UE.getEditor(ueditorIds[i]);
			}
		}

		if ($('.input-group.date')) {
			$('.input-group.date').datepicker({
						todayBtn : "linked",
						keyboardNavigation : false,
						forceParse : false,
						calendarWeeks : true,
						autoclose : true
					});
		}
		if (sucFun) {
			sucFun();
		}
	});
}