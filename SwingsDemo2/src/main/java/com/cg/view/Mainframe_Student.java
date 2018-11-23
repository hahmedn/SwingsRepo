package com.cg.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Mainframe_Student extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainframe_Student frame = new Mainframe_Student();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Mainframe_Student() {
        setBackground(Color.LIGHT_GRAY);
        setTitle("Student Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 541, 381);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.info);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblWelcomeToStudent = new JLabel("WELCOME TO STUDENT DATABASE");
        lblWelcomeToStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcomeToStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblWelcomeToStudent.setBounds(99, 61, 329, 56);
        contentPane.add(lblWelcomeToStudent);

        JButton btnAddStudent = new JButton("Add student");
        btnAddStudent.setBackground(Color.LIGHT_GRAY);
        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InsertFrame iframe = new InsertFrame();
                iframe.insertScreen();
            }
        });
        btnAddStudent.setBounds(63, 160, 173, 23);
        contentPane.add(btnAddStudent);

        JButton btnDeleteStudent = new JButton("Delete Student");
        btnDeleteStudent.setBackground(Color.LIGHT_GRAY);
        btnDeleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteFrame dframe = new DeleteFrame();
                dframe.DeleteScreen();
            }
        });
        btnDeleteStudent.setBounds(63, 205, 173, 23);
        contentPane.add(btnDeleteStudent);

        JButton btnViewByIdStudent = new JButton("View the Student by Id");
        btnViewByIdStudent.setBackground(Color.LIGHT_GRAY);
        btnViewByIdStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ViewByIdFrame vIdframe = new ViewByIdFrame();
                vIdframe.viewByIdScreen();
            }
        });
        btnViewByIdStudent.setBounds(283, 160, 173, 23);
        contentPane.add(btnViewByIdStudent);

        JButton btnViewAllStudents = new JButton("View All Students");
        btnViewAllStudents.setBackground(Color.LIGHT_GRAY);
        btnViewAllStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewAllFrame vAllframe = new ViewAllFrame();
                vAllframe.viewAllScreen();
            }
        });
        btnViewAllStudents.setBounds(283, 205, 173, 23);
        contentPane.add(btnViewAllStudents);

        JButton btnUpdateStudent = new JButton("Update Student");
        btnUpdateStudent.setForeground(Color.BLACK);
        btnUpdateStudent.setBackground(Color.LIGHT_GRAY);
        btnUpdateStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateFrame uframe = new UpdateFrame();
                uframe.updateScreen();
            }
        });
        btnUpdateStudent.setBounds(63, 250, 173, 23);
        contentPane.add(btnUpdateStudent);
    }
}
