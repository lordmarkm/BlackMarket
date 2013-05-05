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
  <div id="wrap">
    <div class="container">
    
      <form class="login" id="signin-facebook" action="<@spring.url '/signin/facebook' />" method="POST">
        <input type="submit" />
      </form>
      
    </div>
  </div>
</body>

</html>