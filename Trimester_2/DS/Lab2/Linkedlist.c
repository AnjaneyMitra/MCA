#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct ProductNode {
    int product_id;
    char product_name[50];
    float price;
    struct ProductNode* next;
} ProductNode;


void insertProduct(ProductNode** head, int id, const char* name, float price) {
    ProductNode* newNode = (ProductNode*)malloc(sizeof(ProductNode));
    newNode->product_id = id;
    strcpy(newNode->product_name, name);
    newNode->price = price;
    newNode->next = *head;
    *head = newNode;
}


void deleteProduct(ProductNode** head, int id) {
    ProductNode *temp = *head, *prev = NULL;
    if (temp != NULL && temp->product_id == id) {
        *head = temp->next;
        free(temp);
        printf("Product with ID %d deleted.\n", id);
        return;
    }
    while (temp != NULL && temp->product_id != id) {
        prev = temp;
        temp = temp->next;
    }
    if (temp == NULL) {
        printf("Product with ID %d not found.\n", id);
        return;
    }
    prev->next = temp->next;
    free(temp);
    printf("Product with ID %d deleted.\n", id);
}


void searchProduct(ProductNode* head, int id) {
    ProductNode* current = head;
    while (current != NULL) {
        if (current->product_id == id) {
            printf("Product found: %s, Price: %.2f\n", current->product_name, current->price);
            return;
        }
        current = current->next;
    }
    printf("Product with ID %d not found.\n", id);
}


void displayProducts(ProductNode* head) {
    ProductNode* current = head;
    printf("Product List:\n");
    while (current != NULL) {
        printf("ID: %d, Name: %s, Price: %.2f\n", current->product_id, current->product_name, current->price);
        current = current->next;
    }
}

int main() {
    ProductNode* head = NULL;
    insertProduct(&head, 1, "Sneakers", 49.99);
    insertProduct(&head, 2, "Boots", 89.99);
    insertProduct(&head, 3, "Sandals", 29.99);

    displayProducts(head);
    searchProduct(head, 2);
    deleteProduct(&head, 2);
    displayProducts(head);

    return 0;
}
