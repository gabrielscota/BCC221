all: ./generated/Pessoa.o ./generated/Administrador.o ./generated/Vendedor.o ./generated/Carro.o ./generated/Cliente.o ./generated/Funcionario.o ./generated/Item.o ./generated/MaoDeObra.o ./generated/Mecanico.o ./generated/Ordem.o ./generated/Servico.o ./generated/MenuAdmin.o ./generated/MenuMeca.o ./generated/MenuVend.o main.cpp
	g++ -o ./generated/main main.cpp ./generated/Pessoa.o ./generated/Administrador.o ./generated/Vendedor.o ./generated/Carro.o ./generated/Cliente.o ./generated/Funcionario.o ./generated/Item.o ./generated/MaoDeObra.o ./generated/Mecanico.o ./generated/Ordem.o ./generated/Servico.o ./generated/MenuAdmin.o ./generated/MenuMeca.o ./generated/MenuVend.o -Wall

./generated/admin.o: ./data/models/admin.cpp
	g++ -o ./generated/Pessoa.o -c ./Cpp/Pessoa.cpp

./generated/Ordem.o: ./Cpp/Ordem.cpp
	g++ -o ./generated/Ordem.o -c ./Cpp/Ordem.cpp

./generated/Administrador.o: ./Cpp/Administrador.cpp
	g++ -o ./generated/Administrador.o -c ./Cpp/Administrador.cpp

./generated/Vendedor.o: ./Cpp/Vendedor.cpp
	g++ -o ./generated/Vendedor.o -c ./Cpp/Vendedor.cpp

./generated/Carro.o: ./Cpp/Carro.cpp
	g++ -o ./generated/Carro.o -c ./Cpp/Carro.cpp

./generated/Cliente.o: ./Cpp/Cliente.cpp
	g++ -o ./generated/Cliente.o -c ./Cpp/Cliente.cpp

./generated/Funcionario.o: ./Cpp/Funcionario.cpp
	g++ -o ./generated/Funcionario.o -c ./Cpp/Funcionario.cpp

./generated/Item.o: ./Cpp/Item.cpp
	g++ -o ./generated/Item.o -c ./Cpp/Item.cpp

./generated/MaoDeObra.o: ./Cpp/MaoDeObra.cpp
	g++ -o ./generated/MaoDeObra.o -c ./Cpp/MaoDeObra.cpp

./generated/Mecanico.o: ./Cpp/Mecanico.cpp
	g++ -o ./generated/Mecanico.o -c ./Cpp/Mecanico.cpp

./generated/Servico.o: ./Cpp/Servico.cpp
	g++ -o ./generated/Servico.o -c ./Cpp/Servico.cpp

./generated/MenuAdmin.o: ./Cpp/MenuAdmin.cpp
	g++ -o ./generated/MenuAdmin.o -c ./Cpp/MenuAdmin.cpp

./generated/MenuMeca.o: ./Cpp/MenuMeca.cpp
	g++ -o ./generated/MenuMeca.o -c ./Cpp/MenuMeca.cpp

./generated/MenuVend.o: ./Cpp/MenuVend.cpp
	g++ -o ./generated/MenuVend.o -c ./Cpp/MenuVend.cpp

clean:
	rm -f ./generated/*.o ./generated/main

run:
	./generated/main