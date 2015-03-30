<html>

	<head>
		<style>
			#comicD {color: #000000;}
			#submitPost input{display: block;}
		</style>
	
		<title>Josh's Works</title>
		<link href = "Style/MainStyle.css" type = "text/css" rel = "stylesheet" />
		<link href = "Style/forumStyle.css" type = "text/css" rel = "stylesheet" />
		<h1 id = "bannerText"><div>Comic Forum</div></h1>
		
		<?php
		include("PHPRefrence/navBar.txt");
		?>
		
	</head>
	
	<body>
	<div id = "spacer"></div>
		<?php
			$mainPosts = file('Forums/comicDiscussion/mainD.txt');
			$i = 0;
			foreach($mainPosts as $line_num => $line){
				$post = explode("_", $mainPosts[$i]);
				print "<div class = \"post\">Name: " . $post[0] . "<br/>Subject: " . $post[1] . "<br/>Coment: " . $post[2] . "</div>";
			$i++;
			}
		?>
		<div id = "submitPost">
			<?php
				include("PHPRefrence/submitForum.txt");
			?>
			<input type = "hidden" name = "page" id = "page" value = "comic">
			<?php
				print "</form>";
			?>
		</div>
	</body>
	
</html>