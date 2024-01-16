package com.github.nergan123.iderpg.ui.rpgWindowContent

import com.github.nergan123.iderpg.state.SettingsTabState
import java.awt.BorderLayout
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel


class CharacterInfo {
    val contentPanel: JPanel = JPanel()

    init {
        contentPanel.layout = BorderLayout(0, 20)
        contentPanel.border = BorderFactory.createEmptyBorder(40, 0, 0, 0)
        contentPanel.add(this.createCharacterInfoPanel(), BorderLayout.PAGE_START)
    }

    private fun createCharacterInfoPanel(): JPanel {
        val controlsPanel = JPanel()

        val characterLabel = JLabel()
        characterLabel.text = SettingsTabState.instance.characterName
        controlsPanel.add(characterLabel, BorderLayout.CENTER)

        return controlsPanel
    }
}