#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int number;
    struct node *left;
    struct node *right;
}
node;

void free_tree(node *root);
void print_tree(node *root);

int main(void)
{
    node * tree = NULL;

    //add a number to list
    node *n = malloc(sizeof(node));
    if (n == NULL)
    {
        return 1;
    }
    
    n->number = 2;
    n->left = NULL;
    n->right = NULL;
    tree = n;

    //add a number to list
    n = malloc(sizeof(node));
    if (n == NULL)
    {
        //free_tree(tree);
        return 1;
    }

    n->number = 1;
    n->left = NULL;
    n->right = NULL;
    tree->left = n;

    //add a number to list
    n = malloc(sizeof(node));
    if (n == NULL)
    {
        //free_tree(tree);
        return 1;
    }
    n->number = 3;
    n->left = NULL;
    n->right = NULL;
    tree->right = n;

    print_tree(tree);
    free_tree(tree);
    
}