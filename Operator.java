
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Operator extends JFrame implements ActionListener
{
    static double total;
    static boolean chosen = false;

    static ActionEvent next;

    static void init()
    {
        total=0;
        next=null;

        chosen=false;
        Calculator.currentTextBox=null;
        Calculator.textField.setText("");

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== Calculator.clear)
        {
            init();
        }
        else if(chosen==true|| Calculator.currentTextBox==null)
        {
            
            Calculator.warningLabel.setText("Can't choose an operator again!");
        }
        else
        {
            if(next==null)
            {
                //if there is no operator and
                //this is the first operator
                next=e;
                //set the source
                Calculator.textField.setText("");        
                total=Double.parseDouble(Calculator.currentTextBox);

                Calculator.currentTextBox=null;

                chosen=true;
            }
            else 
            {
                //If there is an operator value that is already present

                //Set the current operation to be the next one
                //empty the textbox

                total=determineCalculation(next);
                
                next=e;

                
                Calculator.textField.setText(""+total);
                Calculator.currentTextBox=null;

                chosen=true;
            }

        }
    }

    double determineCalculation(ActionEvent e)
    {
        double result=0;

        if(e.getSource()==Calculator.addition)
        {
            result= add(total,(Double.parseDouble(Calculator.currentTextBox))); 
        }
        else if(e.getSource()==Calculator.subtraction)
        {
            result=subtract(total,Double.parseDouble(Calculator.currentTextBox)); 
        }
        else if(e.getSource()==Calculator.multiplication)
        {
            result= multiply(total,(Double.parseDouble(Calculator.currentTextBox))); 
        }
        else if(e.getSource()==Calculator.division)
        {
            result= divide(total,(Double.parseDouble(Calculator.currentTextBox))); 
        }
        if((e.getSource()==Calculator.equals))
        {
            return total ;

        }
        return result;
    }

    public double add(double value1, double value2)
    {
        return (value1+value2);
    }

    public double subtract(double value1, double value2)
    {
        return (value1-value2);
    }

    public double divide(double value1,double value2)
    {
        if(value1==0)
        {
            return 0;
        }
        else
        {
            return (value1/value2);
        }
    }

    public double multiply(double value1,double value2)
    {
        return (value1*value2);
    }
    

}