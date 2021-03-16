all: ./generated/admin.o ./generated/assistent.o ./generated/clinic.o ./generated/consultation.o ./generated/employee.o ./generated/expense.o ./generated/orthodontist.o ./generated/patient.o ./generated/payment_consultation.o ./generated/payment.o ./generated/person.o ./generated/point.o ./generated/receptionist.o ./generated/schedule.o ./generated/time_sheet.o ./generated/user_permissions.o ./generated/user.o main.cpp
	g++ -o ./generated/main main.cpp ./generated/admin.o ./generated/assistent.o ./generated/clinic.o ./generated/consultation.o ./generated/employee.o ./generated/expense.o ./generated/orthodontist.o ./generated/patient.o ./generated/payment_consultation.o ./generated/payment.o ./generated/person.o ./generated/point.o ./generated/receptionist.o ./generated/schedule.o ./generated/time_sheet.o ./generated/user_permissions.o ./generated/user.o -Wall

./generated/admin.o: ./data/models/admin.cpp
	g++ -o ./generated/admin.o -c ./data/models/admin.cpp

./generated/assistent.o: ./data/models/assistent.cpp
	g++ -o ./generated/assistent.o -c ./data/models/assistent.cpp

./generated/clinic.o: ./data/models/clinic.cpp
	g++ -o ./generated/clinic.o -c ./data/models/clinic.cpp

./generated/consultation.o: ./data/models/consultation.cpp
	g++ -o ./generated/consultation.o -c ./data/models/consultation.cpp

./generated/employee.o: ./data/models/employee.cpp
	g++ -o ./generated/employee.o -c ./data/models/employee.cpp

./generated/expense.o: ./data/models/expense.cpp
	g++ -o ./generated/expense.o -c ./data/models/expense.cpp

./generated/orthodontist.o: ./data/models/orthodontist.cpp
	g++ -o ./generated/orthodontist.o -c ./data/models/orthodontist.cpp

./generated/patient.o: ./data/models/patient.cpp
	g++ -o ./generated/patient.o -c ./data/models/patient.cpp

./generated/payment_consultation.o: ./data/models/payment_consultation.cpp
	g++ -o ./generated/payment_consultation.o -c ./data/models/payment_consultation.cpp

./generated/payment.o: ./data/models/payment.cpp
	g++ -o ./generated/payment.o -c ./data/models/payment.cpp

./generated/person.o: ./data/models/person.cpp
	g++ -o ./generated/person.o -c ./data/models/person.cpp

./generated/point.o: ./data/models/point.cpp
	g++ -o ./generated/point.o -c ./data/models/point.cpp

./generated/receptionist.o: ./data/models/receptionist.cpp
	g++ -o ./generated/receptionist.o -c ./data/models/receptionist.cpp

./generated/schedule.o: ./data/models/schedule.cpp
	g++ -o ./generated/schedule.o -c ./data/models/schedule.cpp

./generated/time_sheet.o: ./data/models/time_sheet.cpp
	g++ -o ./generated/time_sheet.o -c ./data/models/time_sheet.cpp

./generated/user_permissions.o: ./data/models/user_permissions.cpp
	g++ -o ./generated/user_permissions.o -c ./data/models/user_permissions.cpp

./generated/user.o: ./data/models/user.cpp
	g++ -o ./generated/user.o -c ./data/models/user.cpp

clean:
	rm -f ./generated/*.o ./generated/main

run:
	./generated/main