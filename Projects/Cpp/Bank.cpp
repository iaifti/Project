#include<iostream>
#include<string>

using namespace std;

class Account {
private:
 
    int accNum;
    string name;
    double balance;


public:
    Account(int accNo, string accName, double accBalance){
        accNum =  accNo;
        name =  accName;
        balance =  accBalance;

    }

    void deposit(double amount){
        balance += amount;
        cout << "Deposited $" << amount << "only\n";
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

    void display(){
        cout <<  "Account Number: " << accNum << "\n";
        cout <<  "Name: " << name << "\n";
        cout <<  "Balance " << balance << "\n";
    }
};

int main(){
    int accountNumber;
    string accountName;
    double initialBalance;

    cout << "Please enter account Number : " << endl;
    cin >>  accountNumber;

    cin.ignore();

    cout <<  "Please enter your name :  "<< endl;
    getline(cin, accountName);

    cout << "Please enter the initial Balance: " << endl;
    cin >> initialBalance;

    Account userAccount (accountNumber, accountName, initialBalance);

    userAccount.display();

    return 0;

}