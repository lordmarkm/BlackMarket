<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>

<head>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
<link href="<@spring.url '/css/default.css' />" rel="stylesheet">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<!--  
  <form method = "post">
    <@spring.bind "form" />
    <input type="text" name="username" />
    <input type="text" name="btag" />
    <input type="password" name="password" />
    <#list spring.status.errorMessages as error> 
      <b>${error }</b><br />
    </#list>
  </form>
  -->
</body>

</html>