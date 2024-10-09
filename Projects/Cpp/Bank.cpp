/* A simple banking program
*  Md Istiaq Ahmed
*  MidTerm Project
*/

#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>

using namespace std;

// Class responsible for user authentication
class BankSystem {
private:
    const string correctUser = "jason";   // Hardcoded valid username
    const int correctPin = 1234;          // Hardcoded valid pin

public:
    // Method to authenticate the user
    bool authenticate(string username, int pin) {
        if (username == correctUser && pin == correctPin) {
            cout << "Access Granted!" << endl;
            return true;
        } else {
            cout << "Invalid credentials. Try Again!" << endl;
            return false;
        }
    }
};

// Class representing the bank account
class BankAccount {
private:
    int accountNumber;
    string name;
    double balance;

public:
    // Constructor to initialize the account
    BankAccount(int accNum, string accName, double accBalance) {
        accountNumber = accNum;
        name = accName;
        balance = accBalance;
    }

    // Method to display the account details
    void display() {
        cout << "Account Name: " << name << endl;
        cout << "Account No: " << accountNumber << endl;
        cout << fixed << setprecision(2) << "Account Balance: $" << balance << endl;
    }

    // Method to deposit an amount into the account
    void deposit(double amount) {
        balance += amount;
        cout << "You deposited $" << amount << endl;
        cout << "Current balance: $" << balance << endl;
    }

    // Method to withdraw an amount from the account
    void withdraw(double amount) {
        if (amount > balance) {
            cout << "Insufficient Balance!" << endl;
        } else {
            balance -= amount;
            cout << "Withdrawn $" << amount << " only." << endl;
            cout << "Current Balance: $" << balance << endl;
        }
    }
};

// Main function: Entry point of the program
int main() {
    BankSystem bankSystem;                // Create an object for the bank system
    string username;
    int pin;

    // Request username and pin from the user
    cout << "Enter username: ";
    cin >> username;
    cout << "Enter pin: ";
    cin >> pin;

    // Authenticate the user
    if (!bankSystem.authenticate(username, pin)) {
        return 1; // Exit if authentication fails
    }

    // Variables for account information
    int accountNumber;
    string accountName;
    double initialBalance;
    double amount;
    int choice;

    // Open and read data from the bank account file
    ifstream inputFile("bank.txt");
    if (!inputFile) {
        cerr << "Error loading file." << endl;
        return 1;
    }

    // Read the account information from the file
    inputFile >> accountNumber;
    inputFile.ignore();
    getline(inputFile, accountName);
    inputFile >> initialBalance;
    inputFile.close();

    // Create the BankAccount object with the data from the file
    BankAccount userAccount(accountNumber, accountName, initialBalance);

    // Display the initial account details
    userAccount.display();

    // Menu-driven loop for user actions (withdraw, deposit, exit)
    do {
        cout << "\nWhat would you like to do?\n";
        cout << "1. Withdraw\n2. Deposit\n3. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        // Validate if the choice is within range
        if (choice < 1 || choice > 3) {
            cout << "Invalid choice. Please enter 1, 2, or 3.\n";
            continue;
        }

        // Process user choices
        if (choice == 1) {
            // Handle withdrawal
            cout << "Enter the amount to withdraw: ";
            cin >> amount;

            // Validate if the amount is positive
            if (amount > 0) {
                userAccount.withdraw(amount);
            } else {
                cout << "Invalid amount. Must be greater than 0.\n";
            }

        } else if (choice == 2) {
            // Handle deposit
            cout << "Enter the amount to deposit: ";
            cin >> amount;

            // Validate if the amount is positive
            if (amount > 0) {
                userAccount.deposit(amount);
            } else {
                cout << "Invalid amount. Must be greater than 0.\n";
            }
        }

    } while (choice != 3);  // Exit the loop if the user chooses 3

    // Display exit message
    cout << "Thank you for using the bank!" << endl;

    return 0;
}
