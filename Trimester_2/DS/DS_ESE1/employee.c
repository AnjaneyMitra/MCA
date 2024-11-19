#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

typedef struct Employee {
    int Employee_ID;
    char name[100];
    float Performance_Score;
    struct Employee* next;
} Employee;

void clearInputBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}

int isEmployeeIdUnique(struct Employee* head, int id) {
    struct Employee* current = head;
    while (current != NULL) {
        if (current->Employee_ID == id) {
            return 0;  
        }
        current = current->next;
    }
    return 1; 
}

void InsertEnd(struct Employee** head, struct Employee* newEmployee) {
    if (*head == NULL) {
        *head = newEmployee;
        return;
    }
    struct Employee* current = *head;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = newEmployee;
}

void DisplayDetails(struct Employee* head) {
    if (head == NULL) {
        printf("No employees found in this list.\n");
        return;
    }
    
    struct Employee* current = head;
    while (current != NULL) {
        printf("Employee ID: %d\n", current->Employee_ID);
        printf("Name: %s\n", current->name);
        printf("Performance Score: %.2f\n", current->Performance_Score);
        printf("\n");
        current = current->next;
    }
}

int isNameValid(const char* name) {
    for (int i = 0; name[i] != '\0'; i++) {
        if (!isalpha(name[i]) && name[i] != ' ') {
            return 0;
        }
    }
    return 1;
}

int getValidIntegerInput(const char* prompt) {
    int value;
    char temp;
    while (1) {
        printf("%s", prompt);
        if (scanf("%d%c", &value, &temp) == 2 && temp == '\n') {
            return value;
        }
        printf("Invalid input! Please enter an integer value.\n");
        clearInputBuffer();
    }
}

float getValidFloatInput(const char* prompt) {
    float value;
    char temp;
    while (1) {
        printf("%s", prompt);
        if (scanf("%f%c", &value, &temp) == 2 && temp == '\n') {
            return value;
        }
        printf("Invalid input! Please enter a numeric value.\n");
        clearInputBuffer();
    }
}

void Split_list(struct Employee* head, struct Employee** lowScoreList, struct Employee** highScoreList) {

    while (*lowScoreList != NULL) {
        struct Employee* temp = *lowScoreList;
        *lowScoreList = (*lowScoreList)->next;
        free(temp);
    }
    while (*highScoreList != NULL) {
        struct Employee* temp = *highScoreList;
        *highScoreList = (*highScoreList)->next;
        free(temp);
    }
    
    struct Employee* current = head;
    while (current != NULL) {
        struct Employee* newNode = (struct Employee*)malloc(sizeof(struct Employee));
        if (newNode == NULL) {
            printf("Memory allocation failed!\n");
            return;
        }
        newNode->Employee_ID = current->Employee_ID;
        strcpy(newNode->name, current->name);
        newNode->Performance_Score = current->Performance_Score;
        newNode->next = NULL;
        
        if (current->Performance_Score < 40) {
            InsertEnd(lowScoreList, newNode);
        } else {
            InsertEnd(highScoreList, newNode);
        }
        current = current->next;
    }
}

int main() {
    struct Employee* head = NULL;
    struct Employee* lowScoreList = NULL;
    struct Employee* highScoreList = NULL;
    int choice;
    
    do {
        printf("\nMenu:\n");
        printf("1. Add Employee\n");
        printf("2. Display Employees with low performance\n");
        printf("3. Display Employees with high performance\n");
        printf("4. Display All Employees\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        if (scanf("%d", &choice) != 1) {
            printf("Invalid input! Please enter a valid choice.\n");
            clearInputBuffer();
            choice = 0;
            continue;
        }
        clearInputBuffer();
        
        switch (choice) {
            case 1: {
                struct Employee* newEmployee = (struct Employee*)malloc(sizeof(struct Employee));
                if (newEmployee == NULL) {
                    printf("Memory allocation failed!\n");
                    break;
                }
                
                int id;
                while (1) {
                    id = getValidIntegerInput("Enter Employee ID: ");
                    if (id < 0) {
                        printf("Error: Employee ID cannot be negative!\n");
                        continue;
                    }
                    if (!isEmployeeIdUnique(head, id)) {
                        printf("Error: Employee ID already exists!\n");
                        continue;
                    }
                    break;
                }
                newEmployee->Employee_ID = id;
                
                while (1) {
                    printf("Enter Employee Name: ");
                    fgets(newEmployee->name, sizeof(newEmployee->name), stdin);
                    newEmployee->name[strcspn(newEmployee->name, "\n")] = 0;
                    if (!isNameValid(newEmployee->name)) {
                        printf("Error: Name can only contain alphabetic characters and spaces!\n");
                        continue;
                    }
                    break;
                }
                
                float score;
                while (1) {
                    score = getValidFloatInput("Enter Performance Score (0-100): ");
                    if (score < 0 || score > 100) {
                        printf("Invalid score! Please enter a score between 0 and 100.\n");
                        continue;
                    }
                    break;
                }
                newEmployee->Performance_Score = score;
                
                newEmployee->next = NULL;
                InsertEnd(&head, newEmployee);
                Split_list(head, &lowScoreList, &highScoreList);  
                printf("Employee added successfully!\n");
                break;
            }
            case 2: {
                printf("Employees with low performance (Score < 40):\n");
                DisplayDetails(lowScoreList);
                break;
            }
            case 3: {
                printf("Employees with high performance (Score >= 40):\n");
                DisplayDetails(highScoreList);
                break;
            }
            case 4: {
                printf("All Employees:\n");
                DisplayDetails(head);
                break;
            }
            case 5: {
                printf("Exiting...\n");
                break;
            }
            default: {
                printf("Invalid choice! Please try again.\n");
                break;
            }
        }
    } while (choice != 5);
    
    return 0;
}
