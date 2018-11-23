<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="/Content/uikit.almost-flat.min.css" rel="stylesheet"/>
    <script src="/Scripts/jquery-3.3.1.min.js"></script>
    <script src="/Scripts/uikit.min.js"></script>
    <title>修改取样信息</title>
    <style>
        table, tr, td, th {
            border: 1px solid black;
        }
    </style>
    <script>
        function EditTakeInfo() {
            var Modal_DataSubmit = UIkit.modal.blockUI("<h1 class='uk-text-center'>数据正在提交，请稍候。</h1>", {center: true});
            var EditInput = $('.edit input').toArray();
            var EditData = {Id: '${Take.getId()}', AnalysisItemsObject: {}};
            for (var i = 0; i < EditInput.length; i++) {
                var item = $(EditInput[i]);
                if (Object.keys(EditData.AnalysisItemsObject).indexOf(item.data('key')) < 0) {
                    EditData.AnalysisItemsObject[item.data('key')] = [];
                }
                EditData.AnalysisItemsObject[item.data('key')].push(item.val().trim());
            }
            console.log(JSON.stringify(EditData));

            $.ajax('/Take/EditOption', {
                type: "POST",
                dataType: 'json',
                contentType: "application/json",
                data: JSON.stringify(EditData),
                success: function (JsonData) {
                    Modal_DataSubmit.hide();
                    if (JsonData.State === true) {
                        location.href = '/Take/Index/${Take.getId()}';
                        UIkit.modal('#Modal_DeleteData').hide();
                    }
                    else if (JsonData.State === false) {
                        UIkit.modal.alert(JsonData.Message);
                    }
                    else {
                        UIkit.modal.alert('异常的数据返回结构。');
                    }
                },
                error: function (Result, State, Message) {
                    Modal_DataSubmit.hide();
                    if (Result.readyState == 4) {
                        UIkit.modal.alert("<h4 class='uk-text-center'>网络资源不存在，请联系管理员</h4>", {center: true});
                    } else {
                        UIkit.modal.blockUI("<h4 class='uk-text-center'>发生了一个网络错误，请刷新页面重试</h4>", {center: true});
                    }
                }
            });
        }
    </script>
</head>
<body>
<#if Take??>
	<#if Take??>
 <div class="uk-width-1-3 uk-text-center uk-height-1-1 uk-vertical-align uk-container-center">
            <ul class="uk-list uk-list-line uk-width-1-1 uk-vertical-align-middle">
                <li></li>
                <li>
                    <div class="uk-grid">
                        <div class="uk-width-1-2">二维码编号</div>
                        <div class="uk-width-1-2">${Take.getId()}</div>
                    </div>
                </li>
                <li>
                    <div class="uk-grid">
                        <div class="uk-width-1-2">样本单名称</div>
                        <div class="uk-width-1-2">${Take.getAnalysisUnitName()}</div>
                    </div>
                </li>
                <li>
                    <div class="uk-grid">
                        <div class="uk-width-1-2">录入时间</div>
                        <div class="uk-width-1-2">${Take.getInsertTime()?datetime}</div>
                    </div>
                </li>
                <li>
                    <div class="uk-grid">
                        <div class="uk-width-1-2">录入用户</div>
                        <div class="uk-width-1-2">${Take.getUserName()}</div>
                    </div>
                </li>
                <li>
                    <div class="uk-grid">
                        <div class="uk-width-1-2">录入位置</div>
                        <div class="uk-width-1-2">
                            <a class="uk-link" target="_blank"
                               href="http://api.map.baidu.com/geocoder?location=${Take.getLatitude()},${Take.getLongitude()}&coord_type=wgs84&output=html">查看位置</a>
                        </div>
                    </div>
                </li>

	<#if Take.getAnalysisItems()??>
		<#list Take.getAnalysisItems() as key, valve>
			<li class="edit">
                <div class="uk-grid">
                    <div class="uk-width-1-2">${key}</div>
                    <div class="uk-width-1-2" style="position:relative;">
                    <#list valve as valueItem>
                        <input data-key='${key}' value="${valueItem}">
					</#list>
                    </div>
                </div>
            </li>
		</#list>
	<#else>
		     <li class="uk-text-center">没有可以更改的内容</li>
	</#if>
                <li class="uk-text-center">
                    <a href="/Take/Index/${Take.getId()}" role="button"
                       class="uk-button-link uk-button-danger uk-text-danger">取消</a>
                    <button type="button" class="uk-button-link" onclick="EditTakeInfo();">保存</button>
                </li>
                <li></li>
            </ul>
	<#else>
        <div class="uk-width-1-1 uk-height-1-1 uk-vertical-align uk-text-center">
            <h1 class="uk-vertical-align-middle">未找到取样数据</h1>
        </div>
	</#if>

<#else>
<h1>数据丢失了</h1>
</#if>
</body>
</html>