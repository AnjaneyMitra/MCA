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
    int choice, id;
    char name[50];
    float price;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert a product\n");
        printf("2. Delete a product\n");
        printf("3. Search for a product\n");
        printf("4. Display all products\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter product ID: ");
                scanf("%d", &id);
                printf("Enter product name: ");
                scanf("%s", name);
                printf("Enter product price: ");
                scanf("%f", &price);
                insertProduct(&head, id, name, price);
                break;
            case 2:
                printf("Enter product ID to delete: ");
                scanf("%d", &id);
                deleteProduct(&head, id);
                break;
            case 3:
                printf("Enter product ID to search: ");
                scanf("%d", &id);
                searchProduct(head, id);
                break;
            case 4:
                displayProducts(head);
                break;
            case 5:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}
