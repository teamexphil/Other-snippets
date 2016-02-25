import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: PHIMCD
 * Date: 23/03/15
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class MandelDraw extends JFrame implements ActionListener{

    private JButton generateMandel;
    private JTextField aCornertextField;
    private JTextField bCornertextField;
    private JTextField side;
    private MandelPanel panel;


    public MandelDraw() {

        initUI();
    }

    private void initUI() {
        setTitle("MandelDraw");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(MandelPanel.SIZE, MandelPanel.SIZE + 100);
        getContentPane().setLayout(new BorderLayout());
        panel = new MandelPanel();
        add(panel,BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2,4));

        JLabel acornerLabel = new JLabel("Acorner");
        controlPanel.add(acornerLabel);

        JLabel bcornerLabel = new JLabel("Bcorner");
        controlPanel.add(bcornerLabel);

        JLabel sideLabel = new JLabel("Side");
        controlPanel.add(sideLabel);

        JPanel inputPanel = new JPanel();
        controlPanel.add(inputPanel);

        aCornertextField = new JTextField("-2");
        controlPanel.add(aCornertextField);

        bCornertextField = new JTextField("-1.25");
        controlPanel.add(bCornertextField);

        side = new JTextField("2.5");
        controlPanel.add(side);

        generateMandel = new JButton("Run");
        controlPanel.add(generateMandel);
        generateMandel.addActionListener(this);

        add(controlPanel,BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == generateMandel){
            System.out.println("ACorner: " + aCornertextField.getText() + " BCorner: " + bCornertextField.getText() + " Side: " + side.getText());
        }
        panel.paintComponent(panel.getGraphics(),Double.parseDouble(aCornertextField.getText()), Double.parseDouble(bCornertextField.getText()),Double.parseDouble(side.getText()));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                MandelDraw mandelDraw = new MandelDraw();
                mandelDraw.setVisible(true);
            }
        });
    }
}
