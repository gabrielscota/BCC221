#include "../../domain/entities/user_permissions.hpp"

UserPermissions::UserPermissions() {}

UserPermissions::UserPermissions(string id, vector<string> permissions)
{
    this->id = id;
    this->permissions = permissions;
}

UserPermissions::~UserPermissions() {}

string UserPermissions::getId()
{
    return this->id;
}

void UserPermissions::showMenuOptions()
{
    cout << "" << endl;
}

vector<string> UserPermissions::getPermissions()
{
    return this->permissions;
}

string UserPermissions::getType()
{
    return "UserPermissions";
}

void UserPermissions::setPermissions(vector<string> permissions)
{
    this->permissions = permissions;
}

//  GeneralUser, AdministrativeAssistantUser, AdministrativeUser left

GeneralUser::GeneralUser()
{
    this->setPermissions({"schedule"});
};

GeneralUser::~GeneralUser(){};

string GeneralUser::getType()
{
    return "GeneralUser";
}

void GeneralUser::showMenuOptions()
{
    int option = -1;
    cout << "1 - Agenda" << endl;
    cout << "0 - Deslogar" << endl;
    while (option != 0)
    {
        cout << "\n> Informe uma das opcoes acima: ";
        cin >> option;
        switch (option)
        {
        case 1:
            cout << "chama funcao edita agenda" << endl;
            break;
        case 0:
            system("clear || cls");
            cout << "\n[!] Voce esta saindo do sistema, volte sempre!\n"
                 << endl;
            break;
        default:
            cout << "Opcao Invalida." << endl;
            break;
        }
    }
}

AdministrativeAssistantUser::AdministrativeAssistantUser()
{
    this->setPermissions({"schedule"});
};

AdministrativeAssistantUser::~AdministrativeAssistantUser(){};

string AdministrativeAssistantUser::getType()
{
    return "AdministrativeAssistantUser";
}

void AdministrativeAssistantUser::showMenuOptions()
{
    int option = -1;
    cout << "1 - Agenda" << endl;
    cout << "2 - Receber consulta" << endl;
    cout << "3 - Fazer pagamento de contas" << endl;
    cout << "4 - Folha de ponto" << endl;
    cout << "0 - Deslogar" << endl;
    while (option != 0)
    {
        cout << "\n> Informe uma das opcoes acima: ";
        cin >> option;
        switch (option)
        {
        case 1:
            cout << "chama funcao edita agenda" << endl;
            break;
        case 2:
            cout << "chama funcao cadastra despesa" << endl;
            break;
        case 0:
            system("clear || cls");
            cout << "\n[!] Voce esta saindo do sistema, volte sempre!\n"
                 << endl;
            break;
        default:
            cout << "Opcao Invalida." << endl;
            break;
        }
    }
}

AdministrativeUser::AdministrativeUser()
{
    this->setPermissions({"schedule"});
};

AdministrativeUser::~AdministrativeUser(){};

string AdministrativeUser::getType()
{
    return "AdministrativeUser";
}

void AdministrativeUser::showMenuOptions()
{
    int option = -1;
    cout << "1 - Agenda" << endl;
    cout << "2 - Receber consulta" << endl;
    cout << "3 - Fazer pagamento de contas" << endl;
    cout << "4 - Folha de ponto" << endl;
    cout << "0 - Deslogar" << endl;
    while (option != 0)
    {
        cout << "\n> Informe uma das opcoes acima: ";
        cin >> option;
        switch (option)
        {
        case 1:
            cout << "chama funcao edita agenda" << endl;
            break;
        case 2:
            cout << "chama funcao cadastra despesa" << endl;
            break;
        case 3:
            cout << "chama funcao de gerar relatorio" << endl;
            break;
        case 0:
            system("clear || cls");
            cout << "\n[!] Voce esta saindo do sistema, volte sempre!\n"
                 << endl;
            break;
        default:
            cout << "Opcao invalida." << endl;
            break;
        }
    }
}