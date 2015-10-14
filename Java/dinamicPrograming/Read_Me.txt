@Auther  Aaron J. Ratcliffe  800-795-070
4/7/2015

My program first takes in and cheks two user input files name each one contining
a single string that is to be compaired to each other. Then it looks in each file
and puts the contints into a jagged array of chars, then it creates a compare object 
passing in the jagged array containing the strings to be compaired. The compare 
constructor then creates a 2D array with a hight of 2 and a width of the length of 
the string in the first fille. It then calls the findNormEditDist method passing in
the edit distenc which is found by calling the findEditDist function and passing it
the small 2D array that was just created as well as the starting index of the 
string from the second file. The findEditDist takes the 2D array that was passed in
populates the second line of it and incroments the array refrence you passed in by 
one then recersivly calls its self untill the passed in array refrence is over the 
length of the second strings length, then it returns the number located in the last
space at the bottem of the 2D array which is the edit distence. The findNormEditDist 
method then takes the edit distence and runs it thru an equation to get the 
Normalized edit distence then returns it as a double. then the constructor calls the 
findLongComSequince wich creates a 2D array with the width of the length of the 
first string and a hight of the length of the second string. It fills out this 2D 
array to find at what pont the strings do not match and then uses this information
to crate a new string that is the longest subsequince of charictors that the two
origonal strings had in common. The constructor then calls the bonusLongComSequince
method that dose the same things as the last method acept preforms it using less 
memory and using recurtion. After that the comparison class outputs the normalized
edit distence, the longest common substring found by the findLongComSequince method,
and the longest common substring foudn by the bonusLongComSequince method all on 
a sepret line.

Comparison 
	The class that contains the main method that takes in input,
	validates it and calls the compare constructor on with the contentcs of the 
	input files passed in to it, and then prints out the information contained
	in the compare object.
Compare
	The class that contains the constructor Compare wich creates creates an 	
	object of the compare class with a 2D array of chars of size [2][] where 
	the two colums will be compaird to each other.it calls the method 
	findEditDist() to find the normalized edit distence and calls the method 
	findLongComSequince() to create a new string that has the longest common
	sequince between the two arrays of chars

IDE Eclipse  Compiler 'JavaSE-1.8'

My program should work with all input files in the proper format and it preforms
its taskes fairly effetiontly.  but my program fails because I do not validate the 
information containd in the input files to make shure it is in the right format
and I could have made my code easer to read.

Run time
T(n) = O(Comparison) = O(nm)
O(Comparison) = O(22)+O(Compare) = O(nm)
O(Compare) = O(2+n)+O(findNormEditDist)+O(findLongComSequince)+O(bonusLongComSequince)+
	     O(findEditDist) = O(nm)
O(findNormEditDist) = O(1)
O(findEditDist) = O(3+3n+3m+3nm) = O(nm)
O(findLongComSequince) = O(5+4nm+3n+n) = O(nm)
O(bonusLongComSequince) = O() = O(nm)