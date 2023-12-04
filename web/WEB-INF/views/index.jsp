<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>jQuery</title>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        jQuery( document ).ready( function() {
            var jbDetach;
            $( '#cut' ).click( function() {
                jbDetach = $( '.b' ).detach();
            } );
            $( '#paste' ).click( function() {
                $( '.a' ).before( jbDetach );
            } );
        } );
    </script>
</head>
<body>
<h1>Lorem</h1>
<h2 class="a">Ipsum</h2>
<h2 class="b">Dolor</h3>
    <button id="cut">Cut</button> <button id="paste">Paste</button>
</body>
</html>