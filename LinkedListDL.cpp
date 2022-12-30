#include<iostream>
using namespace std;
 
struct node
{
	int data;
	struct node * next;
	struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

class LinkedListDL
{
	public:
		PNODE First;
		
		LinkedListDL();
		
		void InsertFirst(int no);
		void InsertLast(int no);
		void InsertAtPos(int no, int ipos);
		
		void DeleteFirst();
		void DeleteLast();
		void DeleteAtPos(int ipos);
		
		void Display();
		int Count();
};

LinkedListDL :: LinkedListDL()
{
	First = NULL;
}

void LinkedListDL :: InsertFirst(int no)
{
	PNODE newn =new NODE;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if(First == NULL)
	{
		First = newn;
	}
	else
	{
		newn->next = First;
		(First)->prev = newn;
		First = newn;
	}
}

void LinkedListDL ::InsertLast(int no)
{
	PNODE newn =new NODE;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	PNODE temp = First;
	int iCnt = 0;
	if(First == NULL)
	{
		First = newn;
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

void LinkedListDL :: DeleteFirst()
{
	PNODE temp = First;
	if(First == NULL)
	{
		return;
	}
	else if((First)->next == NULL)
	{
		free(First);
		First = NULL;
	}
	else
	{
		First = (First)->next;
		free(temp);
		(First)->prev = NULL;
	}	
}

void LinkedListDL :: DeleteLast()
{
	PNODE temp = First;
	if(First == NULL)
	{
		return;
	}
	else if((First)->next == NULL)
	{
		free(First);
		First = NULL;
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

int LinkedListDL :: Count()
{
	PNODE temp = First;
	int iCnt = 0;
	while(temp != NULL)
	{
		iCnt++;
		temp = temp -> next;
	}
	return iCnt;
}

void LinkedListDL :: Display()
{
	PNODE temp = First;
	printf("Element in linked list are : \n");
	printf("NULL<=>");
	while(temp != NULL)
	{
		printf("|%d|<=>",temp->data);
		temp = temp -> next;
	}
	printf("NULL\n");
}


void LinkedListDL :: InsertAtPos(int no, int ipos)
{
	int iNodeCnt = 0, iCnt = 0;
    PNODE newn = NULL;
    PNODE temp = NULL;
	
	iNodeCnt = Count();
	if((ipos < 1) || (ipos >(iNodeCnt+1)))
	{
		printf("Invalid position\n");
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst(no);
	}
	else if(ipos == (iNodeCnt+1))
	{
		InsertLast(no);
	}
	else
	{
		PNODE newn =new NODE;
		newn->data = no;
		newn->next = NULL;
		newn->prev = NULL;
		
		temp = First;
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

void LinkedListDL :: DeleteAtPos(int ipos)
{
	int iNodeCnt = 0, iCnt = 0;
    PNODE temp = NULL;
	PNODE temp1 = NULL;
	iNodeCnt = Count();
	if((ipos < 1) || (ipos >(iNodeCnt)))
	{
		printf("Invalid position\n");
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst();
	}
	else if(ipos == (iNodeCnt))
	{
		DeleteLast();
	}
	else
	{
		temp = First;
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
	LinkedListDL obj1;
	
	obj1.InsertFirst(51);
	obj1.InsertFirst(21);
	obj1.InsertFirst(11);
	obj1.InsertLast(101);
	obj1.InsertLast(121);
	obj1.InsertLast(151);
	
	obj1.Display();
	
	obj1.InsertAtPos(222,4);
	obj1.Display();
	
	
	obj1.DeleteAtPos(4);
	obj1.Display();
	
	obj1.DeleteFirst();
	obj1.Display();
	
	obj1.DeleteLast();
	obj1.Display();
	
	int iRet = obj1.Count();
	printf("Number of element in linked list are : %d\n",iRet);
	
	
	return 0;
}