#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX 10
void enqueue();
void dequeue();
bool isEmpty();
int size();
int front();
int queue_array[MAX];
int rear = -1;
int f = -1;
int n=0;

int main()
{
    enqueue(5);
    printf("\nEnsimmäinen luku on %d \n", front());
    enqueue(6);
    enqueue(7);
    dequeue();
    dequeue();
    dequeue();
    printf("\ntaulukon koko on %d \n", size());
    printf("\nensimmäinen luku on %d ", front());
    if(isEmpty())
        printf("\nJono tyhjä");
    else
        printf("\nJonossa numeroita");
    enqueue(5);
    printf("\nEnsimmäinen luku on %d \n", front());
    enqueue(6);
    enqueue(7);
    dequeue();
    printf("taulukon koko on %d \n", size());
    printf("\nEnsimmäinen luku on %d ", front());
    if(isEmpty())
        printf("\nJono tyhjä");
    else
        printf("\nJonossa numeroita");

    
}

void enqueue(int alkio) {
    n++;
    int item=alkio;
    if(rear == MAX - 1)
    printf("Jono täysi");
    else{
        if(f== - 1)
            f = 0;
        rear = rear + 1;
        queue_array[rear] = item;
        }
    }

void dequeue(){
    n--;
    if(f == - 1 || f > rear) {
        printf("Jono täysi");
        return;
        }
    else {
        f = f + 1;
        }
    }

int size(){
    int koko=n;
    return koko;
    }

int front(){
    int eka=queue_array[f];
    
    return eka;
    }
    
bool isEmpty(){
    bool x=false;
    
    if (n==0)
        x = true;
    return x;
}
