package sys;

import java.util.ArrayList;
import java.util.Scanner;
import bean.Book;
import bean.BookList;

public class HRS {

	private int MAXSIZE=100;
	//�������ʼ����ʱ������������Ĵ�С����û�б�ķ�ʽ�����أ�
	private Book[] bookList=new Book[MAXSIZE];

	ArrayList<Book> bookArrayList=new ArrayList<>();
	BookList books=new BookList();

//	int[]  shuzu=new int[1];
//	int[] shuzu1={1,2,3};
//	int[] shuzu3=new  int[]{1,2,3};

	private int bookCount=0;//������������ķ��գ����÷�ֹԽ�磻
	//��ȡ��׼������
	private Scanner input=new Scanner(System.in);



	HRS(){

		while(true)
		{

			System.out.println("-----��ӭ���������ͼ�����ϵͳ-----");
			System.out.println("���ͼ���밴----1");
			System.out.println("ɾ��ͼ���밴----2");
			System.out.println("�޸�ͼ���밴----3");
			System.out.println("��ѯͼ���밴----4");
			System.out.println("�˳��밴--------5");


			int choice=input.nextInt();
			//������if ������ʲô��ʽ����ʵ���߼��жϣ�
			if(choice==1)
			{
				addBook();
			}
			else if(choice==2)
			{
				deleteBook();
			}
			else if(choice==3)
			{
				updateBook();
			}
			else if(choice==4)
			{
				searchBook();
			}
			else if(choice==5)
			{
				break;
			}else {
				System.out.println("�����������������");
			}
		}
		input.close();//���� ���Ӱ� ��Щ���� ����ǵùأ�Ҫô�ǵû�����ôʲô�ط�����Ҫ���ģ�ʲô�ط��ǹصģ���
		System.out.println("���Ѿ��˳�ͼ�����ϵͳ");
	}

	//���ͼ��
	void addBook()
	{
		System.out.println("��ӭ�������ͼ�����");
		if(bookCount<MAXSIZE)//�ж�ͼ�����ϵͳ�Ƿ�δ��
		{
			Scanner input=new Scanner(System.in);
			System.out.println("������������Ҫ��ӵ�ͼ���������ߣ��۸�");
			String bookName=input.nextLine();
			String bookAuthor=input.nextLine();
			float bookPrice=input.nextFloat();

			//get/SET
			Book book=new Book(bookName,bookAuthor,bookPrice);

			//������ʱ���Ѿ���79�����ˣ���ô��79�����λ���Ǽ�
			bookList[bookCount]=book;
			bookCount++;
			System.out.println("���Ѿ��ɹ����ͼ��");
			showBook();
		}
		else{
			System.out.println("ͼ�����ϵͳ�������޷����ͼ��");
		}
	}

	//ɾ��ͼ��
	void deleteBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ����ɾ��ͼ�����");
		System.out.println("��������Ҫɾ����ͼ����");

		String bookName=input.nextLine();
		if(bookCount!=0)//ͼ�����ϵͳ��Ϊ��
		{
			for(int i=0;i<bookCount;i++)
			{
				if(bookList[i].bookName.equals(bookName))
				{
					for(int j=i;j<bookCount-1;j++)
					{
						bookList[j]=bookList[j+1];
					}
					System.out.println("���Ѿ��ɹ�ɾ��ͼ��");
					bookCount--;
					break;
				}
				else if(i==bookCount-1) {
					System.out.println("û���ҵ����鼮");
				}
			}
			showBook();
		}
		else{
			System.out.println("ͼ��ϵͳΪ�գ�û���ҵ����鼮");
		}
//		input.close();
	}

	//�޸�ͼ��
	void updateBook()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ�����޸�ͼ�����");
		System.out.println("��������Ҫ�޸ĵ�ͼ����");
		String bookName=input.nextLine();
		if(bookCount!=0)//ͼ�����ϵͳ��Ϊ��
		{
			for(int i=0;i<bookCount;i++)
			{
				if(bookList[i].bookName.equals(bookName))
				{
					System.out.println("�����������µ����������ߣ��۸�");
					String newbookName=input.nextLine();
					String newbookAuthor=input.nextLine();
					float newbookPrice=input.nextFloat();
					Book book=new Book(newbookName,newbookAuthor,newbookPrice);
					bookList[i]=book;
					System.out.println("���Ѿ��޸ĳɹ�");
					showBook();
				}
				else if(i==bookCount-1||bookCount==0) {
					System.out.println("û�в��ҵ����鼮");
				}
			}
		}
		else{
			System.out.println("ϵͳΪ�գ�û�в��ҵ����鼮");
		}
//		input.close();
	}

	//��ѯͼ��
	void searchBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ�����ѯͼ�����");
		System.out.println("��������Ҫ��ѯ��ͼ����");
		String bookName=input.nextLine();
		for(int i=0;i<bookCount;i++)
		{
			if(bookList[i].bookName.equals(bookName))
			{
				System.out.println("<<"+bookList[i].bookName+">>"+"\n"+
									"����"+":"+bookList[i].bookAuthor+"\n"
									+"�۸�"+":"+bookList[i].bookPrice+"\n"
									+"λ�ڵ�"+(i+1)+"λ��");
				break;
			}
			else if(i==bookCount-1) {
				System.out.println("û�в��ҵ����鼮������������");
			}
		}
//		input.close();
	}

	//ͼ�����
	void showBook()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("�Ƿ���Ҫ��ӡ����ͼ�飬��������Y�����ô�ӡ����������");
		String XUANZE=input.nextLine();
		String Y="Y";
		if(XUANZE.equals(Y))
		{
			System.out.println("��ͼ�����ϵͳ����"+bookCount+"����");
			for(int i=0;i<bookCount;i++) {
				System.out.println("��"+(i+1)+"��"+"----"+"<<"+bookList[i].bookName+">>");
			}
		}
//		input.close();
	}
	
	public static void main(String[] args)
	{
		new HRS();
	}
}