#include<iostream>
using namespace std;

template <class T>
struct node
{
	T data;
	struct node * next;
	struct node * prev;
};

template <class T>
class DoublyCLLG
{
	public:
		struct node<T> * First;
		struct node<T> * Last;
		
		DoublyCLLG();
		
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
DoublyCLLG <T> :: DoublyCLLG()
{
	First = NULL;
	Last = NULL;
}

template <class T>
void DoublyCLLG<T> :: InsertFirst(T no)
{
	struct node<T> * newn = new struct node<T>;
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

template <class T>
void DoublyCLLG <T>:: InsertLast(T no)
{
	struct node<T> * newn = new struct node<T>;
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

template <class T>
void DoublyCLLG<T> :: InsertAtPos(int ipos, T no)
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
		struct node<T> * temp = First;
		struct node<T> * newn = new struct node<T>;
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

template <class T>
void DoublyCLLG <T>:: DeleteFirst()
{
	struct node<T> * temp = First;
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

template <class T>
void DoublyCLLG <T>:: DeleteLast()
{
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

template <class T>
void DoublyCLLG <T>:: DeleteAtPos(int ipos)
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
		struct node<T> * temp = First;

		for(int iCnt = 1; iCnt <(ipos-1); iCnt++)
		{
			temp = temp->next;
		}
		temp->next = temp->next->next;
        delete temp->next->prev;
        temp->next->prev = temp;
	}
	
}

template <class T>
void DoublyCLLG <T>:: Display()
{
	struct node<T> * temp = First;
	
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

template <class T>
int DoublyCLLG <T>:: Count()
{
	struct node<T> * temp = First;
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
	DoublyCLLG <int>iobj;
	
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
	
	DoublyCLLG <double>dobj;
	
	dobj.InsertFirst(51.12);
	dobj.InsertFirst(21.32);
	dobj.InsertFirst(11.22);
	dobj.Display();
	dobj.InsertLast(101.223);
	dobj.InsertLast(111.11);
	dobj.InsertLast(121.67);
	dobj.Display();
	dobj.InsertAtPos(4,222.43);
	dobj.Display();
	dobj.DeleteAtPos(4);
	dobj.Display();
	dobj.DeleteFirst();
	dobj.DeleteLast();
	dobj.Display();
	
	iRet = dobj.Count();
	cout<<"Number of element in liked list are : "<<iRet<<"\n";
	
	return 0;
}
	