<?php
	$name = $_POST["Name"];
	$idea = $_POST["Idea"];
	$subject = $_POST["Subject"];
	$page = $_POST["page"];
	
	if ($page == "comic"){
		$file = "comicDiscussion/mainD.txt";
		$formP = "comicDiscution.php";
	}
	else if ($page == "art"){
		$file = "styleDiscussion/mainD.txt";
		$formP = "artDiscution.php";
	}
	else if ($page == "website"){
		$file = "websiteDiscussion/mainD.txt";
		$formP = "websiteFeedback.php";
	}
	
	$content = $name . '_' . $subject . '_' . $idea;
	$content = $content . "\r\n";
	file_put_contents($file, $content, FILE_APPEND);
	header("Location: http://www.aratcli6.com/$formP");
	

?>