<html>

	<head>
		<style>
			#anatomyG {color: #000000;}
		</style>
	
		<title>Josh's Works</title>
		<link href = "Style/MainStyle.css" type = "text/css" rel = "stylesheet" />
		<link href = "Style/galleryStyle.css" type = "text/css" rel = "stylesheet" />				<script src="http://code.jquery.com/jquery-1.9.1.js"></script>				<script type="text/javascript" src="JSRefrence/gallery.js"></script>
		<h1 id = "bannerText"><div>Anatomy Gallery</div></h1>
		
		<?php
		include("PHPRefrence/navBar.txt");
		?>
		
	</head>
	
	<body>		<img id = "before" src = ""/>		
		<div id = "mainContent">
			<h1></h1>			<?PHP				for($i = 0; $i < 3; $i++){					print("<img class = \"pic\" src = \"Gallerys/anatomy/pic$i.jpg\"/>");				}			?>
		</div>
	</body>
	
</html>