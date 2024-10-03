#include<iostream>
#include<string>

using namespace std;

class againBank
{
private:
    int accountNumber;
    string name;
    double balance;

public:
  againBank(int accNum, string accName, double accbalance){

        accountNumber = accNum;
        name = accName;
        balance = accbalance;
    }

    void display(){
        cout  <<  "Account Name :  " <<  name << endl;
        cout  <<  "Account No :  " <<  accountNumber << endl;
        cout  <<  "Account Balance :  " <<  balance << endl;
    
    }

    void deposit(double amount){
        balance += amount;
        cout <<  "You deposited $" << amount << endl;
        cout << "Current balance $" <<  balance << endl;
    }

     void withdraw(double amount){
        if(amount > balance){
            cout << "Insufficient Balance!\n";
        }
        else{
        balance -= amount;
        cout <<  "Withdrawn $" << amount << "only\n";
        cout << "Balance is $" << balance << "\n";
        }
    }
};

int main(){

    const string user = "jason";
    const int pass =  1234;
    string userInput;
    int userPin;

    int accountNumber;
    string accountName;
    double initialBalance;
    double amount; 
    int choice;

    do
    {
        cout <<  "Enter username: " << endl;
        cin >> userInput;
        cout <<  "Enter pin: " << endl;
        cin >> userPin;

        if (userInput ==  user && userPin == pass)
        {
            cout <<  "Access Granted!!" << endl;
            break;
        }
        else{
            cout << "Try Again! " << endl;
        }
        
    } while (true);

    cout << "Please enter account Number : " << endl;
    cin >>  accountNumber;

    cin.ignore();

    cout <<  "Please enter your name :  "<< endl;
    getline(cin, accountName);

    cout << "Please enter the initial Balance: " << endl;
    cin >> initialBalance;

    againBank userAccount(accountNumber, accountName, initialBalance);

    userAccount.display();

    do{
        
    cout << "Would Like to\n Withdraw(1) \n Deposit(2)\n Exit(3)" << endl << endl;
    cin >> choice;

    if(choice ==  1){

        cout << "Enter your withdraw amount: " << endl << endl;
        cin >> amount;
        userAccount.withdraw(amount);

    }
    if(choice ==  2){

        cout << "Enter your deposit amount: " << endl << endl;
        cin >> amount;
        userAccount.deposit(amount);

    }
    if(choice ==  3){

        cout << "Thank you for using the Bank!" << endl <<  endl;

    }
    }while (choice != 3);
}
