#include<iostream>
using namespace std;

template <class T>
struct node
{
	T data;
	struct node *next;
};


template <class T>
class SinglyLLG
{
	public:
		struct node<T> * First;
		
		SinglyLLG();
		
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
SinglyLLG <T>:: SinglyLLG()
{
	First = NULL;
}

template <class T>
void SinglyLLG <T>:: InsertFirst(T no)
{
	struct node<T> * newn = new struct node<T>;
	newn->data = no;
	newn->next = NULL;
	
	if(First == NULL)
	{
		First = newn;
	}
	else
	{
		newn->next = First;
		First = newn;
	}
}

template <class T>
void SinglyLLG <T>:: InsertLast(T no)
{
	struct node<T> * newn = new struct node<T>;
	newn->data = no;
	newn->next = NULL;
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
	}
}

template <class T>
void SinglyLLG <T>:: InsertAtPos(int ipos, T no)
{
	struct node<T> * temp = First;
	
	int iNodeCnt = Count();
	
	if((ipos < 1) && (ipos > (iNodeCnt+1)))
	{
		cout<<"Invalid Input"<<"\n";
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
		
		for(int iCnt = 1; iCnt < (ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		newn->next = temp->next;
		temp->next = newn;
	}		
}

template <class T>
void SinglyLLG <T>:: DeleteFirst()
{
	struct node<T> * temp = First;
	struct node<T> * temp1 = NULL;
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
		First = First->next;
		delete temp1;
	}
}

template <class T>
void SinglyLLG <T>:: DeleteLast()
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
			temp = temp->next;
		}
		delete temp->next;
		temp->next = NULL;
	}
}

template <class T>
void SinglyLLG <T>:: DeleteAtPos(int ipos)
{
	struct node<T> * temp = First;
	struct node<T> * temp1 = First;
	
	int iNodeCnt = Count();
	
	if((ipos < 1) && (ipos > (iNodeCnt)))
	{
		cout<<"Invalid Input"<<"\n";
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
		for(int iCnt = 0; iCnt <(ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		temp1 = temp->next;
		temp->next = temp->next->next;
		delete temp1;
	}
}
	
template <class T>
void SinglyLLG <T>:: Display()
{
	struct node<T> * temp = First;
	cout<<"Number of element in linked list are : \n";
	while(temp != NULL)
	{
		cout<<" | "<<temp->data<<" |->";
		temp = temp->next;
	}
	cout<<"NULL\n";
}

template <class T>
int SinglyLLG <T>:: Count()
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
	
	SinglyLLG <int> iobj;
	
	iobj.InsertFirst(101);
	iobj.InsertFirst(51);
	iobj.InsertFirst(21);
	iobj.InsertFirst(11);
	iobj.InsertLast(121);
	iobj.InsertLast(151);
	iobj.InsertLast(201);
	iobj.Display();
	iobj.InsertAtPos(4,222);
	iobj.DeleteAtPos(4);
	iobj.Display();
	iobj.DeleteLast();
	iobj.DeleteFirst();
	iobj.Display();
	 
	
	iRet = iobj.Count();
	cout<<"Number of element in linked list are : "<<iRet<<"\n";
	
	SinglyLLG <char> cobj;
	
	cobj.InsertFirst('p');
	cobj.InsertFirst('a');
	cobj.InsertFirst('r');
	cobj.InsertFirst('a');
	cobj.InsertLast('g');
	cobj.InsertLast('B');
	cobj.InsertLast('O');
	cobj.Display();
	cobj.InsertAtPos(4,'R');
	cobj.DeleteAtPos(4);
	cobj.Display();
	cobj.DeleteLast();
	cobj.DeleteFirst();
	cobj.Display();
	 
	
	iRet = cobj.Count();
	cout<<"Number of element in linked list are : "<<iRet<<"\n";
	
	
	return 0;
}
		