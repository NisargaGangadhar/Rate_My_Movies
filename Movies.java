import java.util.Scanner;
public class Movies{
   final int max_item = 5;
   final int max_rating = 5;
    

    public static void main(String []args){
        
       
      Scanner sc1 = new Scanner(System.in);
      Scanner sc2 = new Scanner(System.in);
      Solve mysol=new Solve();
       System.out.println("Dear User, Please provide information about movies\n");
       System.out.println("The maximum number of items you can provide is 5");
          System.out.println("The maximum number of ratings you can provide for each item is 5");
          System.out.println("1 – Add an item \n 2 – Display all the items \n 3 – Add a rating for a given item \n 4 – Display all the ratings for a given item \n 5 – Calculate and display the average rating for each item \n 6 – The functionality assigned to you in section Instructions and Checklist. \n 7 – Exit application");
          int ch =0;
          while(ch == 0){
            System.out.println("Enter your choice");
            int a = sc1.nextInt();
            System.out.println("You Entered "+a);
                switch(a){
            case 1:
                mysol.add();
                break;
            case 2:
                mysol.display();
                break;
            case 3:
                System.out.println("Enter the movie name for which you wnt to give rating");
                String s = sc2.nextLine();
                mysol.add_rating(s);
                break;
            case 4:
                System.out.println("Enter the item for which you want to get ratings");
                String n=sc2.nextLine();
                mysol.display_rating(n);
                break;
            case 5:
                mysol.cal_average_rating();
                break;
            case 6:
                mysol.best_item();
                break;
            case 7:
                System.out.println("Exiting");
                ch = 1;
                break;
            default:
                    System.out.println("Enter valid choices between 1-7");
                    break;
          }
        
    }
    sc1.close();
    sc2.close();
}
}
class Solve{
    
    String[] item = new String[5];
    int[][] ratings = new int[5][5];
    int[] c = {0,0,0,0,0};
    int[] avg_rating={0,0,0,0,0};
    int i=0,index,index1;
    Scanner s=new Scanner(System.in);
    Scanner s3=new Scanner(System.in);
    void add(){
       
        if(i<5){
        System.out.println("Enter information");
        String st = s.nextLine();
        item[i]=st.toLowerCase();
        System.out.println("You Entered "+ item[i]+ ", Has been added");
        i++;    
    }
    else{
        System.out.println("Sorry!!! you cant enter as you can only enter upto 5");
    }
    }
    void display(){
        for(int j =0; j< i;j++){
            if(item[j]==null){
                System.out.println("No items left, you can add more");
                break;
            }
            else{
            System.out.println(item[j]);}
        }
    }
    void add_rating(String s){
        
        // converting item array string to lower case array of string
        String str = s.toLowerCase();
       
        int g=0;
        for(int k=0;k<i;k++){
            String l=item[k];
            if(l.equals(str)){
                
                index = c[k];
                if(index < 5){
                System.out.println("Enter rating");
                ratings[k][index] = s3.nextInt();
                c[k]=c[k]+1;
                break;
                }
                else{
                    System.out.println("Only upto 5 ratings can be entered per movie");
                    break;
                }
                
            }
            else{
            g++;}
           
            
            
    }
    if(g == i){
        System.out.println("The item you entered is not present in list");
        
    }
    
   
    }
    void display_rating(String s){
        String str=s.toLowerCase();
        int g=0;
        for(int k=0;k<i;k++){
            String l=item[k];
            if(l.equals(str)){
                
                index1 = c[k];
                if(index1 == 0){
                    System.out.println("No ratings provided for this item");
                    break;
                }
                else{
                    System.out.println("ratings are as follows");
                    for(int h = 0;h<index1;h++){
                        System.out.println(ratings[k][h]);
                    }
                    break;
                }

    }
    else{
        g++;
    }
   
    
}
        if(g== i){
            System.out.println("The item you entered is not present");}
    
}

    void cal_average_rating(){
        int k,sum,m;
        for(m =0; m< item.length;m++){
             sum=0;
             if(item[m] == null){
                 break;
             }
             else{
            for(k=0;k<c[m];k++){
                sum=sum+ratings[m][k];

            }
            avg_rating[m]=sum/c[m];
        }
    }
        System.out.println("The average rating of each item is as below");
        for(int q=0;q<avg_rating.length;q++){
            if(item[q]==null){
                break;
            }
            else{
            System.out.println(item[q] + " - "+avg_rating[q]);
        }
    }
}

    void best_item(){
        int max = avg_rating[0];
        int ind =0,q;
        for(q=1;q<avg_rating.length;q++){
            if(avg_rating[q]>max){
                max = avg_rating[q];
                ind = q;
            }

        }
        if(max == 0){
            System.out.println("No ratings provided, so best item cant be found");
        }
        else{
            System.out.println("The best item is "+ item[ind]);
        }
    }
}
