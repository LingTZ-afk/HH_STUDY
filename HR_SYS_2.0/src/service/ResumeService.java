package service;

import java.util.LinkedList;
import java.util.Scanner;
import model.Resume;
//���������ࣺ��Ҫ��������ĸ��ֲ�����ɾ�����޸ġ����ҡ���ӡ���ʾ��
public class ResumeService {

    public static void addResume(LinkedList<Resume> resumeList)
    {
        System.out.println("��ӭ�����������ϵͳ��¼�����");
        Scanner input=new Scanner(System.in);
        System.out.println("������������Ҫ¼��ѧ����Ϣ�����������֤�š���ҵԺУ");
        String Name=input.nextLine();
        String Id=input.nextLine();
        String School=input.nextLine();
        Resume resume=new Resume(Name,Id,School);
        resumeList.add(resume);
        System.out.println("���Ѿ��ɹ�¼��ѧ����Ϣ");
        showResume(resumeList);
    }

    public static void deleteResume(LinkedList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ɾ��ѧ����Ϣ����");
        System.out.println("��������Ҫɾ����ѧ�����֤��");

        String studentId=input.nextLine();
        int resumeCount=resumeList.size();
        for(int i=0;i<resumeCount;i++){
            if(resumeList.get(i).getId().equals(studentId)){
                resumeList.remove(i);
                System.out.println("���Ѿ��ɹ�ɾ����ѧ����Ϣ");
                break;
            }else if(i==resumeCount-1){
                System.out.println("û���ҵ���ѧ����Ϣ�����ʵ��ɾ��");
            }
        }
        showResume(resumeList);
    }


    public static void updateResume(LinkedList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ѧ����Ϣ�޸Ľ���");
        System.out.println("��������Ҫ�޸�ѧ�������֤��");
        String studentId=input.nextLine();
        int resumeCount = resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(studentId))
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
                resumeList.get(i).setName(newname);
                resumeList.get(i).setId(newid);
                resumeList.get(i).setSchool(newschool);
                resumeList.get(i).setProcess(newprocess);
                resumeList.get(i).setDeleteStatus(newdeleteStatus);
                System.out.println("���Ѿ��޸ĳɹ�");
                showResume(resumeList);
            }
            else if(i==resumeCount-1||resumeCount==0) {
                System.out.println("û�в��ҵ���ѧ���ļ�����Ϣ");
            }
        }
        System.out.println("ϵͳΪ�գ�û�в��ҵ���ѧ���ļ�����Ϣ");
    }

    public static void searchResume(LinkedList<Resume> resumeList){

        Scanner input=new Scanner(System.in);
        System.out.println("��ӭ����ѧ����Ϣ��ѯ����");
        System.out.println("��������Ҫ��ѯ��ѧ�����֤��");
        String studentId=input.nextLine();
        int resumeCount = resumeList.size();
        for(int i=0;i<resumeCount;i++)
        {
            if(resumeList.get(i).getId().equals(studentId))
            {
                System.out.println("ѧ������:"+resumeList.get(i).getName()+" "+
                        "���֤��"+":"+resumeList.get(i).getId()+" "
                        +"��ҵԺУ"+":"+resumeList.get(i).getSchool()+" "
                        +"��������:"+resumeList.get(i).getProcess()+" "
                        +"������ʾ״̬:"+resumeList.get(i).getDeleteStatus());
                break;
            }
            else if(i==resumeCount-1) {
                System.out.println("û�в��ҵ���ѧ��������������");
            } else if (resumeCount==0){
                System.out.println("ϵͳΪ�գ�û�в��ҵ���ѧ���ļ�����Ϣ");
            }
        }

    }



    public static void showResume(LinkedList<Resume> resumeList) {
        int resumeCount=resumeList.size();
        Scanner input = new Scanner(System.in);
        System.out.println("�Ƿ���Ҫ��ӡ����ѧ����Ϣ����������Y�����ô�ӡ����������");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
            System.out.println("����������ϵͳ����" + resumeCount + "��ѧ��������Ϣ");
            for (int i = 0; i < resumeCount; i++) {
                System.out.println("ѧ������:" + resumeList.get(i).getName() + " " +
                        "���֤��" + ":" + resumeList.get(i).getId() + " "
                        + "��ҵԺУ" + ":" + resumeList.get(i).getSchool() + " "
                        + "��������:" + resumeList.get(i).getProcess() + " "
                        + "������ʾ״̬:" + resumeList.get(i).getDeleteStatus());
            }
        }
    }
}
