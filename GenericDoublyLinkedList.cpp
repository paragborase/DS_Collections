#include<iostream>
using namespace std;

template <class T>
struct node
{
	T data;
	struct node<T> *next;
	struct node<T> *prev;
};

template <class T>
class DoublyLL
{
	public:
		struct node<T> * First;
		
		DoublyLL();
		
		void InsertFirst(T no);
		void InsertLast(T no);
		void InsertAtPos(int ipos, T no);
		void DeleteAtPos(int ipos);
		void DeleteFirst();
		void DeleteLast();
		void Display();
		int Count();
};

template <class T>
DoublyLL <T>:: DoublyLL()
{
	First = NULL;
}

template <class T>
void DoublyLL <T>:: InsertFirst(T no)
{
	struct node<T> * newn = new struct node<T>;
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

template <class T>
void DoublyLL <T> :: InsertLast(T no)
{
	struct node<T> * newn = new struct node<T>;
	newn->data = no;
	newn->next = NULL;
	newn->prev = NULL;
	struct node<T> * temp = First;
	
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

template <class T>
void DoublyLL <T>:: InsertAtPos(int ipos, T no)
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
		struct node<T> * newn = new struct node<T>;
		newn->data = no;
		newn->next = NULL;
		newn->prev = NULL;
		struct node<T> * temp = First;
	
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

template <class T>
void DoublyLL <T>:: DeleteFirst()
{
	struct node<T> * temp = First;
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

template <class T>
void DoublyLL <T>:: DeleteLast()
{
	struct node<T> * temp = First;
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

template <class T>
void DoublyLL <T>:: DeleteAtPos(int ipos)
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
		struct node<T> * temp = First;
		struct node<T> * temp1 = NULL;
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

template <class T>
void DoublyLL <T>:: Display()
{
	struct node<T> * temp = First;
	cout<<"Element in double linear linked list are : "<<"\n";
	while(temp != NULL)
	{
		cout<<" | "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"\n";
	
}

template <class T>
int DoublyLL <T>:: Count()
{
	struct node<T> * temp = First;
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
	
	DoublyLL <int>iobj;
	
	iobj.InsertFirst(51);
	iobj.InsertFirst(21);
	iobj.InsertFirst(11);
	iobj.InsertLast(101);
	iobj.InsertLast(121);
	iobj.InsertLast(151);
	iobj.Display();
	
	iobj.InsertAtPos(4,222);
	iobj.Display();
	
	iobj.DeleteAtPos(4);
	iobj.Display();
	
	iobj.DeleteFirst();
	iobj.Display();
	
	iobj.DeleteLast();
	iobj.Display();
	
	
	iRet = iobj.Count();
	cout<<"Number of element in Doubly linked list are : "<<iRet<<"\n";
	
	
	DoublyLL <char>dobj;
	
	dobj.InsertFirst('a');
	dobj.InsertFirst('b');
	dobj.InsertFirst('c');
	dobj.InsertLast('d');
	dobj.InsertLast('e');
	dobj.InsertLast('f');
	dobj.Display();
	
	dobj.InsertAtPos(4,'g');
	dobj.Display();
	
	dobj.DeleteAtPos(4);
	dobj.Display();
	
	dobj.DeleteFirst();
	dobj.Display();
	
	dobj.DeleteLast();
	dobj.Display();
	
	
	iRet = dobj.Count();
	cout<<"Number of element in Doubly linked list are : "<<iRet<<"\n";
	
	return 0;
}
	
	