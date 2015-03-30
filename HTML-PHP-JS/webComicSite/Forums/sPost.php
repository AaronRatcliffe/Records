
			<?php
				$file = "survey/s1.txt";
				$gender = $_POST["gender"];
				$age = $_POST["age"];
				$type = $_POST["type"];
				$gamer = $_POST["gamer"];
				
				$content = $gender . '_' . $age . '_' . $type . '_' . $gamer . "\r\n";
				
				file_put_contents($file, $content, FILE_APPEND);
				header("Location: http://www.aratcli6.com");
			?>