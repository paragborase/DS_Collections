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

class DoublyCLL
{
	public:
		PNODE First;
		PNODE Last;
		
		DoublyCLL();
		
		void InsertFirst(int no);
		void InsertLast(int no);
		void InsertAtPos(int ipos, int no);
		void DeleteAtPos(int ipos);
		void DeleteFirst(); 
		void DeleteLast();
		
		void Display();
		int Count();
};

DoublyCLL :: DoublyCLL()
{
	First = NULL;
	Last = NULL;
}

void DoublyCLL :: InsertFirst(int no)
{
	PNODE newn = new NODE;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	
	if((First == NULL) && (Last == NULL))
	{
		First = newn;
		Last = newn;	
	}
	else
	{
		newn->next = First;
		First->prev = newn;
		First = newn;
	}
	Last->next = First;
	First->prev = Last;
}

void DoublyCLL :: InsertLast(int no)
{
	PNODE newn = new NODE;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;

	if((First == NULL) && (Last == NULL))
	{
		First = newn;
		Last = newn;
	}
	else
	{
		Last->next = newn;
		newn->prev = Last;
		Last = newn;
	}
	Last->next = First;
	First->prev = Last;
}

void DoublyCLL :: InsertAtPos(int ipos, int no)
{
	int iNodeCnt = Count();
	
	if((ipos < 1)&&(ipos > (iNodeCnt+1)))
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
		PNODE temp = First;
		PNODE newn = new NODE;
		newn->data = no;
		newn->next = NULL;
		newn->prev = NULL;
		
		for(int iCnt = 1; iCnt <(ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		newn->next = temp->next;
		newn->prev = temp;
		temp->next->prev = newn;
		temp->next = newn;
	}
}

void DoublyCLL :: DeleteFirst()
{
	PNODE temp = First;
	if((First == NULL) && (Last == NULL))
	{
		return;
	}
	else if(First->next == NULL)
	{
		delete First;
		First = NULL;
		Last = NULL;
	}
	else
	{
		First = First->next;
		delete temp;
		First->prev = Last;
		Last->next = First;
	}
}

void DoublyCLL :: DeleteLast()
{
	PNODE temp = Last;
	if((First == NULL) && (Last == NULL))
	{
		return;
	}
	else if(First->next == NULL)
	{
		delete First;
		First = NULL;
		Last = NULL;
	}
	else
	{
		Last = Last->prev;
		delete First->prev;
		
		(First)->prev = Last;
        (Last)->next = First;
	}
}

void DoublyCLL :: DeleteAtPos(int ipos)
{
	int iNodeCnt = Count();
	
	if((ipos < 1)&&(ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst();
	}
	else if(ipos == iNodeCnt+1)
	{
		DeleteLast();
	}
	else
	{
		PNODE temp = First;

		for(int iCnt = 1; iCnt <(ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		temp->next = temp->next->next;
        delete temp->next->prev;
        temp->next->prev = temp;
	}
	
}

void DoublyCLL :: Display()
{
	PNODE temp = First;
	
	if(First == NULL && Last == NULL)
	{
		cout<<"Linked list is empty"<<"\n";
		return;
	}
	
	cout<<"Number of element in linked list are : "<<"\n";
	do
	{
		cout<<" | "<<temp->data<<" |->";
		temp = temp->next;
	}while(temp != Last->next);
	cout<<"\n";
}

int DoublyCLL :: Count()
{
	PNODE temp = First;
	int iCnt = 0;
	if(First == NULL && Last == NULL)
    {
        cout<<"Linked list is empty"<<"\n";
        return iCnt;
    }
	
	iCnt = 0;
	do
	{
		iCnt++;
		temp = temp->next;
	}while(temp != Last->next);
	return iCnt;
}


int main()
{
	int iRet;
	DoublyCLL iobj;
	
	iobj.InsertFirst(51);
	iobj.InsertFirst(21);
	iobj.InsertFirst(11);
	iobj.Display();
	iobj.InsertLast(101);
	iobj.InsertLast(111);
	iobj.InsertLast(121);
	iobj.Display();
	iobj.InsertAtPos(4,222);
	iobj.Display();
	iobj.DeleteAtPos(4);
	iobj.Display();
	iobj.DeleteFirst();
	iobj.DeleteLast();
	iobj.Display();
	
	iRet = iobj.Count();
	cout<<"Number of element in liked list are : "<<iRet<<"\n";
	
	return 0;
}
	