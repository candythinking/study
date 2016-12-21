<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#--<title>Hello ${name}!</title>-->
</head>
<body>
    <#--<h2>Hello ${name}!</h2>-->
    <hr/>
    <#list datas as data>
    ${data.city}------${data.dataSum}------${data.defaultValue}<br/>
    </#list>
</body>
</html>