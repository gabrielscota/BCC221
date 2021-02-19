#include "Pessoa.h"



Pessoa::Pessoa(string nome){
    this->setNome(nome);
    //this->id = Ver vídeo static (construtores, minuto 12)
}

Pessoa::~Pessoa(){}

string Pessoa::getId() const{
    return this->id;
}

string Pessoa::getNome() const{
    return this->nome;
}

void Pessoa::setNome(string nome){
    this->nome = nome;
}
