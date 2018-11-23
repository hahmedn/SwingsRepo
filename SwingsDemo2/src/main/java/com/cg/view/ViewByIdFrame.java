package com.cg.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

import com.cg.dao.StudentDaoImpl;
import com.cg.entity.Student;

public class ViewByIdFrame {

    private JFrame frame;
    private JTextField textFieldId;

    private JScrollPane scrollPane;

    private JTable table_Student;
    DefaultTableModel model;

    StudentDaoImpl stDao = new StudentDaoImpl();

    /**
     * Launch the application.
     */
    public void viewByIdScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewByIdFrame window = new ViewByIdFrame();
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
    public ViewByIdFrame() {
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

        JLabel lblEnterTheStudent = new JLabel("Enter the Student Id");
        lblEnterTheStudent.setBounds(55, 38, 168, 14);
        frame.getContentPane().add(lblEnterTheStudent);

        textFieldId = new JTextField();
        textFieldId.setBounds(233, 35, 86, 20);
        frame.getContentPane().add(textFieldId);
        textFieldId.setColumns(10);

        model = new DefaultTableModel();
        table_Student = new JTable(model);

        JButton btnSelect = new JButton("Select");
        btnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                model.addColumn("Student Id");
                model.addColumn("Student Name");
                model.addColumn("Student Rollno");

                scrollPane = new JScrollPane();
                scrollPane.setBounds(27, 104, 380, 103);
                frame.getContentPane().add(scrollPane);

                scrollPane.setViewportView(table_Student);

                int id = Integer.parseInt(textFieldId.getText());

                Student s = new Student();
                s = stDao.getStudentById(id);

                model.addRow(new String[]{ String.valueOf(s.getId()), s.getName(), String.valueOf(s.getRollno()) });

                System.out.println(textFieldId.getText());
                if (textFieldId.getText().equals("")) {
                    setEnabled(false);
                }
            }
        });

        btnSelect.setBounds(160, 70, 89, 23);
        frame.getContentPane().add(btnSelect);

        String content = textFieldId.getText();
        int offset = 5;
        int length = 10;

        try {
            content = textFieldId.getText(offset, length);
            System.out.println(content);
        } catch (BadLocationException ex) {
            // invalid offset/length
        }
    }

    protected void setEnabled(boolean b) {
        // TODO(hahmedn) provide sensible implementation
        
    }
}
