package com.github.nergan123.iderpg

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import java.awt.BorderLayout
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel


internal class IdeRpg : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent = RpgWindowContent(toolWindow)
        val content = ContentFactory.getInstance().createContent(toolWindowContent.contentPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }

    private class RpgWindowContent(toolWindow: ToolWindow) {
        val contentPanel: JPanel = JPanel()

        init {
            contentPanel.layout = BorderLayout(0, 20)
            contentPanel.border = BorderFactory.createEmptyBorder(40, 0, 0, 0)
            contentPanel.add(this.createCharacterInfoPanel(), BorderLayout.PAGE_START)
        }

        private fun createCharacterInfoPanel(): JPanel {
            val controlsPanel = JPanel()

            val characterLabel = JLabel()
            characterLabel.setText("My Character")
            controlsPanel.add(characterLabel)

            return controlsPanel
        }
    }
}