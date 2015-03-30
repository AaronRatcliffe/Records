<html>

	<head>
		<title>Josh's Works</title>
		<link href = "Style/MainStyle.css" type = "text/css" rel = "stylesheet" />
		<link href = "Style/comicStyle.css" type = "text/css" rel = "stylesheet" />				<script src="http://code.jquery.com/jquery-1.9.1.js"></script>				<script type="text/javascript" src="JSRefrence/comic.js"></script>
		<h1 id = "bannerText"><div>Comic</div></h1>
		
		<?php
		include("PHPRefrence/navBar.txt");
		?>
		
	</head>
	
	<body>
		<div id = "mainContent">
			<h1>Enjoy The Story</h1>
			<div id = "webComic">							<input id = "BB" type="button" value="<=" name="BB" />
				<img id = "panel" src = "webComic/0.jpg" alt = "comic strip"/>				<input id = "FB" type="button" value="=>" name="FB" />								<div id = "selectBar">					<img class = "comicSelect" id = "LS" src = "mainPics/last.jpg" alt = "forward Butten"/>					<img class = "comicSelect" id = "cS1" src = "webComic/0.jpg" alt = "comic strip"/>					<img class = "comicSelect" id = "cS2" src = "webComic/1.jpg" alt = "comic strip"/>					<img class = "comicSelect" id = "cS3" src = "webComic/2.jpg" alt = "comic strip"/>					<img class = "comicSelect" id = "cS4" src = "webComic/3.jpg" alt = "comic strip"/>					<img class = "comicSelect" id = "cS5" src = "webComic/4.jpg" alt = "comic strip"/>					<img class = "comicSelect" id = "NS" src = "mainPics/next.jpg" alt = "forward Butten"/>
				</div>			</div>						
		</div>
	</body>
	
</html>