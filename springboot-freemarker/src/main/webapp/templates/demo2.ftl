<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <#--<title>Hello ${name}!</title>-->
    <script>
        var cityArray = new Array();
        <#list citys as city>
        cityArray[${city_index}]=${city};
        </#list>
    </script>
</head>
<body>
    <#--<h2>Hello ${name}!</h2>-->
    <hr/>
   <#--${cityArray}-->

    <hr/>
    <#list dataSums as dataSum>
    ${dataSum}<br/>
    </#list>

    <hr/>
    <#list defaultValues as defaultValue>
    ${defaultValue}<br/>
    </#list>
</body>
</html>