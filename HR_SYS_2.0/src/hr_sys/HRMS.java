package hr_sys;
import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import model.Resume;
import service.ResumeService;

public class HRMS {
    public static void main(String[] args) {
        //���������
        String filepath="E:/HH_STUDY-xianyuhong5917/HR_SYS_2.0/out/resumelist.txt";
        LinkedList<Resume> resumeList = new LinkedList<Resume>();
        Scanner input = new Scanner(System.in);
        DataOperate.loadData(resumeList,filepath);
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
                ResumeService.addResume(resumeList);
            }
            else if(choice==2)
            {
                ResumeService.deleteResume(resumeList);
            }
            else if(choice==3)
            {
                ResumeService.updateResume(resumeList);
            }
            else if(choice==4)
            {
                ResumeService.searchResume(resumeList);
            }
            else if(choice==5)
            {
                DataOperate.saveData(resumeList,filepath);
                input.close();
                break;
            }else {
                System.out.println("�����������������");
            }
        }
        //�ر�������
        System.out.println("���Ѿ��˳�xxx��������ϵͳ");
        DataOperate.saveData(resumeList,filepath);
    }
}
