public class menu {
    public void menu() throws IOException{
       Try z = new Try();
menu c = new menu();
         int choice;
      out.println("please choose an algorithm to use");
      out.println();
      out.println("press 1 for FIFO \n"+"press 2 for LRU \n"+"press 3 for optimal ");
      out.println("press 0 to exit");
      Scanner sc = new Scanner(System.in);
     choice= sc.nextInt();
      if(choice==1)
      {
          z.fifo();
      }
//      switch(choice) {
//  case 1:
//    
//    break;
//  case 2:
//    
//    break;
//  default:
//   case 3:
//    
//    break;
//   case 4:
//    
//    break;
//}
      else if(choice==2)
      {
           z.lru();
      }
    else  if(choice==3)
      {
                   z.optimal();
c.menu();

      }
    else if (choice ==0){
     out.println("thanks");
    }
   
    else{
        out.print("press a number from 1 to 3");
        c.menu();

            }
      
    }
    }
