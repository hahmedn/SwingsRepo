package com.cg.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cg.dao.StudentDaoImpl;
import com.cg.entity.Student;

public class ViewAllFrame {

    private JFrame frame;

    DefaultTableModel model;
    private JTable table_Student;

    StudentDaoImpl stDao = new StudentDaoImpl();

    /**
     * Launch the application.
     */
    public void viewAllScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAllFrame window = new ViewAllFrame();
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
    public ViewAllFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 549, 395);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        model = new DefaultTableModel();
        table_Student = new JTable(model);

        model.addColumn("Student Id");
        model.addColumn("Student Name");
        model.addColumn("Student Rollno");

        table_Student.removeAll();
        for (Student s : stDao.getStudentDetail()) {
            model.addRow(new String[]{ String.valueOf(s.getId()), s.getName(), String.valueOf(s.getRollno()) });

        }
        JScrollPane scrollPane = new JScrollPane(table_Student);
        scrollPane.setBounds(25, 38, 482, 131);
        frame.getContentPane().add(scrollPane);
        scrollPane.setViewportView(table_Student);

    }
}
