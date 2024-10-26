#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct OrderNode {
    int order_id;
    char shoe_type[30];
    int quantity;
    char customer_name[50];
    int priority;
    struct OrderNode* next;
} OrderNode;


typedef struct {
    OrderNode* front;
    OrderNode* rear;
} ShoeOrderQueue;


OrderNode* createOrderNode(int order_id, const char* shoe_type, int quantity, const char* customer_name, int priority) {
    OrderNode* newNode = (OrderNode*)malloc(sizeof(OrderNode));
    newNode->order_id = order_id;
    strcpy(newNode->shoe_type, shoe_type);
    newNode->quantity = quantity;
    strcpy(newNode->customer_name, customer_name);
    newNode->priority = priority;
    newNode->next = NULL;
    return newNode;
}


void initializeQueue(ShoeOrderQueue* queue) {
    queue->front = queue->rear = NULL;
}


int isQueueEmpty(ShoeOrderQueue* queue) {
    return queue->front == NULL;
}


void enqueue(ShoeOrderQueue* queue, int order_id, const char* shoe_type, int quantity, const char* customer_name) {
    OrderNode* newOrder = createOrderNode(order_id, shoe_type, quantity, customer_name, 0);
    if (isQueueEmpty(queue)) {
        queue->front = queue->rear = newOrder;
    } else {
        queue->rear->next = newOrder;
        queue->rear = newOrder;
    }
    printf("Order %d for %d x %s added to the queue.\n", order_id, quantity, shoe_type);
}


OrderNode* dequeue(ShoeOrderQueue* queue) {
    if (isQueueEmpty(queue)) {
        printf("The queue is empty.\n");
        return NULL;
    }
    OrderNode* removedOrder = queue->front;
    queue->front = queue->front->next;
    if (queue->front == NULL) {  
        queue->rear = NULL;
    }
    printf("Order %d for %s processed.\n", removedOrder->order_id, removedOrder->shoe_type);
    return removedOrder;
}


OrderNode* peek(ShoeOrderQueue* queue) {
    if (isQueueEmpty(queue)) {
        printf("The queue is empty.\n");
        return NULL;
    }
    return queue->front;
}


void priorityEnqueue(ShoeOrderQueue* queue, int order_id, const char* shoe_type, int quantity, const char* customer_name, int priority) {
    OrderNode* newOrder = createOrderNode(order_id, shoe_type, quantity, customer_name, priority);
    if (isQueueEmpty(queue) || queue->front->priority < priority) {
        newOrder->next = queue->front;
        queue->front = newOrder;
        if (queue->rear == NULL) queue->rear = newOrder; 
    } else {
        OrderNode* temp = queue->front;
        while (temp->next != NULL && temp->next->priority >= priority) {
            temp = temp->next;
        }
        newOrder->next = temp->next;
        temp->next = newOrder;
        if (newOrder->next == NULL) queue->rear = newOrder; 
    }
    printf("Priority order %d for %d x %s added to the queue.\n", order_id, quantity, shoe_type);
}


int main() {
    ShoeOrderQueue queue;
    initializeQueue(&queue);


    enqueue(&queue, 101, "Running Shoes", 2, "Alice");
    enqueue(&queue, 102, "Sneakers", 1, "Bob");
    

    priorityEnqueue(&queue, 103, "Sports Shoes", 1, "Charlie", 1); 
    priorityEnqueue(&queue, 104, "Formal Shoes", 3, "David", 0); 


    OrderNode* frontOrder = peek(&queue);
    if (frontOrder != NULL) {
        printf("Next order to process: %d for %d x %s\n", frontOrder->order_id, frontOrder->quantity, frontOrder->shoe_type);
    }


    dequeue(&queue);
    dequeue(&queue);
    
    return 0;
}
