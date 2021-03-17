#include "../../domain/entities/user_permissions.hpp"
#include "../../domain/entities/clinic.hpp"

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

void UserPermissions::showMenuOptions(Clinic *clinic)
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

void GeneralUser::showMenuOptions(Clinic *clinic)
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
            clinic->listOrthodontists();
            scheduleOption(clinic);
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

void AdministrativeAssistantUser::showMenuOptions(Clinic *clinic)
{
    int option = -1;
    cout << "1 - Agenda" << endl;
    cout << "2 - Fazer pagamento de conta" << endl;
    cout << "0 - Deslogar" << endl;
    while (option != 0)
    {
        cout << "\n> Informe uma das opcoes acima: ";
        cin >> option;
        switch (option)
        {
        case 1:
            clinic->listOrthodontists();
            scheduleOption(clinic);
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

void AdministrativeUser::showMenuOptions(Clinic *clinic)
{
    int option = -1;
    cout << "1 - Agenda" << endl;
    cout << "2 - Fazer pagamento de conta" << endl;
    cout << "3 - Receber consulta" << endl;
    cout << "0 - Deslogar" << endl;
    while (option != 0)
    {
        cout << "1 - Agenda" << endl;
        cout << "2 - Fazer pagamento de conta" << endl;
        cout << "3 - Relatorio" << endl;
        cout << "4 - Criar novo usuario" << endl;
        cout << "0 - Deslogar" << endl;
        cout << "\n> Informe uma das opcoes acima: ";
        cin >> option;
        switch (option)
        {
        case 1:
            clinic->listOrthodontists();
            scheduleOption(clinic);
            break;
        case 2:
            clinic->payExpense();
            break;
        case 3:
            clinic->receiveConsultation();
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

void scheduleOption(Clinic *clinic){
    int option, consultationOp;
    int orthodontistOp;
    cout<<"[!] Selecione, pelo indice, o ortodontista desejado, ou digite um indice inexistente para sair"<<endl;
    cin>>orthodontistOp;

    if(orthodontistOp >= 0 && orthodontistOp < clinic->getOrthodontists().size()){
        cout<< "\n[!] Digite a operacao desejada:\n"
            << "\n[0] Visualizar Consultas"
            << "\n[1] Adicionar Consulta"
            << "\n[2] Editar Consulta"
            << "\n[3] Remover Consulta"
            << "\n[!] Digite qualquer tecla diferente para sair!"<<endl;
    
        cin>>option;
    
        switch(option){
            case 0:
                clinic->displaySchedule(orthodontistOp);
                break;
            case 1:
                clinic->createConsultation(orthodontistOp);
                break;
            case 2:
                clinic->displaySchedule(orthodontistOp);
                cout<< "\n[!] Digite a consulta que deseja alterar:\n";
                cin >> consultationOp;
                clinic->editarConsulta(orthodontistOp, consultationOp);
                break;
            case 3:
                clinic->displaySchedule(orthodontistOp);
                cout<< "\n[!] Digite a consulta que deseja remover:\n";
                cin >> consultationOp;
                clinic->deleteConsulta(orthodontistOp, consultationOp);
            default:
                break;
        }
    }



}