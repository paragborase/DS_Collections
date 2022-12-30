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

void InsertFirst(PPNODE First, PPNODE Last, int no)
{
	PNODE newn = (PNODE)malloc(sizeof(NODE));
	newn->data = no;
	newn->next = NULL;
	
	if((*First == NULL) && (*Last == NULL))  //empty LL
	{
		*First = *Last =  newn;
		(*Last)->next = (*First);
	}
	else   //contain at least one node
	{
		newn->next = *First;
		(*First) = newn;
		(*Last)->next = (*First);
	}
}

void InsertLast(PPNODE First, PPNODE Last, int no)
{
	PNODE newn = (PNODE)malloc(sizeof(NODE));
	newn->data = no;
	newn->next = NULL;
	
	if((*First == NULL) && (*Last == NULL))  //empty LL
	{
		*First = *Last =  newn;
		(*Last)->next = (*First);
	}
	else   //contain at least one node
	{
		(*Last)->next = newn;
		(*Last) = newn;
		(*Last)->next = (*First);
	}
}

void DeleteFirst(PPNODE First, PPNODE Last)
{
	PNODE temp = *First;
	
	if((*First == NULL) && (*Last) == NULL)
	{
		return;
	}
	else if(*First == *Last)
	{
		free(*First);
		*First = NULL;
		*Last = NULL;
	}
	else
	{
		(*First) = (*First)->next;
		free(temp);
		(*Last)->next= (*First);
	}
}

void DeleteLast(PPNODE First, PPNODE Last)
{
	PNODE temp = *First;
	
	if((*First == NULL) && (*Last) == NULL)
	{
		return;
	}
	else if(*First == *Last)
	{
		free(*First);
		*First = NULL;
		*Last = NULL;
	}
	else
	{
		while(temp->next != (*Last))
		{
			temp = temp ->next;
		}
		free(temp->next);
		(*Last) = temp;
		(*Last)->next = (*First);
	}
}

void Display(PNODE First, PNODE Last)
{
	printf("Number of element in linked list are : \n");
	
	do
	{
		printf("|%d|->",First->data);
		First = First -> next;
	}while(First != Last->next);
	printf("\n");
}

int iCount(PNODE First, PNODE Last)
{
	int iCnt = 0;
	
	do
	{
		iCnt++;
		First = First -> next;
	}while(First != Last->next);
	
	return iCnt;
}

void InsertAtPos(PPNODE First, PPNODE Last,int no, int ipos)
{
	
	PNODE temp = *First;
	int iNodeCnt = iCount(*First, *Last);
	
	if((ipos < 1) || (ipos > (iNodeCnt+1)))
	{
		printf("Invalid position \n");
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst(First, Last, no);
	}
	else if(ipos == iNodeCnt+1)
	{
		InsertLast(First, Last, no);
	}
	else
	{
		PNODE newn = (PNODE)malloc(sizeof(NODE));
		newn->data = no;
		newn->next = NULL;
		for(int iCnt = 1; iCnt <(ipos -1);  iCnt++)
		{
			temp = temp -> next;
		}
		newn->next = temp->next;
		temp->next = newn;
	}	
}

void DeleteAtPos(PPNODE First, PPNODE Last, int ipos)
{
	PNODE temp = *First;
	PNODE temp1 = NULL;
	int iNodeCnt = iCount(*First, *Last);
	
	if((ipos < 1) || (ipos > (iNodeCnt+1)))
	{
		printf("Invalid position \n");
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst(First, Last);
	}
	else if(ipos == iNodeCnt)
	{
		DeleteLast(First, Last);
	}
	else
	{
		for(int iCnt = 1; iCnt <(ipos -1);  iCnt++)
		{
			temp = temp -> next;
		}
		temp1 = temp->next;
		temp->next = temp1->next;
		free(temp1);
	}	
}
		
int main()
{
	PNODE Head = NULL;
	PNODE Tail = NULL;
	
	InsertFirst(&Head, &Tail, 11);
	InsertFirst(&Head, &Tail, 21);
	InsertFirst(&Head, &Tail, 51);
	InsertLast(&Head, &Tail, 101);
	InsertLast(&Head, &Tail, 121);
	InsertLast(&Head, &Tail, 151);
	
	Display(Head, Tail);
	
	InsertAtPos(&Head, &Tail, 222, 4);
	Display(Head, Tail);
	DeleteAtPos(&Head, &Tail,4);
	Display(Head, Tail);
	
	DeleteFirst(&Head, &Tail);
	DeleteLast(&Head, &Tail);
	Display(Head, Tail);
	
	int iRet = iCount(Head, Tail);
	printf("Number of element in linked list are :  %d\n",iRet);
	
	return 0;
}