#include<iostream>
using namespace std;

struct node
{
	int data;
	struct node * next;
};

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

class LinkedListSL
{
	public:
		PNODE First;
		int iCount;
		
		LinkedListSL();
		
		void InsertFirst(int no);
		void InsertLast(int no);
		void InsertAtPos(int no, int ipos);
		
		void DeleteFirst();
		void DeleteLast();
		void DeleteAtPos(int ipos);
		
		void Display();
};

LinkedListSL :: LinkedListSL()
{
	First = NULL;
	iCount = 0;
}

void LinkedListSL:: InsertFirst(int no)
{
	PNODE newn = new NODE;	
	newn->data = no;
	newn->next = NULL;
	
	if(First == NULL)
	{
		First = newn;
		iCount++;
	}
	else
	{
		newn->next = First;
		First = newn;
		iCount++;
	}
}

void LinkedListSL :: InsertLast(int no)
{
	PNODE newn =new NODE;	
	newn->data = no;
	newn->next = NULL;
	PNODE temp = First;
	
	if(First == NULL)
	{
		First = newn;
		iCount++;
	}
	else
	{
		while(temp->next != NULL)
		{
			temp=temp->next;
		}
		temp->next = newn;
		iCount++;
	}
}

void LinkedListSL:: DeleteFirst()
{
	PNODE temp = NULL;
	
	if(First == NULL)
	{
		return;
	}
	else if((First)->next == NULL)
	{
		free(First);
		First = NULL;
		iCount--;
	}
	else
	{
		temp = (First)->next;
		free(First);
		First = temp;
		iCount--;
	}
}

void LinkedListSL:: DeleteLast()
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
		iCount--;
	}
	else
	{
		while(temp->next->next != NULL)
		{
			temp = temp->next;
		}
		free(temp->next);
		temp -> next = NULL;	
		
		iCount--;
	}
}

void LinkedListSL:: Display()
{
	PNODE temp = First;
	cout<<"Element in linked list are : "<<"\n";
	while(temp != NULL)
	{
		cout<<"| "<<temp->data<<"|->";
		temp = temp -> next;
	}
	cout<<"NULL "<<"\n";
}

void LinkedListSL:: InsertAtPos(int no, int ipos)
{
	int iCnt = 0;
	
	if((ipos < 1) || (ipos >  iCount+1))
	{
		cout<<"Invalid position\n";
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst( no);
	}
	else if(ipos == (iCount+1))
	{
		InsertLast( no);
	}
	else
	{
		PNODE newn =new NODE;	
		newn->data = no;
		newn->next = NULL;
		PNODE temp = First;
		for(iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp ->next;
		}
		newn->next = temp->next;
		temp->next = newn;
		iCount++;
	}
}

void LinkedListSL:: DeleteAtPos(int ipos)
{
	
	int iCnt = 0;
	PNODE temp1 = NULL;
	if((ipos < 1) || (ipos >  iCount+1))
	{
		cout<<"Invalid position\n";
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst();
	}
	else if(ipos == (iCount+1))
	{
		DeleteLast();
	}
	else
	{
		PNODE temp = First;
		for(iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp ->next;
		}
		temp1= temp->next->next;
		free(temp->next);
		temp->next = temp1;
		iCount--;
	}
}

int main()
{
	LinkedListSL obj1;
	
	obj1.InsertFirst(51);
	obj1.InsertFirst(21);
	obj1.InsertFirst(11);
	
	obj1.InsertLast(101);
	obj1.InsertLast(121);
	obj1.InsertLast(151);
	obj1.Display();
	
	obj1.InsertAtPos(222, 4);
	obj1.Display();
	
	obj1.DeleteAtPos( 4);
	obj1.Display();
	
	obj1.DeleteFirst();
	obj1.Display();
	
	obj1.DeleteLast();
	obj1.Display();
	
	obj1.DeleteAtPos(4);
	
	cout<<"Number of element in linked list are : "<<obj1.iCount<<"\n";
	
	return 0;
}