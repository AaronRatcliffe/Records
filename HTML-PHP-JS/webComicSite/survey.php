<html>

	<head>
		<script>
			function test(){
				alert("Your answers have been submitted successfully.\n Thank you for your protisopation and I hope you enjoy the rest of the site.");
			}
		</script>
		
		<title>Josh's Works</title>
		<link href = "Style/MainStyle.css" type = "text/css" rel = "stylesheet" />
		<link href = "Style/forumStyle.css" type = "text/css" rel = "stylesheet" />
		<h1 id = "bannerText"><div>Survey Forum</div></h1>
		
		<style>
			#survey {color: #000000;}
			#submitPost{height: 36%; width: 30%;}
		</style>
		
		<?php
		include("PHPRefrence/navBar.txt");
		?>
		
	</head>
	
	<body>
	<div id = "spacer">
	</div>
		<div id = "submitPost">
			<form id = "survey" action = "Forms/sPost.php" method = "POST" onsubmit = "test()">
				<fieldset>
					<legend>Visitor information survey</legend>
					
					<label for = "gender" class = "heading">Select your gender: </label>
						<label for = "boy">male: </label>
							<input type = "radio" id = "boy" name = "gender" value = "boy">
						<label for = "girl">female: </label>
							<input type = "radio" id = "girl" name = "gender" value = "girl">
						
					<label for = "age" class = "heading">Input your birth date: </label>
						<input type = "date" id = "age" name = "age">
						
					<label for = "type" class = "heading">What kinds of books/moves do you like: </label>
						<label for = "action">action: </label>
							<input type = "checkbox" id = "action" name = "type" value = "action,">
						<label for = "thriller">thriller: </label>
							<input type = "checkbox" id = "thriller" name = "type" value = "thriller,">
						<label for = "comedy">comedy: </label>
							<input type = "checkbox" id = "comedy" name = "type" value = "comedy,">
						<label for = "romance">romance: </label>
							<input type = "checkbox" id = "romance" name = "type" value = "romance,">
						<label for = "horror">horror: </label>
							<input type = "checkbox" id = "horror" name = "type" value = "horror,">
						<label for = "fantasy">fantasy: </label>
							<input type = "checkbox" id = "fantasy" name = "type" value = "fantasy,">
						<label for = "science fiction">science fiction: </label>
							<input type = "checkbox" id = "science fiction" name = "type" value = "science fiction,">
						<label for = "drama">drama: <label>
							<input type = "checkbox" id = "drama" name = "type" value = "drama,">
						<label for = "tragedy">tragedy: </label>
							<input type = "checkbox" id = "tragedy" name = "type" value = "tragedy,">
						<label for = "adventure">adventure: </label>
							<input type = "checkbox" id = "adventure" name = "type" value = "adventure,">
						
					<label for = "gamer" class = "heading">Do you play video games</label>
						<label for = "yes">Yes I do: </label>
							<input type = "radio" id = "yes" name = "gamer" value = "true">
						<label for = "no">No I do not: </label>
							<input type = "radio" id = "no" name = "gamer" value = "false">
						
					<input type = "submit" class = "heading" value = "Answer"/>
				</fieldset>
			</form>
		</div>
	</body>
	
</html>