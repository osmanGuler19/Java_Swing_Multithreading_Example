import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class main {

    public static void main(String args[]){

                JFrame frame = new JFrame("GUI");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300,600);
                JPanel panel  = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JLabel label1 = new JLabel("Finding Prime Numbers In Range");
                JTextField primeTextField = new JTextField();
                JLabel primeLabel = new JLabel("Sonuc :");
                JButton findPrimesButton = new JButton("Hesapla");
                JLabel label2 = new JLabel("Dividing Operation");
                JTextField firstNumTextField = new JTextField();
                JTextField secondNumTextField = new JTextField();
                JLabel divideLabel = new JLabel("Sonuc :");
                JButton divideButton = new JButton("Hesapla");


                findPrimesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PrimeWorker(Integer.parseInt(primeTextField.getText()),primeLabel);
                    }
                });

                divideButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DivideWorker(Integer.parseInt(firstNumTextField.getText()),Integer.parseInt(secondNumTextField.getText()),divideLabel);
                    }
                });


                frame.add(panel,BorderLayout.CENTER);
                panel.add(label1);
                panel.add(primeTextField);
                panel.add(primeLabel);
                panel.add(findPrimesButton);
                panel.add(label2);
                panel.add(firstNumTextField);
                panel.add(secondNumTextField);
                panel.add(divideLabel);
                panel.add(divideButton);
                frame.setVisible(true);
            }


    public static void PrimeWorker(int num, JLabel label){

        SwingWorker<Void,Integer> worker = new SwingWorker<Void, Integer>()
        {
            @Override
            protected Void doInBackground() throws Exception {
                int var3 = num;
                int count;
                //loop for finding and printing all prime numbers between given range
                for(int i = 2; i <= var3 ; i++)
                {
                    //logic for checking number is prime or not
                    count = 0;
                    for(int j = 1 ; j <= i ; j++)
                    {
                        if(i % j == 0)
                            count = count+1;
                    }
                    if(count == 2)
                        System.out.println(i);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                Integer value = chunks.get(chunks.size()-1);
                label.setText("Sonuc : Prime Number =>" +value);
            }




        };
        worker.execute();
    }

    public static void DivideWorker(int num1,int num2,JLabel label){
        SwingWorker<Void,Integer> worker = new SwingWorker<Void, Integer>(){
            @Override
            protected void process(List<Integer> chunks) {
                String val = chunks.get(chunks.size()-1).toString();
                label.setText(val);
            }

            @Override
            protected Void doInBackground() throws Exception {
                int value = num1/num2;
                publish(value);
                return null;
            }
        };
        worker.execute();
    }



}










