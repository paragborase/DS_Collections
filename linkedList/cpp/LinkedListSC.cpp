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

class LinkedListSC
{
	public: 
		PNODE First;
		PNODE Last;
		
		LinkedListSC();
		
		void InsertFirst(int no);
		void InsertLast(int no);
		void InsertAtPos(int no, int ipos);
		
		void DeleteFirst();
		void DeleteLast();
		void DeleteAtPos(int ipos);
		
		void Display();
		int iCount();
};

LinkedListSC :: LinkedListSC()
{
	First = NULL;
	Last = NULL;
}

void LinkedListSC :: InsertFirst(int no)
{
	PNODE newn = new NODE;
	newn->data = no;
	newn->next = NULL;
	
	if((First == NULL) && (Last == NULL))  //empty LL
	{
		First = Last =  newn;
		(Last)->next = (First);
	}
	else   //contain at least one node
	{
		newn->next = First;
		(First) = newn;
		(Last)->next = (First);
	}
}

void LinkedListSC :: InsertLast(int no)
{
	PNODE newn = new NODE;
	newn->data = no;
	newn->next = NULL;
	
	if((First == NULL) && (Last == NULL))  //empty LL
	{
		First = Last =  newn;
		(Last)->next = (First);
	}
	else   //contain at least one node
	{
		(Last)->next = newn;
		(Last) = newn;
		(Last)->next = (First);
	}
}

void LinkedListSC :: DeleteFirst()
{
	PNODE temp = First;
	
	if((First == NULL) && (Last) == NULL)
	{
		return;
	}
	else if(First == Last)
	{
		delete First;
		First = NULL;
		Last = NULL;
	}
	else
	{
		(First) = (First)->next;
		delete temp;
		(Last)->next= (First);
	}
}

void LinkedListSC ::DeleteLast()
{
	PNODE temp = First;
	
	if((First == NULL) && (Last) == NULL)
	{
		return;
	}
	else if(First == Last)
	{
		delete First;
		First = NULL;
		Last = NULL;
	}
	else
	{
		while(temp->next != (Last))
		{
			temp = temp ->next;
		}
		delete (temp->next);
		(Last) = temp;
		(Last)->next = (First);
	}
}

void LinkedListSC ::Display()
{
	cout<<"Number of element in linked list are : "<<"\n";
	PNODE temp = First;
	do
	{
		cout<<"| "<<temp->data<<"|->";
		temp = temp -> next;
	}while(temp != Last->next);
	cout<<"\n";
}

int LinkedListSC ::iCount()
{
	int iCnt = 0;
	PNODE temp = First;
	do
	{
		iCnt++;
		temp = temp -> next;
	}while(temp != Last->next);
	
	return iCnt;
}

void LinkedListSC ::InsertAtPos(int no, int ipos)
{
	
	PNODE temp = First;
	int iNodeCnt = iCount();
	
	if((ipos < 1) || (ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid position "<<"\n";
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst(no);
	}
	else if(ipos == iNodeCnt+1)
	{
		InsertLast(no);
	}
	else
	{
		PNODE newn = new NODE;
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

void LinkedListSC :: DeleteAtPos( int ipos)
{
	PNODE temp = First;
	PNODE temp1 = NULL;
	int iNodeCnt = iCount();
	
	if((ipos < 1) || (ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid position "<<"\n";
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst();
	}
	else if(ipos == iNodeCnt)
	{
		DeleteLast();
	}
	else
	{
		for(int iCnt = 1; iCnt <(ipos -1);  iCnt++)
		{
			temp = temp -> next;
		}
		temp1 = temp->next;
		temp->next = temp1->next;
		delete temp1;
	}	
}
		
int main()
{
	PNODE Head = NULL;
	PNODE Tail = NULL;
	
	LinkedListSC obj;
	
	obj.InsertFirst(11);
	obj.InsertFirst(21);
	obj.InsertFirst(51);
	obj.InsertLast(101);
	obj.InsertLast(121);
	obj.InsertLast(151);
	
	obj.Display();
	
	obj.InsertAtPos(222, 4);
	obj.Display();
	obj.DeleteAtPos(4);
	obj.Display();
	
	obj.DeleteFirst();
	obj.DeleteLast();
	obj.Display();
	
	int iRet = obj.iCount();
	cout<<"Number of element in linked list are :  "<<iRet<<"\n";
	
	return 0;
}