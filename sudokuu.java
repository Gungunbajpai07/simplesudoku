import java.util.Scanner;
class sudokuu
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int ar[][]={{5,3,0,6,0,0,0,0,0},
                   {6,0,0,1,9,5,0,0,0},
                   {0,9,8,0,0,0,0,6,0},
                   {8,0,0,0,6,0,0,0,3},
                   {4,0,0,8,0,3,0,0,1},
                   {7,0,0,0,2,0,0,0,6},
                   {0,6,0,0,0,0,2,8,0},
                   {0,0,0,4,1,9,0,0,5},
                   {0,0,0,0,8,0,0,7,9}};
                   //game loop
                   while(true)
                   {
                    printboard(ar);
                    //checking win situation
                    if(isBoardFull(ar)==true)
                    {
                        System.out.println("SUDOKU SOLVED YOU WIN");
                        break;
                    }
                    //taking user input
                    System.out.print("enter the row number between 0-8");
                    int row = sc.nextInt();
                    System.out.print("enter the column number between 0-8");
                    int col = sc.nextInt();
                    System.out.print("enter the numbers between 1-9");
                    int num = sc.nextInt();
                    
                    //validating the user input
                    if(row<0||row>8||col<0||col>8||num<1||num>9)
                    {
                        System.out.println("XXX invalid input XXX");
                        continue;
                    }
                    if(ar[row][col]!=0)
                    {
                        System.out.println("XXX cell already filled XXX");
                        continue;
                    }
                    if(isValidMove(ar,row,col,num)==true)
                    {
                        ar[row][col]=num;
                        System.out.println("### number inserted ###");
                    }
                    else
                    {
                        System.out.println("XXX invalid move XXX");
                    } 
                   }
                }
    public static void printboard(int ar[][])
    {
        for(int i=0;i<9;i++)
        {
            if(i%3==0&&i!=0) //to print rows
              System.out.println("___+___+___");
            for(int j=0;j<9;j++)
            {
              if(j%3==0&&j!=0) //to print columns
               System.out.print("|");
              System.out.print(ar[i][j]==0?".": ar[i][j]); //placing . in every empty cell
            }
        System.out.println();
    }
    }
    public static boolean isValidMove(int ar[][],int row,int col,int num)
    {
        //checking row and column
        for(int i=0;i<9;i++)
        {
            if(ar[row][i]==num||ar[i][col]==num)
            {
                return false;
            }
        }
        //checking 3x3 grid
        int startrow= row-row%3;
        int startcol= col-col%3;
        for(int i= startrow;i<startrow+3;i++)
        {
            for(int j=startcol;j<startcol+3;j++)
            {
                if(ar[i][j]==num)
                return false;
            }
        }
        return true;
    }
    public static boolean isBoardFull(int ar[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
              if(ar[i][j]==0)
              {
                  return false;
              }  
            }
        }
        return true;
    }
}