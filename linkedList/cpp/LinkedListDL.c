#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node * next;
	struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void InsertFirst(PPNODE First, int no)
{
	PNODE newn =(PNODE)malloc(sizeof(NODE));
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(*First == NULL)
	{
		*First = newn;
	}
	else
	{
		newn->next = *First;
		(*First)->prev = newn;
		*First = newn;
	}
}

void InsertLast(PPNODE First, int no)
{
	PNODE newn =(PNODE)malloc(sizeof(NODE));
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	PNODE temp = *First;
	int iCnt = 0;
	if(*First == NULL)
	{
		*First = newn;
	}
	else
	{
		while(temp->next != NULL)
		{
			temp = temp->next;
		}	
		newn->prev = temp;
		temp->next = newn;
	}
}

void DeleteFirst(PPNODE First)
{
	PNODE temp = *First;
	if(*First == NULL)
	{
		return;
	}
	else if((*First)->next == NULL)
	{
		free(*First);
		*First = NULL;
	}
	else
	{
		*First = (*First)->next;
		free(temp);
		(*First)->prev = NULL;
	}	
}

void DeleteLast(PPNODE First)
{
	PNODE temp = *First;
	if(*First == NULL)
	{
		return;
	}
	else if((*First)->next == NULL)
	{
		free(*First);
		*First = NULL;
	}
	else
	{
		while((temp)->next->next != NULL)
		{
			temp = temp-> next;
		}	
		free(temp->next);
		temp->next = NULL;
	}	
}

int Count(PNODE First)
{
	int iCnt = 0;
	while(First != NULL)
	{
		iCnt++;
		First = First -> next;
	}
	return iCnt;
}

void Display(PNODE First)
{
	printf("Element in linked list are : \n");
	printf("NULL<=>");
	while(First != NULL)
	{
		printf("|%d|<=>",First->data);
		First = First -> next;
	}
	printf("NULL\n");
}


void InsertAtPos(PPNODE First, int no, int ipos)
{
	int iNodeCnt = 0, iCnt = 0;
    PNODE newn = NULL;
    PNODE temp = NULL;
	
	iNodeCnt = Count(*First);
	if((ipos < 1) || (ipos >(iNodeCnt+1)))
	{
		printf("Invalid position\n");
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst(First, no);
	}
	else if(ipos == (iNodeCnt+1))
	{
		InsertLast(First, no);
	}
	else
	{
		PNODE newn =(PNODE)malloc(sizeof(NODE));
		newn->data = no;
		newn->next = NULL;
		newn->prev = NULL;
		
		temp = *First;
		for(iCnt = 1; iCnt < (ipos -1); iCnt ++)
		{
			temp =temp->next;
		}
		newn->next = temp->next;
		temp->next->prev = newn;
		temp->next = newn;
		newn->prev = temp;
	}
}

void DeleteAtPos(PPNODE First, int ipos)
{
	int iNodeCnt = 0, iCnt = 0;
    PNODE temp = NULL;
	PNODE temp1 = NULL;
	iNodeCnt = Count(*First);
	if((ipos < 1) || (ipos >(iNodeCnt)))
	{
		printf("Invalid position\n");
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst(First);
	}
	else if(ipos == (iNodeCnt))
	{
		DeleteLast(First);
	}
	else
	{
		temp = *First;
		for(iCnt = 1; iCnt < (ipos -1); iCnt ++)
		{
			temp =temp->next;
		}
		temp1 = temp->next;
		temp->next->next->prev = temp;
		temp->next = temp->next->next;
		free(temp1);
	}
}



int main()
{
	PNODE Head = NULL;
	
	InsertFirst(&Head, 51);
	InsertFirst(&Head, 21);
	InsertFirst(&Head, 11);
	InsertLast(&Head, 101);
	InsertLast(&Head, 121);
	InsertLast(&Head, 151);
	
	Display(Head);
	
	InsertAtPos(&Head,222,4);
	Display(Head);
	
	
	DeleteAtPos(&Head, 4);
	Display(Head);
	
	DeleteFirst(&Head);
	Display(Head);
	
	DeleteLast(&Head);
	Display(Head);
	
	int iRet = Count(Head);
	printf("Number of element in linked list are : %d\n",iRet);
	
	
	return 0;
}