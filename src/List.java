import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class List<E> extends JPanel{

    private static final int X = 93;//x position
    private   int y = 550;//y-position
    private static final int increment = 45;
    private int counter = 0;
    private int temp;
    private String[] arrayStack = new String[11];//array to store the strings
    LinkedList<String> linkedList = new LinkedList<String>();
    LinkedList<Integer> posit=new LinkedList<Integer>();
    LinkedHashMap<String ,String > positionList= new LinkedHashMap<String, String>();
    //constructor
    public List(){
        setLayout(null);//create an empty layout
        //create buttons
        JButton addFirstButton = new JButton("ADD FIRST");
        JButton addBeforeButton = new JButton("ADD BEFORE");
        JButton addAfterButton = new JButton("ADD AFTER");
        JButton replaceButton = new JButton("REPLACE");
        JButton swapButton = new JButton("SWAP");
        JButton removeButton = new JButton("REMOVE");
        JButton sizeButton = new JButton("SIZE");
        JButton firstButton = new JButton("FIRST");
        JButton lastButton = new JButton("LAST");
        JButton afterButton = new JButton("AFTER");
        JButton beforeButton = new JButton("BEFORE");
        JButton emptyButton = new JButton("IS EMPTY");



        //set the positions of the buttons
        addFirstButton.setBounds(480, 50, 120, 30);
        add(addFirstButton);

        addBeforeButton.setBounds(480, 100, 120, 30);
        add(addBeforeButton);

        sizeButton.setBounds(480, 150, 120, 30);
        add(sizeButton);

        addAfterButton.setBounds(480, 200, 120, 30);
        add(addAfterButton);

        replaceButton.setBounds(480, 250, 120, 30);
        add(replaceButton);

        swapButton.setBounds(480, 300, 120, 30);
        add(swapButton);

        removeButton.setBounds(480, 350, 120, 30);
        add(removeButton);

        firstButton.setBounds(480, 400, 120, 30);
        add(firstButton);

        lastButton.setBounds(480, 450, 120, 30);
        add(lastButton);

        afterButton.setBounds(480, 500, 120, 30);
        add(afterButton);

        beforeButton.setBounds(480, 550, 120, 30);
        add(beforeButton);

        emptyButton.setBounds(480, 600, 120, 30);
        add(emptyButton);

        //Button handlers to handle user events
        addFirstHandler addFirst = new addFirstHandler();
        addFirstButton.addActionListener(addFirst);


        addBeforeHandler addBefore = new addBeforeHandler();
        addBeforeButton.addActionListener(addBefore);

        sizeHandler size = new sizeHandler();
        sizeButton.addActionListener(size);

        addAfterHandler addAfter = new addAfterHandler();
        addAfterButton.addActionListener(addAfter);

        replaceHandler replace = new replaceHandler();
        replaceButton.addActionListener(replace);

        swapHandler swap = new swapHandler();
        swapButton.addActionListener(swap);

        removeHandler remove = new removeHandler();
        removeButton.addActionListener(remove);

        firstHandler first = new firstHandler();
        firstButton.addActionListener(first);

        lastHandler last = new lastHandler();
        lastButton.addActionListener(last);

        afterHandler after = new afterHandler();
        afterButton.addActionListener(after);

        beforeHandler before = new beforeHandler();
        beforeButton.addActionListener(before);

        emptyHandler empty = new emptyHandler();
        emptyButton.addActionListener(empty);

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        temp = y;
        String[] array = (String[]) linkedList.toArray(new String[0]);
        for(int counter2=0; counter2 <array.length; counter2++){

            g.setColor(Color.GRAY);
            g.fillRect(X , temp, 280, 40);

            g.setColor(Color.BLACK);
            int pos= Integer.parseInt(positionList.get(array[counter2]));
            g.drawString(String.valueOf(array[counter2]), X + 190, temp+20);
            g.drawString("Position "+pos, X + 120, temp+20);
            g.drawString("Rank: "+(1+counter2), X + 10, temp+20);
            temp -= increment;
        }

        g.drawRect(60,80,350,520);
    }

    private class addFirstHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){
            if(counter == 11){
                JOptionPane.showMessageDialog(null, "List is full!!");
            }
            else{

                String temp2=JOptionPane.showInputDialog("Enter First Element");
                arrayStack[counter] = temp2;
                linkedList.addFirst(temp2);
                posit.add(counter+1);
                String pos1= String.valueOf(1+counter);
                positionList.put(temp2,pos1);
                counter += 1;
                repaint();
            }
        }

    }

    private class addBeforeHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }
            else{
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank of Element"));
                    String temp2=JOptionPane.showInputDialog("Element to be added");
                    int a=posit.indexOf(temp);
                    linkedList.add(a,temp2);
                    posit.add(counter+1);
                    String pos1= String.valueOf(1+counter);
                    positionList.put(temp2,pos1);
                    counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }

            }
        }
    }

    private class addAfterHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }
            else{
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank of Element"));
                    String temp2=JOptionPane.showInputDialog("Element to be added");
                    int a=posit.indexOf(temp);
                    linkedList.add(a+1,temp2);
                    String pos1= String.valueOf(1+counter);
                    positionList.put(temp2,pos1);
                    posit.add(counter+1);

                    counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }
    }

    private class replaceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }else {
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank"));
                    String temp2=JOptionPane.showInputDialog("Element to be added");
                    String s=linkedList.get(temp-1);
                    //linkedList.set(temp-1,temp2);
                    linkedList.remove(temp-1);
                    linkedList.add(temp-1,temp2);
                    int pos= Integer.parseInt(positionList.get(s));
                    String pos1= String.valueOf(pos);
                    positionList.remove(s,pos1);
                    positionList.put(temp2,pos1);
//                    fixme find better implementation
                    System.out.println("Positions="+positionList.values());
                    //counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
            }
    }

    private class swapHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter==0){
                JOptionPane.showMessageDialog(null,"List is Empty");
            }else {
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank of element to Swap"));
                    int temp2= Integer.parseInt(JOptionPane.showInputDialog("Rank of element to be Swapped with"));
                    String s=linkedList.get(temp-1);
                    String s2=linkedList.get(temp2-1);

                    // linkedList.remove(temp-1);
                    // linkedList.add(temp-1,s);
                    linkedList.set(temp-1,s2);
                    linkedList.set(temp2-1,s);

                    //linkedList.remove(temp2-1);
                    //System.out.println("Swap="+linkedList.get(temp-1)+linkedList.get(temp2-1));
                    //linkedList.add(temp-1,s2);

                    System.out.println("Elements");
                    for (String x:arrayStack
                    ) {
                        System.out.println(x);
                    }                //counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }


        }
    }//

    private class removeHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is Empty!!");
            }
            else{
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Element at Rank"));
                    linkedList.remove(temp-1);
                    positionList.remove(temp-1);
                    counter -= 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }
    }

    private class sizeHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, "The size is: " + linkedList.size());
        }
    }

    private class firstHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }
            else{
                String first= linkedList.getFirst();
                int pos= Integer.parseInt(positionList.get(first));
                JOptionPane.showMessageDialog(null,"Position of First Element is "+pos);
                counter += 1;
                repaint();
            }
        }
    }

    private class lastHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is Empty!!");
            }
            else{
                String last= linkedList.getLast();
                int pos= Integer.parseInt(positionList.get(last));
                JOptionPane.showMessageDialog(null,"Position of Last Element is "+pos);
                counter += 1;
                repaint();
            }
        }
    }

    private class afterHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter ==0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }
            else{
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank"));
                    String after= linkedList.get(temp);
                    int pos = Integer.parseInt(positionList.get(after));
                    JOptionPane.showMessageDialog(null,"Position of Element After is "+pos);
                    counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }

            }
        }
    }

    private class beforeHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(counter == 0){
                JOptionPane.showMessageDialog(null, "list is empty!!");
            }
            else{
                try{
                    int temp= Integer.parseInt(JOptionPane.showInputDialog("Rank"));
                    String after= linkedList.get(temp-2);
                    int pos = Integer.parseInt(positionList.get(after));
                    JOptionPane.showMessageDialog(null,"Position of Element Before is "+pos);
                    counter += 1;
                    repaint();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }
    }

    private class emptyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){

            String empty= String.valueOf(linkedList.isEmpty());
            JOptionPane.showMessageDialog(null,empty);
        }
    }
}
