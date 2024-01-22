package com.nergan123.iderpg.ui.rpgWindowContent

import com.nergan123.iderpg.state.SettingsTabState
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants


@Service
class CharacterInfo {
    val contentPanel: JPanel = JPanel()
    private val skillDiagram: SkillDiagram = SkillDiagram(arrayOf("Java", "Python", "Kotlin", "C++", "C#", "JavaScript"))

    init {
        contentPanel.layout = BorderLayout(0, 20)
        contentPanel.border = BorderFactory.createEmptyBorder(40, 0, 0, 0)
        contentPanel.add(this.createCharacterInfoPanel(), BorderLayout.PAGE_START, 0)
        contentPanel.add(this.createSkillDiagramPanel(300, 300), BorderLayout.WEST, 1)
    }

    companion object {
        val instance: CharacterInfo
            get() = ApplicationManager.getApplication().getService(CharacterInfo::class.java)
    }

    fun update(){
        contentPanel.remove(0)
        contentPanel.add(this.createCharacterInfoPanel(), BorderLayout.PAGE_START, 0)
    }

    private fun createCharacterInfoPanel(): JPanel {
        val controlsPanel = JPanel()

        val characterLabel = JLabel()
        characterLabel.text = SettingsTabState.instance.characterName
        characterLabel.font = Font("Ubuntu", Font.BOLD, 20)
        controlsPanel.add(characterLabel, BorderLayout.CENTER)

        return controlsPanel
    }

    private fun createSkillDiagramPanel(width: Int, height: Int): JPanel {
        val diagramPanel = JPanel(BorderLayout(0, 0))
        diagramPanel.preferredSize = Dimension(width, height)

        val diagramLabel = JLabel("Skills:", SwingConstants.LEFT)
        diagramLabel.font = Font("Ubuntu", Font.BOLD, 16)
        diagramPanel.add(diagramLabel, BorderLayout.PAGE_START)
        skillDiagram.setSize(width, height)
        diagramPanel.add(skillDiagram, BorderLayout.NORTH)

        return diagramPanel
    }
}