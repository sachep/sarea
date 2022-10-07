//LC864 ��� ������� - ������� �� ������� 290922

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//������� ��� �������� ������� ����� �����
class solution{

class Node{
  int stro  ;
  int kolo  ;
  String key ;
  Node(int stro,int kolo,String key){
     this.stro=stro;
     this.kolo=kolo;
     this.key=key;
  }
 String toString(int stro,int kolo,String key){
   return stro+"-"+kolo+"-"+key;
 }
} //node

public int allkey(String[] grid){
   int row=grid.length;
   int cow=grid[0].length();
   int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
   int steps=0;
   int keycount=0;
   Set<String> visited=new HashSet<>();
   Queue<Node> queue=new LinkedList<>();
   // ��� ������ � ��������� �����
   for (int i=0;i<row;i++){
     for(int j=0;j<cow;j++){
        if(grid[i].charAt(j)=='@'){
           queue.add(new Node(i,j,""));
        }
        else if (grid[i].charAt(j)>='a' & grid[i].charAt(j)<='f'){
                 keycount++;  
              }
     }// for j
   } //for i
  
   while(!queue.isEmpty()){
     int size=queue.size();
     for(int i=0;i<size;i++){//������������ ������� ������� ���� �� ������ ������ ���������
        Node temp=queue.poll();  // ����� �� �������
        int r=temp.stro;
        int c=temp.kolo;
        String key=temp.key;
        if(!visited.contains(temp.toString(r,c,key))){
            visited.add(temp.toString(r,c,key));
        }
        else continue; // ���� ���� ��� ����������
        if(keycount==key.length()) return keycount;//����� ��� �����  !
        
        for (int[] dir:dirs){
          int nr=r+ dir[0];
          int nc=c+ dir[1];
          Node newNode=new Node(nr,nc,key);
          if(nr<0||nr>=row||nc<0||nc>=cow||grid[nr].charAt(nc)=='#'||visited.contains(newNode.toString(nr,nc,key))){ // �� � �����, �����, ��� ���
            continue;
          }    
          char ch=grid[nr].charAt(nc);
                 if(key.indexOf(ch)==-1 && ch>='a' && ch<='f'){ //����� ���� - ��� � ������
                           queue.add(new Node(nr,nc,key+ch));
                 } else if(ch>='A' && ch<='F' && key.indexOf(Character.toLowerCase(ch))==-1){// ����� ����� � ����� ��� - continue
                            continue;
                        } else { // ������ ������ ��� ���� ���� - ��� ��� �����
                              queue.add(new Node(nr,nc,key));
                          }

        } //for dir
        
     }//for
     

   }//while	




}// allkey

}//solution