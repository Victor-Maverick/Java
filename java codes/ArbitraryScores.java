count = 0
number_of_pass = 0
number_of_fail = 0
number = int(input('Enter score or -1 to end input'))

while number != -1:
	if number < 45:
		number_of_fail+= 1

	if number >=  45:
		number_of_pass += 1
	count +=1
number = int(input('enter score or -1 to quit'))