package patterns.observer.memory;

import org.w3c.dom.ls.LSOutput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

// A panel with buttons to create and close sample frames.
@SuppressWarnings("serial")
public class MulticastPanel extends JPanel implements ActionListener {
    private int counter = 0;
    private JButton closeAllButton;

    public MulticastPanel() {
        JButton newButton = new JButton("New");
        this.add(newButton);
        newButton.addActionListener(this);

        closeAllButton = new JButton("Close all");
        this.add(closeAllButton);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        SimpleFrame f = new SimpleFrame();
        counter++;
        f.setTitle("Window " + counter);
        f.setSize(250, 150);
        f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		closeAllButton.addActionListener(f);
		System.out.println("HUHU");

	}



    private class SimpleFrame extends JFrame implements ActionListener {
        byte[][] buf = new byte[1024][];

        {
            for (int i = 0; i < 1024; i++) {
                buf[i] = new byte[1024 * 256];
            }
        }


		@Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println("Window action Nr. " + counter);
			System.out.println("simpleframe " + this.rootPane);

			closeAllButton.removeActionListener(this);

//			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



            this.buf = null;

			this.dispose();

			System.gc();
        }


		public void finalize() throws Throwable {
            try {
                System.out.println("FINAL WISH");

            } finally {
                System.out.println("IS FINALIZED");

                super.finalize();
            }

        }


    }
}
