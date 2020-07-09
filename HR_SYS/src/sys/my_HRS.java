package sys;
import bean.Resume;
import java.util.Scanner;

/*��һ�汾��*/
public class my_HRS {
    private int MAXSIZE=100;
    //�������ʼ��
    private Resume[] resumeList=new Resume[MAXSIZE];
    //��������
    private int resumeCount=0;
    //��ȡ��׼������
    private Scanner input=new Scanner(System.in);



    my_HRS(){

        while(true)
        {

            System.out.println("-----��ӭ����xxx��������ϵͳ-----");
            System.out.println("ѧ����Ϣ¼���밴----1");
            System.out.println("ѧ����Ϣɾ���밴----2");
            System.out.println("ѧ����Ϣ�޸��밴----3");
            System.out.println("ѧ����Ϣ��ѯ�밴----4");
            System.out.println("�˳��밴--------5");


            int choice=input.nextInt();

            if(choice==1)
            {
                addResume();
            }
            else if(choice==2)
            {
                deleteResume();
            }
            else if(choice==3)
            {
                updateResume();
            }
            else if(choice==4)
            {
                searchResume();
            }
            else if(choice==5)
            {
                break;
            }else {
                System.out.println("�����������������");
            }
        }
        //�ر�������
        input.close();
        System.out.println("���Ѿ��˳�xxx��������ϵͳ");
    }

    //¼��ѧ��������Ϣ
    void addResume()
    {
        System.out.println("��ӭ�����������ϵͳ��¼�����");
        //�жϼ�������ϵͳ�Ƿ����
        if(resumeCount<MAXSIZE)
        {
            Scanner input=new Scanner(System.in);
            System.out.println("������������Ҫ¼��ѧ����Ϣ�����������֤�š���ҵԺУ");
            String Name=input.nextLine();
            String Id=input.nextLine();
            String School=input.nextLine();



            Resume resume=new Resume(Name,Id,School);
            resumeList[resumeCount]=resume;
            resumeCount++;
            System.out.println("���Ѿ��ɹ�¼��ѧ����Ϣ");
            showResume();
        }
        else{
            System.out.println("��������ϵͳ�������޷����ͼ��");
        }
    }

    //ɾ��ͼ��ѧ������
    void deleteResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ɾ��ѧ����Ϣ����");
        System.out.println("��������Ҫɾ����ѧ�����֤��");

        String studentId=input.nextLine();
        if(resumeCount!=0)
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getId().equals(studentId))
                {
                    for(int j=i;j<resumeCount-1;j++)
                    {
                        resumeList[j]=resumeList[j+1];
                    }
                    System.out.println("���Ѿ��ɹ�ɾ����ѧ����Ϣ");
                    resumeCount--;
                    break;
                }
                else if(i==resumeCount-1) {
                    System.out.println("û���ҵ���ѧ����Ϣ�����ʵ��ɾ��");
                }
            }
            showResume();
        }
        else{
            System.out.println("��������ϵͳΪ�գ�û���ҵ���ѧ����Ϣ");
        }
    }

    //�޸�ѧ����Ϣ
    void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ѧ����Ϣ�޸Ľ���");
        System.out.println("��������Ҫ�޸�ѧ�������֤��");
        String studentId=input.nextLine();
        if(resumeCount!=0)
        {
            for(int i=0;i<resumeCount;i++)
            {
                if(resumeList[i].getId().equals(studentId))
                {
                    System.out.println("�����������ѧ���޸ĺ��ѧ�����������֤�š���ҵԺУ����������״̬����ʾ״̬��");
                    System.out.println(
                            "���м��������У�"+
                            " 0�������� " +
                            " 1������ͨ�� " +
                            " 2������ͨ�� " +
                            " 3�����ͨ�� " +
                            " 4������ͨ�� " +
                            " 5����ǩԼ " +
                            " 6������ְ");
                    System.out.println(
                            "��ʾ״̬�У�"+
                            "0 :��չʾ " +
                            "1 :չʾ");
                    String newname=input.nextLine();
                    String newid=input.nextLine();
                    String newschool=input.nextLine();
                    int newprocess=input.nextInt();
                    int newdeleteStatus=input.nextInt();
                    resumeList[i].setName(newname);
                    resumeList[i].setId(newid);
                    resumeList[i].setSchool(newschool);
                    resumeList[i].setProcess(newprocess);
                    resumeList[i].setDeleteStatus(newdeleteStatus);
                    System.out.println("���Ѿ��޸ĳɹ�");
                    showResume();
                }
                else if(i==resumeCount-1||resumeCount==0) {
                    System.out.println("û�в��ҵ���ѧ���ļ�����Ϣ");
                }
            }
        }
        else{
            System.out.println("ϵͳΪ�գ�û�в��ҵ���ѧ���ļ�����Ϣ");
        }

    }

    //��ѯͼ��
    void searchResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ѧ����Ϣ��ѯ����");
        System.out.println("��������Ҫ��ѯ��ѧ�����֤��");
        String studentId=input.nextLine();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList[i].getId().equals(studentId))
            {
                System.out.println("ѧ������:"+resumeList[i].getName()+" "+
                        "���֤��"+":"+resumeList[i].getId()+" "
                        +"��ҵԺУ"+":"+resumeList[i].getSchool()+" "
                        +"��������:"+resumeList[i].getProcess()+" "
                        +"������ʾ״̬:"+resumeList[i].getDeleteStatus());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("û�в��ҵ���ѧ��������������");
            }
            else{
                System.out.println("ϵͳΪ�գ�û�в��ҵ���ѧ���ļ�����Ϣ");
            }
        }
    }

    //ͼ�����
    void showResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("�Ƿ���Ҫ��ӡ����ѧ����Ϣ����������Y�����ô�ӡ����������");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("����������ϵͳ����"+resumeCount+"��ѧ��������Ϣ");
            for(int i=0;i<resumeCount;i++) {
                System.out.println("ѧ������:"+resumeList[i].getName()+" "+
                        "���֤��"+":"+resumeList[i].getId()+" "
                        +"��ҵԺУ"+":"+resumeList[i].getSchool()+" "
                        +"��������:"+resumeList[i].getProcess()+" "
                        +"������ʾ״̬:"+resumeList[i].getDeleteStatus());
            }
        }
    }

    public static void main(String[] args)
    {
        new my_HRS();
    }
}

