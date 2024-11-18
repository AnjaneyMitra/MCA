#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_RECORDS 10
#define MAX_NAME_LEN 50

typedef struct {
    int id;
    char brand[MAX_NAME_LEN];
    float price;
    int size;
} Shoe;

void generateRandomShoes(Shoe shoes[], int count) {
    char *brands[] = {"Nike", "Adidas", "Puma", "Reebok", "Skechers"};
    int numBrands = sizeof(brands) / sizeof(brands[0]);

    srand(time(NULL));
    for (int i = 0; i < count; i++) {
        shoes[i].id = i + 1;
        strcpy(shoes[i].brand, brands[rand() % numBrands]);
        shoes[i].price = (rand() % 5000 + 1000) / 100.0;
        shoes[i].size = rand() % 11 + 5;
    }
}

void merge(Shoe shoes[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    Shoe L[n1], R[n2];
    for (int i = 0; i < n1; i++) L[i] = shoes[left + i];
    for (int j = 0; j < n2; j++) R[j] = shoes[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i].price <= R[j].price)
            shoes[k++] = L[i++];
        else
            shoes[k++] = R[j++];
    }

    while (i < n1) shoes[k++] = L[i++];
    while (j < n2) shoes[k++] = R[j++];
}

void mergeSort(Shoe shoes[], int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(shoes, left, mid);
        mergeSort(shoes, mid + 1, right);
        merge(shoes, left, mid, right);
    }
}

int partition(Shoe shoes[], int low, int high) {
    float pivot = shoes[high].price;
    int i = (low - 1);

    for (int j = low; j < high; j++) {
        if (shoes[j].price < pivot) {
            i++;
            Shoe temp = shoes[i];
            shoes[i] = shoes[j];
            shoes[j] = temp;
        }
    }
    Shoe temp = shoes[i + 1];
    shoes[i + 1] = shoes[high];
    shoes[high] = temp;
    return i + 1;
}

void quickSort(Shoe shoes[], int low, int high) {
    if (low < high) {
        int pi = partition(shoes, low, high);
        quickSort(shoes, low, pi - 1);
        quickSort(shoes, pi + 1, high);
    }
}

void writeToFile(const char *filename, Shoe shoes[], int count) {
    FILE *file = fopen(filename, "w");
    if (!file) {
        perror("Error opening file for writing");
        return;
    }

    fprintf(file, "ID\tBrand\t\tPrice\tSize\n");
    for (int i = 0; i < count; i++) {
        fprintf(file, "%d\t%-10s\t%.2f\t%d\n", shoes[i].id, shoes[i].brand, shoes[i].price, shoes[i].size);
    }

    fclose(file);
    printf("Data written to %s successfully.\n", filename);
}

void readFromFile(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) {
        perror("Error opening file for reading");
        return;
    }

    char buffer[100];
    while (fgets(buffer, sizeof(buffer), file)) {
        printf("%s", buffer);
    }

    fclose(file);
}

int main() {
    Shoe shoes[MAX_RECORDS];
    generateRandomShoes(shoes, MAX_RECORDS);

    printf("Original Shoe Data:\n");
    for (int i = 0; i < MAX_RECORDS; i++) {
        printf("ID: %d, Brand: %s, Price: %.2f, Size: %d\n", 
                shoes[i].id, shoes[i].brand, shoes[i].price, shoes[i].size);
    }

    mergeSort(shoes, 0, MAX_RECORDS - 1);
    writeToFile("merge_sort_output.txt", shoes, MAX_RECORDS);

    printf("\nMerge Sort Result:\n");
    readFromFile("merge_sort_output.txt");

    generateRandomShoes(shoes, MAX_RECORDS);

    quickSort(shoes, 0, MAX_RECORDS - 1);
    writeToFile("quick_sort_output.txt", shoes, MAX_RECORDS);

    printf("\nQuick Sort Result:\n");
    readFromFile("quick_sort_output.txt");

    return 0;
}
