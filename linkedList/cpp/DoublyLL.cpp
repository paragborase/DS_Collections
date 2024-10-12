#include<iostream>
using namespace std;

struct node
{
	int data;
	struct node *next;
	struct node *prev;
};

typedef struct node NODE;
typedef struct node * PNODE;

class DoublyLL
{
	public:
		PNODE First;
		
		DoublyLL();
		
		void InsertFirst(int no);
		void InsertLast(int no);
		void InsertAtPos(int ipos, int no);
		void DeleteAtPos(int ipos);
		void DeleteFirst();
		void DeleteLast();
		void Display();
		int Count();
};

DoublyLL :: DoublyLL()
{
	First = NULL;
}

void DoublyLL :: InsertFirst(int no)
{
	PNODE newn = new NODE;
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
		First->prev = newn;
		First = newn;
	}
}

void DoublyLL :: InsertLast(int no)
{
	PNODE newn = new NODE;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	PNODE temp = First;
	
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
		temp->next = newn;
		newn->prev = temp;
	}
}

void DoublyLL :: InsertAtPos(int ipos, int no)
{
	int iNodeCnt = Count();
	
	if((ipos < 1) && (ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid Position\n";
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
		newn->prev = NULL;
		PNODE temp = First;
		PNODE temp1 = NULL;
		for(int iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		newn->prev = temp;
		newn->next = temp->next;
		temp->next = newn;
		temp->next->prev = newn;
	}	
}

void DoublyLL :: DeleteFirst()
{
	PNODE temp = First;
	if(First == NULL)
	{
		return;
	}
	else if(First->next == NULL)
	{
		delete First;
		First = NULL;
	}
	else
	{
		First->next->prev = NULL;
		First = First->next;
		delete temp;
	}
}

void DoublyLL :: DeleteLast()
{
	PNODE temp = First;
	if(First == NULL)
	{
		return;
	}
	else if(First->next == NULL)
	{
		delete First;
		First = NULL;
	}
	else
	{
		while(temp->next->next != NULL)
		{
			temp =temp->next;
		}
		delete temp->next;
		temp->next = NULL;
	}	
}

void DoublyLL :: DeleteAtPos(int ipos)
{
	int iNodeCnt = Count();
	
	if((ipos < 1) && (ipos > (iNodeCnt)))
	{
		cout<<"Invalid Position\n";
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
		PNODE temp = First;
		PNODE temp1 = NULL;
		for(int iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		temp1 = temp->next;
		temp->next->next->prev = temp;
		temp->next = temp->next->next;
		delete temp1;
	}	
}

void DoublyLL :: Display()
{
	PNODE temp = First;
	cout<<"Element in double linear linked list are : "<<"\n";
	while(temp != NULL)
	{
		cout<<" | "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"\n";
	
}

int DoublyLL :: Count()
{
	PNODE temp = First;
	int iCnt = 0;
	while(temp != NULL)
	{
		iCnt++;
		temp = temp->next;
	}
	return iCnt;
}
	
int main()
{
	int iRet;
	
	DoublyLL obj;
	
	obj.InsertFirst(51);
	obj.InsertFirst(21);
	obj.InsertFirst(11);
	obj.InsertLast(101);
	obj.InsertLast(121);
	obj.InsertLast(151);
	obj.Display();
	
	obj.InsertAtPos(4,222);
	obj.Display();
	
	obj.DeleteAtPos(4);
	obj.Display();
	
	obj.DeleteFirst();
	obj.Display();
	
	obj.DeleteLast();
	obj.Display();
	
	
	iRet = obj.Count();
	cout<<"Number of element in Doubly linked list are : "<<iRet<<"\n";
	
	return 0;
}
	
	