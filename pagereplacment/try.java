public class Try {
    
public void fifo() throws IOException{
  
    
    menu c = new menu();

        int numframes; 
        int pagefault = 0;
        int numsize;
        int frm[];
        int sizearr[];
        int hit=0;
        int outputarr[][];
        int p = 0;

        Scanner sc=new Scanner(System.in);
        
      out.println(" no. of frames: ");
        numframes = Integer.parseInt(sc.nextLine());
        
        out.println("how many pages do u want: ");
        numsize = Integer.parseInt(sc.nextLine());
        
        sizearr = new int[numsize];
        frm = new int[numframes];
        outputarr = new int[numsize][numframes];

//        for(int k = 0; k < numframes; k++){
//             //   frm[k] = 0;
//        }
        out.println(" enter the refrence values to use the algo : ");
        for(int l = 0; l < numsize; l++){   
                sizearr[l] = Integer.parseInt(sc.nextLine()); 
                
        }

        out.println();
        for(int l = 0; l < numsize; l++)
        {
         boolean b = false;
            for(int k = 0; k < numframes; k++)
         {
          if(frm[k] == sizearr[l])
          {
              b=true;
//                      out.println("page number "+x+"is a hit");

           hit++;
        out.println(frm[k]+" is a page hit");

           out.println();
           break;
          } 
         }
       if(b==false)  
       {
          frm[p] = sizearr[l];
          pagefault++;

//           if(frm[k+1]!=frm[k] && sizearr[l+1] != sizearr[l]){
//           out.print("[paage number "_+frm[k]+"is a page fault'");
//           }
         out.println(sizearr[l]+" is a page fault");

          p++;

          if(p == numframes)
           p = 0;
         }
            for(int k= 0; k < numframes; k++)
                outputarr[l][k] = frm[k];
        }
        
        for(int l = 0; l < numframes; l++)
        {
            for(int k = 0; k < numsize; k++)
                System.out.printf("%3d ",outputarr[k][l]);
            out.println();
                       out.println();
            

        }
       out.println("no. of frames:: " + pagefault);
       out.println("The total Hits: " + hit);
       out.println(" Note : 0 is not a number, its an empty place ");
         out.println();
       
c.menu();

}

public void optimal() throws IOException{
        menu c = new menu();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numframes;
        int p = 0;
        int hit = 0;
        int fault = 0;
        //int search = -1;
        int numsize;
        int frm[];
        int sizearr[];
        int outputarr[][];
        boolean isFull = false;
       
        System.out.println("no. of frames: ");
        numframes = Integer.parseInt(br.readLine());
       
        System.out.println("how many pages do u want:  ");
        numsize = Integer.parseInt(br.readLine());
       
        sizearr = new int[numsize];
        outputarr = new int[numsize][numframes];
        frm = new int[numframes];
        for(int j = 0; j < numframes; j++)
                frm[j] = -1;
       
        System.out.println("enter the refrence values to use the algo : ");
//        for(int i = 0; i < numsize; i++)
//        {
//            sizearr[i] = Integer.parseInt(br.readLine());
//        }
//        System.out.println();
       File f=new File("readtext.txt");
       Scanner s=new Scanner(f);
       int ctr=0;
       while(s.hasNextInt()){
           ctr++;
           s.nextInt();
       }
       sizearr=new int[ctr];
       Scanner s1=new Scanner(f);
       for(int i=0;i<sizearr.length;i++){
           sizearr[i]=s1.nextInt();
       }
       System.out.println();
        for(int i = 0; i < numsize; i++)
        {
                 boolean hoba=false;

         for(int j = 0; j < numframes; j++)
         {
          if(frm[j] == sizearr[i])
          {
//           search = j;
              hoba=true;
           hit++;
           break;
          }
         }
         if(hoba == false)
         {
          if(isFull)
          {
           int index[] = new int[numframes];
           boolean index_flag[] = new boolean[numframes];
           for(int j = i + 1; j < numsize; j++)
           {
            for(int k = 0; k < numframes; k++)
            {
             if((sizearr[j] == frm[k]) && (index_flag[k] == false))
             {
              index[k] = j;
              index_flag[k] = true;
              break;
             }
            }
           }
           int max = index[0];
           p = 0;
           if(max == 0)
            max = 200;
           for(int j = 0; j < numframes; j++)
           {
            if(index[j] == 0)
             index[j] = 200;
            if(index[j] > max)
            {
             max = index[j];
             p = j;
            }
           }
          }
          frm[p] = sizearr[i];
          fault++;
          if(!isFull)
          {
           p++;
              if(p == numframes)
              {
               p = 0;
               isFull = true;
              }
          }
         }
            for(int j = 0; j < numframes; j++)
                outputarr[i][j] = frm[j];
        }
       
        for(int i = 0; i < numframes; i++)
        {
            for(int j = 0; j < numsize; j++)
                System.out.printf("%3d ",outputarr[j][i]);
            System.out.println();
        }
       
        System.out.println("The number of Hits: " + hit);
        //System.out.println("Hit Ratio: " + (float)((float)hit/ref_len));
        System.out.println("The number of Faults: " + fault);
       c.menu();
    }
   



public void lru() throws IOException{

        menu c = new menu();
 int numframes,p = 0, hit = 0, pagefault = 0,numsize;
  int frm[];
   int sizearr[];
        int  outputarr[][];
        
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
      
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        out.println("press 1 to enter your numbers , press 2 to use numbers from a file");
        int w =sc.nextInt();
      if(w==1){ 
       out.println("no. of frames: ");
        numframes = Integer.parseInt(br.readLine());
        
       out.println("how many pages do u want: ");
        numsize = Integer.parseInt(br.readLine());
        
        sizearr = new int[numsize];
         outputarr = new int[numsize][numframes];
        frm = new int[numframes];
        for(int j = 0; j < numframes; j++)
                frm[j] = -1;
        
        out.println("enter the refrence values to use the algo : ");
        for(int i = 0; i < numsize; i++)
        {
            sizearr[i] = Integer.parseInt(br.readLine());
        }
         
        out.println();
        for(int i = 0; i < numsize; i++)
        {
            if( arr.contains(sizearr[i]))
            {
              arr.remove( arr.indexOf(sizearr[i]));
            }
            arr.add(sizearr[i]);
            //int search = -1;
            boolean b =false;
            for(int j = 0; j < numframes; j++)
            {
                if(frm[j] == sizearr[i])
                {
                   // search = j;
                    b=true;
                    hit++;
                            out.println(frm[j]+" is a page hit");

                    break;
                }
            }
                    Boolean isFull = false;

            if(b==false)
            {
             if(isFull)
             {
              int min_loc = numsize;
                    for(int j = 0; j < numframes; j++)
                    {
                     if( arr.contains(frm[j]))
                        {
                            int temp =  arr.indexOf(frm[j]);
                            if(temp < min_loc)
                            {
                                min_loc = temp;
                                p = j;
                            }
                        }
                    }
             }
                frm[p] = sizearr[i];
                pagefault++;
                         System.out.println(sizearr[i]+" is a page fault");

                p++;
                if(p == numframes)
                {
                 p = 0;
                 isFull = true;
                }
            }
            for(int j = 0; j < numframes; j++)
                outputarr[i][j] = frm[j];
        }
        
        for(int i = 0; i < numframes; i++)
        {
            for(int j = 0; j < numsize; j++)
                out.printf("%3d ", outputarr[j][i]);
            out.println();
        }
        
         out.println("no. of faults : " + pagefault);
       out.println("The total Hits: " + hit);
         out.println();


        c.menu();


}



      
      else if(w==2){
      
          String file = "r.txt";
        BufferedReader r = new BufferedReader(new FileReader(file));
          
       
        numframes = Integer.parseInt(r.readLine());
        
        numsize =  Integer.parseInt(r.readLine());
        
        sizearr = new int[numsize];
         outputarr = new int[numsize][numframes];
        frm = new int[numframes];
        for(int j = 0; j < numframes; j++)
                frm[j] = -1;
        
        for(int i = 0; i < numsize; i++)
        {
            sizearr[i] = Integer.parseInt(r.readLine());
        }
        out.println();
        for(int i = 0; i < numsize; i++)
        {
            if( arr.contains(sizearr[i]))
            {
              arr.remove( arr.indexOf(sizearr[i]));
            }
            arr.add(sizearr[i]);
            //int search = -1;
            boolean b =false;
            for(int j = 0; j < numframes; j++)
            {
                if(frm[j] == sizearr[i])
                {
                   // search = j;
                    b=true;
                    hit++;
                            out.println(frm[j]+" is a page hit");

                    break;
                }
            }
                    Boolean isFull = false;

            if(b==false)
            {
             if(isFull)
             {
              int min_loc = numsize;
                    for(int j = 0; j < numframes; j++)
                    {
                     if( arr.contains(frm[j]))
                        {
                            int temp =  arr.indexOf(frm[j]);
                            if(temp < min_loc)
                            {
                                min_loc = temp;
                                p = j;
                            }
                        }
                    }
             }
                frm[p] = sizearr[i];
                pagefault++;
                         System.out.println(sizearr[i]+" is a page fault");

                p++;
                if(p == numframes)
                {
                 p = 0;
                 isFull = true;
                }
            }
            for(int j = 0; j < numframes; j++)
                outputarr[i][j] = frm[j];
        }
        
        for(int i = 0; i < numframes; i++)
        {
            for(int j = 0; j < numsize; j++)
                out.printf("%3d ", outputarr[j][i]);
            out.println();
        }
        
         out.println("no. of faults : " + pagefault);
       out.println("The total Hits: " + hit);
         out.println();


        c.menu();


}
      else {out.print(" you have to choose 1 or 2");}

        c.menu();






    
}


      }
