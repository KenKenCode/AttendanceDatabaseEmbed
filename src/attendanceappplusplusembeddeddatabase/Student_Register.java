package attendanceappplusplusembeddeddatabase;


import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import java.net.InetAddress;
import javax.swing.*;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Student_Register extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Student_Register() {
        
        initComponents(); //initComponents() must be in the first to avoid NullPointerException
        try{
        //changeTableNameLabel();
        //listOfActiveAccounts();
        //activeAccount();
        //MarkedSectionsTable();
        //DataAdminAccountFrameNoteTaking();
        //CurrentDate();
        Data();
        retrieveDataComboBox();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e + "\nDatabase connection might not be working properly");
        }
        this.setLocationRelativeTo(null);
    }

    public void CurrentDate() {
        //For displaying the date
        Calendar dateandtimeone = new GregorianCalendar();
        int month = dateandtimeone.get(Calendar.MONTH);
        int year = dateandtimeone.get(Calendar.YEAR);
        int day = dateandtimeone.get(Calendar.DAY_OF_MONTH);

        //MenuCurrentDate.setText((month + 1) + "/" + day + "/" + year);

        /*
        int second = dateandtimeone.get(Calendar.SECOND);
        int minute = dateandtimeone.get(Calendar.MINUTE);
        int hour = dateandtimeone.get(Calendar.HOUR);
        
        MenuCurrentTime.setText(hour + ":" + minute + ":" + second);
         */
    }

    //For highlighting the found word in the JTextArea
    class HighlightFind extends DefaultHighlighter.DefaultHighlightPainter {

        public HighlightFind(Color c) {
            super(c);

        }

    }
    //Set color highlight to the word that is found
    Highlighter.HighlightPainter highlightpaintfind = new HighlightFind(Color.yellow);

    //Fore removing the highlight:
    public void removeTheHighlight(JTextComponent componentToRemoveHighlight) {
        Highlighter highlightremoval = componentToRemoveHighlight.getHighlighter();
        Highlighter.Highlight[] highlightremovaltwo = highlightremoval.getHighlights();

        for (int i = 0; i < highlightremovaltwo.length; i++) {
            if (highlightremovaltwo[i].getPainter() instanceof HighlightFind) {
                highlightremoval.removeHighlight(highlightremovaltwo[i]);
            }
        }

    }

    public void highlight(JTextComponent textComponent, String patternlight) {

        removeTheHighlight(textComponent);
        try {

            Highlighter lighttheword = textComponent.getHighlighter();
            Document documentlight = textComponent.getDocument();
            String textlight = documentlight.getText(0, documentlight.getLength());
            int pos = 0;
            
            while ((pos = textlight.toUpperCase().indexOf(patternlight.toUpperCase(), pos)) >= 0) {
                lighttheword.addHighlight(pos, pos + patternlight.length(), highlightpaintfind);

                pos += patternlight.length();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while finding the word");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTB = new javax.swing.JTable();
        sectionLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        USNLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        NumberText = new javax.swing.JTextField();
        SectionText = new javax.swing.JTextField();
        FirstNameText = new javax.swing.JTextField();
        LastNameText = new javax.swing.JTextField();
        USNText = new javax.swing.JTextField();
        StatusBox = new javax.swing.JComboBox<>();
        InsertButton = new javax.swing.JButton();
        tableLabel = new javax.swing.JLabel();
        TableNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        calendarComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem10.setText("jMenuItem10");
        jPopupMenu1.add(jMenuItem10);

        jMenuItem11.setText("jMenuItem11");
        jPopupMenu1.add(jMenuItem11);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Records");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setToolTipText("");

        myTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Section", "No", "First Name", "Last Name", "USN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myTB.setEditingColumn(0);
        myTB.setEditingRow(0);
        myTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTBMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                myTBMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                myTBMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(myTB);
        if (myTB.getColumnModel().getColumnCount() > 0) {
            myTB.getColumnModel().getColumn(0).setResizable(false);
            myTB.getColumnModel().getColumn(1).setResizable(false);
            myTB.getColumnModel().getColumn(2).setResizable(false);
            myTB.getColumnModel().getColumn(3).setResizable(false);
            myTB.getColumnModel().getColumn(4).setResizable(false);
        }

        sectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        sectionLabel.setText("Section");

        numberLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numberLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberLabel.setText("No");

        firstNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        firstNameLabel.setText("FirstName");

        USNLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        USNLabel.setForeground(new java.awt.Color(255, 255, 255));
        USNLabel.setText("USN");

        lastNameLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        lastNameLabel.setText("LastName");

        statusLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Status");

        NumberText.setEditable(false);
        NumberText.setText("AUTO_INCREMENT");
        NumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberTextActionPerformed(evt);
            }
        });
        NumberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumberTextKeyTyped(evt);
            }
        });

        FirstNameText.setText("jTextField3");

        LastNameText.setText("jTextField4");

        USNText.setText("jTextField5");

        StatusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Present", "Late", "Absent", "Excused" }));

        InsertButton.setText("Insert");
        InsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButtonActionPerformed(evt);
            }
        });

        tableLabel.setForeground(new java.awt.Color(255, 255, 255));
        tableLabel.setText("Table Name: ");

        TableNameLabel.setForeground(tableLabel.getForeground());
        TableNameLabel.setText("jLabel2");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Move to Recycle Bin");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");

        jButton5.setText("Mark Record");

        jButton6.setText("Recycle Bin");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceappplusplusembeddeddatabase/iconfinder_magnifyingglass_1055031.png"))); // NOI18N
        jButton7.setText("No");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceappplusplusembeddeddatabase/iconfinder_magnifyingglass_1055031.png"))); // NOI18N
        jButton8.setText("Section");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceappplusplusembeddeddatabase/iconfinder_magnifyingglass_1055031.png"))); // NOI18N
        jButton9.setText("FirstName");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceappplusplusembeddeddatabase/iconfinder_magnifyingglass_1055031.png"))); // NOI18N
        jButton10.setText("LastName");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendanceappplusplusembeddeddatabase/iconfinder_magnifyingglass_1055031.png"))); // NOI18N
        jButton11.setText("USN");

        calendarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setForeground(numberLabel.getForeground());
        jLabel1.setText("Calendar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(jButton6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(InsertButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(numberLabel)
                                                                .addGap(45, 45, 45)))
                                                        .addComponent(lastNameLabel)
                                                        .addComponent(USNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(42, 42, 42))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(43, 43, 43)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(sectionLabel)
                                                    .addComponent(jLabel1))
                                                .addGap(68, 68, 68)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SectionText)
                                            .addComponent(LastNameText)
                                            .addComponent(USNText)
                                            .addComponent(StatusBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(FirstNameText)
                                            .addComponent(NumberText, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                            .addComponent(calendarComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)
                                    .addComponent(jButton9)
                                    .addComponent(jButton10)
                                    .addComponent(jButton11))
                                .addGap(59, 59, 59))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tableLabel)
                                .addGap(40, 40, 40)
                                .addComponent(TableNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tableLabel)
                            .addComponent(TableNameLabel))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberLabel)
                            .addComponent(NumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sectionLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SectionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel)
                            .addComponent(FirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(USNLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(USNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(statusLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertButton)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Marked Records Table");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Notes");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTBMouseClicked

    }//GEN-LAST:event_myTBMouseClicked

    private void myTBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTBMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isLeftMouseButton(evt)) {
            int i = myTB.getSelectedRow();

            TableModel model = myTB.getModel();
            
            // Display Slected Row In JTextextFields
            try {
                NumberText.setText(model.getValueAt(i, 0).toString()); //Must start at 0 for first column
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                FirstNameText.setText(model.getValueAt(i, 1).toString()); //First name is in the second column
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "First name field might be empty, please input the first name value for the first name\nError code: " + e);
            }

            try {
                LastNameText.setText(model.getValueAt(i, 2).toString());
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Last name field might be empty, please input the last name value for the last name\nError code: " + e);
                
            }

            try {
                USNText.setText(model.getValueAt(i, 5).toString()); //USN is now in the fifth column
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "USN field might be empty, please input the USN value for the USN\nError code: " + e);
            }

            try {
                SectionText.setText(model.getValueAt(i, 6).toString()); //6 is the seventh column, always think that columns are equals to array implementation
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Section field might be empty, please input the Section value for the Section \nError code: " + e);
            }
            
            try {
                StatusBox.setSelectedItem(model.getValueAt(i, 3).toString());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Status field might be empty, please input the Section value for the Section \nError code: " + e);
            }
            
            
            
            
            

        }
        
    }//GEN-LAST:event_myTBMousePressed

    private void myTBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTBMouseReleased
        // TODO add your handling code here:

        if (evt.isPopupTrigger()) {
            int row = myTB.rowAtPoint(evt.getPoint());
            int[] selectedRows = myTB.getSelectedRows();
            if (!myTB.isRowSelected(1)) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());

            }
        }
        
    }//GEN-LAST:event_myTBMouseReleased

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
        // TODO add your handling code here:
         try {
            
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Ken/Documents/NetBeansProjects/GameListsFromSamples/attendancedatabase.db");
            String query = "INSERT INTO attendancedatabasetable (FirstName, LastName, USN, Section, Status, Calendar)"
                    + "VALUES (?, ?, ?, ?, ?, datetime('now'))";
            
            pst = con.prepareStatement(query);

            pst.setString(1, FirstNameText.getText());
            pst.setString(2, LastNameText.getText());
            pst.setString(3, USNText.getText());
            pst.setString(4, SectionText.getText());
            pst.setString(5, StatusBox.getSelectedItem().toString());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Inserted!");
            
            Data();
            ClearTextFields();
            retrieveDataComboBox();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate entry \n Error:" + ex);

        }
    }//GEN-LAST:event_InsertButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void NumberTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumberTextKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || Character.isDigit(c) || Character.isISOControl(c)) {
            NumberText.setEditable(true);

        } else {
            NumberText.setEditable(false);
        }
    }//GEN-LAST:event_NumberTextKeyTyped

    private void NumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumberTextActionPerformed

    private void calendarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarComboBoxActionPerformed
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Ken/Documents/NetBeansProjects/GameListsFromSamples/attendancedatabase.db");
            String sql = "SELECT * FROM attendancedatabasetable WHERE Calendar = " + "'" + calendarComboBox.getSelectedItem().toString() + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            myTB.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_calendarComboBoxActionPerformed
    //To pick a record based on the account
    
    
    
    public void Data() {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Ken/Documents/NetBeansProjects/GameListsFromSamples/attendancedatabase.db");
            String changeTableContentByAccount = "SELECT * FROM attendancedatabasetable";
            pst = con.prepareStatement(changeTableContentByAccount);
            rs = pst.executeQuery();
            Student_Register.myTB.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ClearTextFields() {
        try {
            NumberText.setText("");
            SectionText.setText("");
            FirstNameText.setText("");
            LastNameText.setText("");
            USNText.setText("");
        } catch (Exception e) {
            NumberText.setText("");
            SectionText.setText("");
            FirstNameText.setText("");
            LastNameText.setText("");
            USNText.setText("");
            JOptionPane.showMessageDialog(null, "Succesfully cleaned the text fields after an error occured");
        }
    }
    
    public void retrieveDataComboBox() {
        try {
            String sql = "SELECT COUNT(*) AS `Rows`, `Calendar` FROM `attendancedatabasetable` GROUP BY `Calendar` ORDER BY `Calendar` ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String date = rs.getString("Calendar");
                calendarComboBox.addItem(date);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    /* //Calendar for combobox is now commented out because some data calendar values are 
    public void calendar () {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancedatabase?useTimezone=true&serverTimezone=UTC", "root", "");
            String findCalendar = "SELECT Calendar FROM database_rec WHERE Section LIKE '" + sectionSelectionComboBox.getSelectedItem().toString() + "'";
            pst = con.prepareStatement(findCalendar);
            rs = pst.executeQuery(findCalendar);
            while (rs.next()) {
                String calendarSearch = rs.getString("Calendar");
                calendarComboBox.addItem(calendarSearch);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FirstNameText;
    private javax.swing.JButton InsertButton;
    private javax.swing.JTextField LastNameText;
    private javax.swing.JTextField NumberText;
    private javax.swing.JTextField SectionText;
    private javax.swing.JComboBox<String> StatusBox;
    private javax.swing.JLabel TableNameLabel;
    public static javax.swing.JLabel USNLabel;
    private javax.swing.JTextField USNText;
    private javax.swing.JComboBox<String> calendarComboBox;
    public static javax.swing.JLabel firstNameLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lastNameLabel;
    public static javax.swing.JTable myTB;
    public static javax.swing.JLabel numberLabel;
    public static javax.swing.JLabel sectionLabel;
    public static javax.swing.JLabel statusLabel;
    private javax.swing.JLabel tableLabel;
    // End of variables declaration//GEN-END:variables
}
