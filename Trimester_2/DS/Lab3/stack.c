#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define MAX 100

char stack[MAX];
int top = -1;

void push(char c) {
    if (top == (MAX - 1)) {
        printf("Stack overflow\n");
        return;
    }
    stack[++top] = c;
}

char pop() {
    if (top == -1) {
        printf("Stack underflow\n");
        return -1;
    }
    return stack[top--];
}

int precedence(char c) {
    if (c == '^')
        return 3;
    else if (c == '*' || c == '/')
        return 2;
    else if (c == '+' || c == '-')
        return 1;
    else
        return 0;
}

int isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
}

void infixToPostfix(char* exp) {
    int i, k = 0;
    char output[MAX];
    for (i = 0; exp[i]; i++) {
        if (isalnum(exp[i])) {
            output[k++] = exp[i];
        } else if (exp[i] == '(') {
            push(exp[i]);
        } else if (exp[i] == ')') {
            while (top != -1 && stack[top] != '(')
                output[k++] = pop();
            pop(); // Remove '('
        } else if (isOperator(exp[i])) {
            while (top != -1 && precedence(stack[top]) >= precedence(exp[i]))
                output[k++] = pop();
            push(exp[i]);
        }
    }

    while (top != -1) {
        output[k++] = pop();
    }

    output[k] = '\0'; 
    printf("Postfix expression: %s\n", output);
}

int main() {
    char expression[MAX];
    int choice;

    do {
        printf("\nMenu:\n");
        printf("1. Convert infix to postfix\n");
        printf("2. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter infix expression: ");
                scanf("%s", expression);
                infixToPostfix(expression);
                break;
            case 2:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice\n");
        }
    } while (choice != 2);

    return 0;
}
