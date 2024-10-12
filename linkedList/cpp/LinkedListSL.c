#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node * next;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

void InsertFirst(PPNODE First, int no)
{
	PNODE newn =(PNODE)malloc(sizeof(NODE));	
	newn->data = no;
	newn->next = NULL;
	
	if(*First == NULL)
	{
		*First = newn;
	}
	else
	{
		newn->next = *First;
		*First = newn;
	}
}

void InsertLast(PPNODE First, int no)
{
	PNODE newn =(PNODE)malloc(sizeof(NODE));	
	newn->data = no;
	newn->next = NULL;
	PNODE temp = *First;
	
	if(*First == NULL)
	{
		*First = newn;
	}
	else
	{
		while(temp->next != NULL)
		{
			temp=temp->next;
		}
		temp->next = newn;
	}
}

void DeleteFirst(PPNODE First)
{
	PNODE temp = NULL;
	
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
		temp = (*First)->next;
		free(*First);
		*First = temp;
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
		while(temp->next->next != NULL)
		{
			temp = temp->next;
		}
		free(temp->next);
		temp -> next = NULL;		
	}
}

void Display(PNODE First)
{
	printf("Element in linked list are : \n");
	while(First != NULL)
	{
		printf("|%d|->",First->data);
		First = First -> next;
	}
	printf("NULL \n");
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

void InsertAtPos(PPNODE First, int no, int ipos)
{
	int iNodeCnt = Count(*First);
	int iCnt = 0;
	
	if((ipos < 1) || (ipos >  iNodeCnt+1))
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
		PNODE temp = *First;
		for(iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp ->next;
		}
		newn->next = temp->next;
		temp->next = newn;
	}
}

void DeleteAtPos(PPNODE First, int ipos)
{
	int iNodeCnt = Count(*First);
	int iCnt = 0;
	PNODE temp1 = NULL;
	if((ipos < 1) || (ipos >  iNodeCnt+1))
	{
		printf("Invalid position\n");
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst(First);
	}
	else if(ipos == (iNodeCnt+1))
	{
		DeleteLast(First);
	}
	else
	{
		PNODE temp = *First;
		for(iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp ->next;
		}
		temp1= temp->next->next;
		free(temp->next);
		temp->next = temp1;
	}
}

int main()
{
	PNODE Head = NULL;
	
	InsertFirst(&Head,51);
	InsertFirst(&Head,21);
	InsertFirst(&Head,11);
	
	InsertLast(&Head,101);
	InsertLast(&Head,121);
	InsertLast(&Head,151);
	Display(Head);
	
	InsertAtPos(&Head, 222, 4);
	Display(Head);
	
	DeleteAtPos(&Head, 4);
	Display(Head);
	
	DeleteFirst(&Head);
	Display(Head);
	
	DeleteLast(&Head);
	Display(Head);
	
	DeleteAtPos(&Head, 4);
	
	int iRet = Count(Head);
	printf("Number of element in linked list are : %d",iRet);
	
	return 0;
}