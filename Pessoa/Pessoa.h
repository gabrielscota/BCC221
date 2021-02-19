#ifndef PESSOA_H
#define PESSOA_H

#include<string>
using namespace std;

class Pessoa{
    string id, nome;
    
public:
    Pessoa();
    ~Pessoa();
    Pessoa(string);
    string getId() const;

    string getNome() const;
    void setNome(string);

};



#endif