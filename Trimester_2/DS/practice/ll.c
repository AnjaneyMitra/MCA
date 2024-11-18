#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
};



void insertfront(struct Node** head, int data){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

void delete(struct Node** head, int data){
    struct Node* temp = *head, *prev = NULL;
    if(temp != NULL && temp->data == data){
        *head = temp->next;
        free(temp);
        return;
    }
    while(temp != NULL && temp->data != data){
        prev = temp;
        temp = temp->next;
    }
    if(temp == NULL){
        return;
    }
    prev->next = temp->next;
    free(temp);
}

void insertAnywhere(struct Node** head, int data, int position){
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    struct Node* temp = *head;
    for(int i = 0; i < position-1; i++){
        temp = temp->next;
    }
    newNode->next = temp->next;
    temp->next = newNode;
}