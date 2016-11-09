package imagene.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/*****************************************
 * Written by Avishkar Giri (s3346203)   *
 * for                                   *
 * Programming Project 1                 *
 * SP3 2016                              *
 ****************************************/

public class SettingPanelSymmetry extends JPanel{

        private JRadioButton radioButtonSymmetric;
        private JRadioButton radioButtonAsymmetric;

       public SettingPanelSymmetry() {
           radioButtonSymmetric=new JRadioButton("Symmetric");
           radioButtonAsymmetric=new JRadioButton("Asymmetric");


           setBorder(new EmptyBorder(10,10,10,10));
           setLayout(new GridBagLayout());
           GridBagConstraints constraint=new GridBagConstraints();

           constraint.anchor=GridBagConstraints.LINE_START; //0 column, texts display at the right
           constraint.weightx=0.5;
           constraint.weighty=0.5;
           constraint.gridx=0;
           constraint.gridy=0;
           add(radioButtonSymmetric,constraint); //set labelCoordinate to 0,0

           constraint.gridx=1;
           constraint.gridy=0;
           add(radioButtonAsymmetric,constraint);//set radioButtonCartesian to 0,1
       }

    public JRadioButton getRadioButtonSymmetric()
    {
        return radioButtonSymmetric;
    }

    public JRadioButton getRadioButtonAsymmetric()
    {
        return radioButtonAsymmetric;
    }
}
