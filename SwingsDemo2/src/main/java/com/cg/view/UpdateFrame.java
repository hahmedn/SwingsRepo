package com.cg.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cg.dao.StudentDaoImpl;
import com.cg.entity.Student;

public class UpdateFrame {

    private JFrame frame;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTable tableStudent;

    DefaultTableModel model;

    StudentDaoImpl stDao = new StudentDaoImpl();
    private JLabel lblStudentName;
    private JTextField textFieldName;
    private JLabel lblStudentRollno;
    private JTextField textFieldRollno;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public void updateScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateFrame window = new UpdateFrame();
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
    public UpdateFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 606, 423);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UPDATE STUDENT DATABASE");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("Enter the Student Id");
        label.setBounds(111, 39, 168, 14);
        contentPane.add(label);

        textFieldId = new JTextField();
        textFieldId.setColumns(10);
        textFieldId.setBounds(289, 36, 86, 20);
        contentPane.add(textFieldId);

        model = new DefaultTableModel();
        tableStudent = new JTable(model);

        JButton button = new JButton("Select");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.addColumn("Student Id");
                model.addColumn("Student Name");
                model.addColumn("Student Rollno");

                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(20, 137, 504, 40);
                contentPane.add(scrollPane);
                scrollPane.setViewportView(tableStudent);

                int id = Integer.parseInt(textFieldId.getText());

                Student s = new Student();
                s = stDao.getStudentById(id);

                model.addRow(new String[]{ String.valueOf(s.getId()), s.getName(), String.valueOf(s.getRollno()) });
            }
        });
        button.setBounds(216, 71, 89, 23);
        contentPane.add(button);

        lblStudentName = new JLabel("Student Name");
        lblStudentName.setBounds(154, 236, 103, 14);
        contentPane.add(lblStudentName);

        textFieldName = new JTextField();
        textFieldName.setBounds(305, 233, 86, 20);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        lblStudentRollno = new JLabel("Student Rollno");
        lblStudentRollno.setBounds(154, 267, 103, 14);
        contentPane.add(lblStudentRollno);

        textFieldRollno = new JTextField();
        textFieldRollno.setColumns(10);
        textFieldRollno.setBounds(305, 264, 86, 20);
        contentPane.add(textFieldRollno);

        btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setId(Integer.parseInt(textFieldId.getText()));
                s.setName(textFieldName.getText());
                s.setRollno(Integer.parseInt(textFieldRollno.getText()));

                if (stDao.updateStudent(s)) {
                    JOptionPane.showMessageDialog(null, "updated successfully");
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "update failed");
                    frame.dispose();
                }
            }

        });
        btnNewButton.setBounds(244, 301, 89, 23);
        contentPane.add(btnNewButton);

    }

}
