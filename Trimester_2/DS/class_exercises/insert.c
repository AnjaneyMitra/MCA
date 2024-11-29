#include <stdio.h>
#include <stdlib.h>


struct Node {
    int data;
    struct Node* next;
};


void insertNode(struct Node** head, int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}


void insertionSortArray(int arr[], int n) {
    int i, key, j;
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}


void insertionSortLinkedList(struct Node* head) {
    struct Node* sorted = NULL;
    struct Node* current = head;

    while (current != NULL) {
        struct Node* next = current->next;


        if (sorted == NULL || sorted->data >= current->data) {
            current->next = sorted;
            sorted = current;
        }
        else {
            struct Node* temp = sorted;
            while (temp->next != NULL && temp->next->data < current->data) {
                temp = temp->next;
            }
            current->next = temp->next;
            temp->next = current;
        }

        current = next;
    }


    head = sorted;
}


void printArray(int arr[], int n) {
    int i;
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


void printLinkedList(struct Node* head) {
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {



    int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Array before sorting: ");
    printArray(arr, n);

    insertionSortArray(arr, n);

    printf("Array after sorting: ");
    printArray(arr, n);

    printf("\n");


    struct Node* head = NULL;
    insertNode(&head, 64);
    insertNode(&head, 34);
    insertNode(&head, 25);
    insertNode(&head, 12);
    insertNode(&head, 22);
    insertNode(&head, 11);
    insertNode(&head, 90);

    printf("Linked list before sorting: ");
    printLinkedList(head);

    insertionSortLinkedList(head);

    printf("Linked list after sorting: ");
    printLinkedList(head);

    return 0;
}