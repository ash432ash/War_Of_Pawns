
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Board extends JFrame implements MouseListener
{

    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int arr[][]=new int[12][12];
JLabel w_white = new JLabel(new ImageIcon(getClass().getResource("w_white.PNG")));
 JLabel b_white = new JLabel(new ImageIcon(getClass().getResource("b_white.PNG")));
 JLabel w_black = new JLabel(new ImageIcon(getClass().getResource("w_black.PNG")));
 JLabel b_black = new JLabel(new ImageIcon(getClass().getResource("b_black.PNG")));
 JLabel empty_white = new JLabel(new ImageIcon(getClass().getResource("empty_white.PNG")));
 JLabel empty_black = new JLabel(new ImageIcon(getClass().getResource("empty_black.PNG")));
 JPanel p_arr[][]=new JPanel[12][12];
 JLabel arr1[]={w_white,b_white,w_black,b_black,empty_white,empty_black};
        MouseAdapterMod mam = new MouseAdapterMod();
        int x=-1,y=-1;//Initial Button
//1 White piece
//0 Black Piece
//-1 Piece
    public Board() 
    {
        Dimension boardSize = new Dimension(874, 650);
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
      //  layeredPane.addMouseListener(this);


        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(12, 12));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        
for(int i=0;i<12;i++)
{
    for(int j=0;j<12;j++)
    {
        if(i==0||i==1)//White piece
            arr[i][j]=1;
        else if(i==10||i==11)//Black piece
            arr[i][j]=0;
        else
            arr[i][j]=-1;//Empty Piece
    }
}
        for (int i = 0; i < 144; i++) 
        {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            
            int row = (i / 12) % 2;
            if (row == 0) 
            {
                square.setBackground(i % 2 == 0 ? Color.black : Color.white);
            } 
            else 
            {
                square.setBackground(i % 2 == 0 ? Color.white : Color.black);
            }
        }
        
 for(int i=0;i<144;i++)
 {
       JPanel square1=(JPanel)chessBoard.getComponent(i);
      JLabel w_white = new JLabel(new ImageIcon(getClass().getResource("w_white.PNG")));
 JLabel b_white = new JLabel(new ImageIcon(getClass().getResource("b_white.PNG")));
  JLabel w_black = new JLabel(new ImageIcon(getClass().getResource("w_black.PNG")));
 JLabel b_black = new JLabel(new ImageIcon(getClass().getResource("b_black.PNG")));
 JLabel empty_white = new JLabel(new ImageIcon(getClass().getResource("empty_white.PNG")));
 JLabel empty_black = new JLabel(new ImageIcon(getClass().getResource("empty_black.PNG")));
 int row = (i / 12) % 2;
            
       if(i<=23)
       {
           if(row==0)
           {
               square1.add(i % 2 == 0 ? w_white : b_white);
        }
           else
           {
              square1.add(i % 2 == 0 ? b_white : w_white); 
           }
       }
       
       else if(i>23&&i<=119)
       {
          if(row==0)
           {
               square1.add(i % 2 == 0 ? empty_white : empty_black);
        }
           else
           {
              square1.add(i % 2 == 0 ? empty_black : empty_white); 
           }
       }
       
       else
       {
         if(row==0)
           {
               square1.add(i % 2 == 0 ? w_black : b_black);
        }
           else
           {
              square1.add(i % 2 == 0 ? b_black : w_black); 
           }
       }
       p_arr[i/12][i%12]=(JPanel)chessBoard.getComponent(i);
       p_arr[i/12][i%12].addMouseListener(mam);
 }

    }

    public Icon getLabelIcon(JLabel b)
    {
        return b.getIcon();
    }
       public void setLabelIcon(JLabel b,ImageIcon c)
       {
          
       }
    public void setButtonColor(Button b,Color c)
    {
       b.setBackground(c);
    }
       
    public Color getJButtonColor(JButton b)
    {
        return b.getBackground();
    }
       
    public void setJButtonColor(JButton b,Color c)
    {
       b.setBackground(c);
    }

    public void mouseClicked(MouseEvent e) 
    {
        System.out.println(e.getX() + " " + e.getY());
 
    }

    public void mouseMoved(MouseEvent e) 
    {
    }

    public void mouseEntered(MouseEvent e) 
    {

    }

    public void mouseExited(MouseEvent e) 
    {

    }

    public static void main(String[] args) 
    {
        JFrame frame = new Board();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class MouseAdapterMod extends MouseAdapter 
    {

        public void mousePressed(MouseEvent e)
        {
            JPanel clicked_Panel = (JPanel)e.getSource();
            int x1=clicked_Panel.getX();
            int y1=clicked_Panel.getY();
            int i,j=0;
     // System.out.println(x1);
      int f=0;
       for(i=0;i<12;i++)
       {
           for(j=0;j<12;j++)
           {
               //System.out.println(i+" "+j);
               if(p_arr[i][j]==clicked_Panel)
               {
                   f=1;
                   break;
               }
                   
           }
           if(f==1)
               break;
       }
       
      // System.out.println(i+" "+j);
             if(x==-1&&y==-1)
             {
                 if(arr[i][j]==-1)
                     return;
                 else
                 {
                 x=i;
                 y=j;
                 return ;
             }
             }
             else
             {
                 System.out.println(x+" "+y+i+" "+j);
       if(Math.abs(x-i)==1&&Math.abs(y-j)==1||Math.abs(x-i)==1&&y==j)
       {
           System.out.println("v");
           if(valid(i,j)==1)
           {
              System.out.println("a");
              //Syste
            if(p_arr[x][y]==w_white.getParent()||valid1(w_black,p_arr[x][y]))
              {
                  p_arr[x][y].remove(0);
                  p_arr[x][y].add(empty_white);
                  System.out.println("empty white");
                  if(p_arr[i][j]==empty_black.getParent())
                  {
                      if(arr[x][y]==0)
                      {
                           p_arr[i][j].remove(0);
                          p_arr[i][j].add(b_black);
                      }
                      else
                      {
                           p_arr[i][j].remove(0);
                          p_arr[i][j].add(b_white);
                      }
                  }
                  else if(p_arr[i][j]==empty_white.getParent())
                  {
                       if(arr[x][y]==0)
                       {
                           p_arr[i][j].remove(0);
                          p_arr[i][j].add(w_black);
                       }
                      else
                       {
                           p_arr[i][j].remove(0);
                          p_arr[i][j].add(w_white);
                       }
                  }
                  else if(p_arr[i][j]==w_black.getParent()&&arr[x][y]==1)
                  {
                      p_arr[i][j].remove(0);
                       p_arr[i][j].add(w_white);
                  }
                  else if(p_arr[i][j]==w_white.getParent()&&arr[x][y]==0)
                  {
                       p_arr[i][j].remove(0);
                       p_arr[i][j].add(w_white);
                  }
                  
                  
              }
              /*else if(p_arr[x][y]==w_black||p_arr[x][y]==b_black)
              {
                  p_arr[x][y]=empty_black;
              }*/
           }
               
       }
        }
        }
        boolean valid1(Component c,JPanel jPanel)
{
    Component[] components = jPanel.getComponents();
    
    for (Component component : components) 
    {
      //  System.out.println("a");
        if (c== component) 
        {
          //   System.out.println("bb");
                return true;
        }
    }
    return false;
}
        public int valid(int i,int j)
        {
            if(i>=0&&i<12&&j>=0&&j<12)
                return 1;
            return 0;
        }
    }
}
