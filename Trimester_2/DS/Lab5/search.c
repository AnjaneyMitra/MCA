#include <stdio.h>

#define MAX 100

typedef struct {
    int id;       
    float size;   
} Shoe;

// Linear Search
int linearSearch(Shoe arr[], int n, int id) {
    int comparisons = 0;
    for (int i = 0; i < n; i++) {
        comparisons++;
        if (arr[i].id == id) {
            printf("Linear Search Comparisons: %d\n", comparisons);
            return i;
        }
    }
    printf("Linear Search Comparisons: %d\n", comparisons);
    return -1;
}

// Sentinel Search
int sentinelSearch(Shoe arr[], int n, int id) {
    int comparisons = 0;
    Shoe last = arr[n - 1];
    arr[n - 1].id = id;
    int i = 0;
    while (arr[i].id != id) {
        i++;
        comparisons++;
    }
    arr[n - 1] = last;
    if (i < n - 1 || arr[n - 1].id == id) {
        printf("Sentinel Search Comparisons: %d\n", comparisons);
        return i;
    }
    printf("Sentinel Search Comparisons: %d\n", comparisons);
    return -1;
}

// Binary Search
int binarySearch(Shoe arr[], int left, int right, int id) {
    int comparisons = 0;
    while (left <= right) {
        comparisons++;
        int mid = left + (right - left) / 2;
        if (arr[mid].id == id) {
            printf("Binary Search Comparisons: %d\n", comparisons);
            return mid;
        } else if (arr[mid].id < id) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    printf("Binary Search Comparisons: %d\n", comparisons);
    return -1;
}

// Bubble Sort
void bubbleSort(Shoe arr[], int n) {
    int comparisons = 0, dataTransfers = 0;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            comparisons++;
            if (arr[j].size > arr[j + 1].size) {
                Shoe temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                dataTransfers += 3;
            }
        }
    }
    printf("Bubble Sort Comparisons: %d, Data Transfers: %d\n", comparisons, dataTransfers);
}

// Insertion Sort
void insertionSort(Shoe arr[], int n) {
    int comparisons = 0, dataTransfers = 0;
    for (int i = 1; i < n; i++) {
        Shoe key = arr[i];
        int j = i - 1;
        comparisons++;
        while (j >= 0 && arr[j].size > key.size) {
            arr[j + 1] = arr[j];
            dataTransfers++;
            j--;
        }
        arr[j + 1] = key;
        dataTransfers++;
    }
    printf("Insertion Sort Comparisons: %d, Data Transfers: %d\n", comparisons, dataTransfers);
}


void displayShoes(Shoe arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("Shoe ID: %d, Size: %.1f\n", arr[i].id, arr[i].size);
    }
}

int main() {
    Shoe shoes[MAX] = {
        {101, 9.5}, {102, 8.0}, {103, 10.0}, {104, 7.5}, {105, 9.0}
    };
    int n = 5;

    printf("Original Shoe List:\n");
    displayShoes(shoes, n);


    printf("\nBubble Sort on Shoe Sizes:\n");
    bubbleSort(shoes, n);
    displayShoes(shoes, n);


    printf("\nInsertion Sort on Shoe Sizes:\n");
    insertionSort(shoes, n);
    displayShoes(shoes, n);

    // Linear Search
    int searchID = 103;
    printf("\nLinear Search for Shoe ID %d:\n", searchID);
    int linearResult = linearSearch(shoes, n, searchID);
    if (linearResult != -1) {
        printf("Shoe found at index %d\n", linearResult);
    } else {
        printf("Shoe not found\n");
    }

    // Sentinel Search
    printf("\nSentinel Search for Shoe ID %d:\n", searchID);
    int sentinelResult = sentinelSearch(shoes, n, searchID);
    if (sentinelResult != -1) {
        printf("Shoe found at index %d\n", sentinelResult);
    } else {
        printf("Shoe not found\n");
    }


    printf("\nBinary Search for Shoe ID %d:\n", searchID);
    int binaryResult = binarySearch(shoes, 0, n - 1, searchID);
    if (binaryResult != -1) {
        printf("Shoe found at index %d\n", binaryResult);
    } else {
        printf("Shoe not found\n");
    }

    return 0;
}
