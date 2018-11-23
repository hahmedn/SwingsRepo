package com.cg.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.cg.dao.StudentDaoImpl;
import com.cg.entity.Student;

public class InsertFrame {

    private JFrame frame;
    private JTextField textFieldName;
    private JTextField textFieldRollno;

    StudentDaoImpl stDao = new StudentDaoImpl();

    /**
     * Launch the application.
     */
    public void insertScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertFrame window = new InsertFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public InsertFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblEnterTheStudent = new JLabel("ENTER THE STUDENT DETAILS");
        lblEnterTheStudent.setBounds(142, 55, 198, 14);
        frame.getContentPane().add(lblEnterTheStudent);

        JLabel lblStudentId = new JLabel("Student Name");
        lblStudentId.setBounds(28, 111, 114, 14);
        frame.getContentPane().add(lblStudentId);

        JLabel lblStudentRollno = new JLabel("Student Rollno");
        lblStudentRollno.setBounds(28, 149, 114, 14);
        frame.getContentPane().add(lblStudentRollno);

        textFieldName = new JTextField();
        textFieldName.setBounds(193, 108, 175, 20);
        frame.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        textFieldRollno = new JTextField();
        textFieldRollno.setBounds(193, 146, 175, 20);
        frame.getContentPane().add(textFieldRollno);
        textFieldRollno.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setName(textFieldName.getText());
                s.setRollno(Integer.parseInt(textFieldRollno.getText()));

                if (stDao.insertStudent(s) == 1) {
                    JOptionPane.showMessageDialog(null, "Added successfully");
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Add failed");
                }
            }
        });
        btnSave.setBounds(142, 206, 89, 23);
        frame.getContentPane().add(btnSave);
    }
}
