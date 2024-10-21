#include <iostream>
#include <string>
#include<vector>

using namespace std;

class aboutStudents{

    private: 
    string studentName;
    int studentID;
    double GPA;

    public: 
    
    Students(int studID, string studName, double gpa ){

        studentID = studID;
        studentName = studName;
        GPA = gpa;
    }

    void displayStudent(){

    }

    void addStudents(){
        cout << "Hello" << endl;
    }

    void delStudents(){

    }

    void editStudents(){

    }

    void displayAllStudents(){

    }
    
};

int main(){

aboutStudents students(int Id, string name, double gpa);

students.addStudents();

}