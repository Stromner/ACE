package ace.ui.components;

import ace.core.events.DataLayerInitiatedEvent;
import ace.ui.components.panels.CharacterPanel;
import ace.ui.components.panels.CheatPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Root panel to add all swing containers to
 */
@Component
@ConditionalOnProperty(name = "editor.live.boot")
public class ContentPanel extends JPanel {
    @Autowired
    private CharacterPanel characterPanel;
    @Autowired
    private CheatPanel cheatPanel;
    private JTabbedPane sidebar;

    @PostConstruct
    private void init() {
        setLayout(new GridLayout());
        sidebar = new JTabbedPane(JTabbedPane.LEFT);
        sidebar.addTab("Character", characterPanel);
        sidebar.addTab("Skills", new JPanel());
        sidebar.addTab("Cheats", cheatPanel);
    }

    /**
     * @param event triggers upon loading a save file
     */
    @EventListener
    public void onDatabaseInitiatedEvent(DataLayerInitiatedEvent event) {
        removeAll();
        try {
            characterPanel.renderData();
            cheatPanel.renderData();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        add(sidebar);
        revalidate();
    }
}
