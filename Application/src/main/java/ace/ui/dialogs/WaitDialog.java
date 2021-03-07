package ace.ui.dialogs;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog to display while stuff is going on in the background
 */
public class WaitDialog extends JDialog {
    private JLabel waitLabel;

    /**
     * @param frame to display dialog in front of
     */
    public WaitDialog(Frame frame) {
        super(frame);

        init();
    }

    /**
     * @param displayText to be displayed in the dialog
     */
    public void showWaitDialog(String displayText) {
        if (waitLabel != null) {
            remove(waitLabel);
        }
        waitLabel = new JLabel(displayText);
        add(waitLabel);
        pack();
        setLocationRelativeTo(getParent());

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                setVisible(true);
                return null;
            }
        };
        worker.execute();
    }

    /**
     * Hide the dialog
     */
    public void closeWaitDialog() {
        setVisible(false);
    }

    private void init() {
        setUndecorated(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }
}
