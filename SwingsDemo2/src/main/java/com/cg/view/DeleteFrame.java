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

public class DeleteFrame {

    private JFrame frame;
    private JTextField textFieldId;
    private JButton btnDelete;

    StudentDaoImpl stDao = new StudentDaoImpl();

    /**
     * Launch the application.
     */
    public void DeleteScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteFrame window = new DeleteFrame();
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
    public DeleteFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 495, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblEnterTheId = new JLabel("Enter the Id of the student to be deleted");
        lblEnterTheId.setBounds(24, 121, 245, 31);
        frame.getContentPane().add(lblEnterTheId);

        textFieldId = new JTextField();
        textFieldId.setBounds(311, 126, 86, 20);
        frame.getContentPane().add(textFieldId);
        textFieldId.setColumns(10);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(textFieldId.getText());
                    Student st = stDao.getStudentById(id);
                    stDao.deleteStudent(st);

                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                    frame.dispose();
                }
                else if (result == JOptionPane.NO_OPTION) {
                    frame.dispose();
                }
                else if (result == JOptionPane.CANCEL_OPTION) {

                }
            }

        });
        btnDelete.setBounds(219, 200, 89, 23);
        frame.getContentPane().add(btnDelete);
    }

}
