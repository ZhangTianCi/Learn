<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="/Content/uikit.almost-flat.min.css" rel="stylesheet"/>
    <script src="/Scripts/jquery-3.3.1.min.js"></script>
    <script src="/Scripts/uikit.min.js"></script>
    <title>取样详情</title>
    <style>
        table, tr, td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
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
		 <li>
             <div class="uk-grid">
                 <div class="uk-width-1-2">${key}</div>
                 <div class="uk-width-1-2" style="position:relative;">
                    <#list valve as valueItem>
                        <label>${valueItem}</label>
					</#list>
                 </div>
             </div>
         </li>
		</#list>
	<#else>
		<tr colspan="2">没有可以更改的内容</tr>
	</#if>
                <li><a href='/Take/Edit/${Take.getId()}' target="_self">修改信息</a></li>
                <li></li>
            </ul>
<#else>
        <div class="uk-width-1-1 uk-height-1-1 uk-vertical-align uk-text-center">
            <h1 class="uk-vertical-align-middle">未找到取样数据</h1>
        </div>
</#if>
</body>
</html>