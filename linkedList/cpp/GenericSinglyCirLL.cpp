#include<iostream>
using namespace std;

template <class T>
struct node
{
	T data;
	struct node * next;
};


template <class T>
class SinglyCLLG
{
	public: 
		struct node<T> * First;
		struct node<T> * Last;
		
		SinglyCLLG();
		
		void InsertFirst(T no);
		void InsertLast(T no);
		void InsertAtPos(int ipos, T no);
		void DeleteFirst();
		void DeleteLast();
		void DeleteAtPos(int ipos);
		void Display();
		int Count();
};

template <class T>
SinglyCLLG <T>:: SinglyCLLG()
{
	First = NULL;
	Last = NULL;
}

template <class T>
void SinglyCLLG <T>:: InsertFirst(T no)
{
	struct node<T> * newn = new struct node<T>;
	newn->data = no;
	newn->next = NULL;
	
	if((First == NULL) && (Last == NULL))
	{
		First = newn;
		Last = newn;
		Last->next = First;
	}
	else
	{
		newn->next = First;
		First = newn;
		Last->next = First;
	}	
}

template <class T>
void SinglyCLLG<T> :: InsertLast(T no)
{
	struct node<T> * newn = new struct node<T>;
	newn->data = no;
	newn->next = NULL;
	
	if((First == NULL) && (Last == NULL))
	{
		First = newn;
		Last = newn;
		Last->next = First;
	}
	else
	{
		Last->next = newn;
		Last = newn;
		Last->next = First;
	}
}

template <class T>
void SinglyCLLG<T> :: InsertAtPos(int ipos, T no)
{
	int iNodeCnt = Count();
	
	if((ipos < 1) || (ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(ipos == 1)
	{
		InsertFirst(no);
	}
	else if(ipos == iNodeCnt+1 )
	{
		InsertLast(no);
	}
	else
	{
		struct node<T> * temp = First;
		struct node<T> * newn = new struct node<T>;
		newn->data = no;
		newn->next = NULL;
		
		for(int iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		newn->next = temp->next;
		temp->next = newn;
	}
}

template <class T>
void SinglyCLLG<T> :: DeleteFirst() 
{
	struct node<T> * temp = First;
	if((First == NULL) && (Last == NULL))
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
		First = First->next;
		delete temp;
		Last->next = First;
	}
}

template <class T>
void SinglyCLLG<T> :: DeleteLast()
{
	struct node<T> * temp = First;
	if((First == NULL) && (Last == NULL))
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
		while(temp->next != Last)
		{
			temp =temp->next;
		}
		delete Last;
		Last = temp;
		Last->next = First;
	}
}

template <class T>
void SinglyCLLG<T> :: DeleteAtPos(int ipos)
{
	int iNodeCnt = Count();
	
	if((ipos < 1) || (ipos > (iNodeCnt)))
	{
		cout<<"Invalid Position\n";
		return;
	}
	
	if(ipos == 1)
	{
		DeleteFirst();
	}
	else if(ipos == iNodeCnt )
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
		temp->next = temp->next->next;
		delete temp1;
	}
}

template <class T>
void SinglyCLLG<T> :: Display()
{
	struct node<T> * temp = First;
	cout<<"Element in circular linked list are : "<<"\n";
	do
	{
		cout<<" | "<<temp->data<<" |->";
		temp = temp->next;
	}while(temp != Last->next);
	cout<<"\n";
}

template <class T>
int SinglyCLLG<T> :: Count()
{
	struct node<T> * temp = First;
	int iCnt = 0;
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
	
	SinglyCLLG <int>iobj;
	
	iobj.InsertFirst(51);
	iobj.InsertFirst(21);
	iobj.InsertFirst(11);
	
	iobj.InsertLast(101);
	iobj.InsertLast(121);
	iobj.InsertLast(151);
	iobj.Display();
	
	iobj.InsertAtPos(4,222);
	iobj.DeleteAtPos(4);
	
	iobj.Display();
	
	iobj.DeleteFirst();
	iobj.DeleteLast();
	iobj.Display();
	iRet = iobj.Count();
	cout<<"Number of element in linked list are : "<<iRet<<"\n";
	
	SinglyCLLG <char>cobj;
	
	cobj.InsertFirst('c');
	cobj.InsertFirst('b');
	cobj.InsertFirst('a');
	
	cobj.InsertLast('d');
	cobj.InsertLast('e');
	cobj.InsertLast('f');
	cobj.Display();
	
	cobj.InsertAtPos(4,'g');
	cobj.DeleteAtPos(4);
	
	cobj.Display();
	
	cobj.DeleteFirst();
	cobj.DeleteLast();
	cobj.Display();
	iRet = cobj.Count();
	cout<<"Number of element in linked list are : "<<iRet<<"\n";
	return 0;
}