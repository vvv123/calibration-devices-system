<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signin Template for Bootstrap</title>

    <link href="/resources/assets/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

    <body id="loginModule">

    <div class="container" ng-controller="Controller">

        <form ng-submit="login()" class="form-signin">
            <h2 class="form-signin-heading">Please sign in</h2>

            <input ng-model="loginForm.username" type="email"  class="form-control" placeholder="Email address" required autofocus>

            <input ng-model="loginForm.password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>

    </div>

    <script type="text/javascript" data-main="/resources/app/login/run-app"
            src="/resources/assets/bower_components/requirejs/require.js"></script>

</body>
</html>
