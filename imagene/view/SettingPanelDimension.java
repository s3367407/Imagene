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

public class SettingPanelDimension extends JPanel {

    private JTextField imageWidth;
    //private JLabel imageHeight;
    private JTextField imageHeight;
    private JLabel pixel_width;
    private JLabel pixel_height;



    public SettingPanelDimension()
    {
        imageHeight=new JTextField( );
        imageWidth=new JTextField( );

        pixel_width=new JLabel("pixels");
        pixel_height=new JLabel("pixels");

//        imageHeight=new JLabel(" x 800");
        imageWidth.setPreferredSize(new Dimension(50,20));
        imageHeight.setPreferredSize(new Dimension(50,20));



        setBorder(new EmptyBorder(0,0,0,0));
        setLayout(new GridBagLayout());
        GridBagConstraints constraint=new GridBagConstraints();

        constraint.anchor= GridBagConstraints.LINE_END; //0 column, texts display at the right
        constraint.weightx=0.5;
        constraint.weighty=0.5;

        constraint.gridx=0;
        constraint.gridy=0;
        add(imageWidth,constraint); //set labelCoordinate to 0,0



        constraint.insets=new Insets(10,30,10,10);
        constraint.gridx=1;
        constraint.gridy=0;
        add(imageHeight,constraint);//set radioButtonCartesian to 0,1





    }

    public JTextField getImageHeight() {
        return imageHeight;
    }

    public JTextField getImageWidth() {
        return imageWidth;
    }
}
