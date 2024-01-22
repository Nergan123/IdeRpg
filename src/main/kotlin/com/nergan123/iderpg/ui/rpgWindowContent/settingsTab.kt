package com.nergan123.iderpg.ui.rpgWindowContent

import com.nergan123.iderpg.state.SettingsTabState
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.Service
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.bindText
import com.intellij.ui.dsl.builder.panel
import java.awt.BorderLayout
import javax.swing.BorderFactory
import javax.swing.JPanel

@Service
class SettingsTab {
    val contentPanel: JPanel = JPanel()
    private val settingsPanel: DialogPanel = createPanel()

    init {
        contentPanel.layout = BorderLayout(0, 20)
        contentPanel.border = BorderFactory.createEmptyBorder(40, 10, 0, 0)
        contentPanel.add(this.settingsPanel, BorderLayout.PAGE_START)
    }

    companion object {
        val instance: SettingsTab
            get() = ApplicationManager.getApplication().getService(SettingsTab::class.java)
    }

    private fun doOkAction(){
        settingsPanel.apply()
        CharacterInfo.instance.update()
    }

    private fun createPanel(): DialogPanel {
        return panel {
            row("Character Name:") {
                textField().bindText(SettingsTabState.instance::characterName)
            }
            row {
                button("Apply"){ doOkAction() }
            }
        }
    }
}